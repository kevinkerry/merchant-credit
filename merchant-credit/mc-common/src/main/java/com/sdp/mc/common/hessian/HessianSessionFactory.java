package com.sdp.mc.common.hessian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

/**
 * 创建HessianSession的Factory。
 * 
 * @author mingxu
 * 
 */
public class HessianSessionFactory {
	/**
	 * 所有的Session。这里使用ConnectionURL来标识Session。不同的Class调用、相同的服务器地址，也使用同一个Session.
	 * 
	 * 原因是希望提供SessionFactory的易用性：如果每次都创建一个新的Session，就需要调用方主动去释放Session，否则
	 * Session里面的内容越来越多。 因此使用ConnectionUrl来标识的好处是不需要调用方主动释放。
	 * 
	 */
	private Map<String, HessianSession<?>> sessions = new HashMap<String, HessianSession<?>>();

	/**
	 * 各个Module轮询的Offset
	 * 
	 */
	private Map<RemotingModuleEnum, AtomicInteger> offsets = new HashMap<RemotingModuleEnum, AtomicInteger>();

	private static HessianSessionFactory instance = new HessianSessionFactory();

	private static Logger log = LoggerFactory.getLogger(HessianSessionFactory.class);

	private AtomicLong sessionIdCounter = new AtomicLong(0L);

	private HessianSessionFactory() {
	}

	public static HessianSessionFactory getInstance() {
		return instance;
	}

	/**
	 * 不希望保存Session,只希望使用轮询的方式找到一个Server。
	 * 
	 * @param <T>
	 * @param module
	 * @param serviceInterface
	 * @return
	 */
	public synchronized <T> T getServiceWithoutSession(RemotingModuleEnum module, Class<T> serviceInterface) {
		return this.createSession(module, serviceInterface).getHessianService();
	}

	/**
	 * 创建一个调用的Session，当一个服务有多个ConnectionUrl、但是一批请求只希望调用某一个URL时使用。。
	 * <p>
	 * 
	 * @param <T>
	 * @param module
	 * @param serviceInterface
	 * @return
	 */
	public synchronized <T> HessianSession<T> createSession(RemotingModuleEnum module, Class<T> serviceInterface) {
		if (!offsets.containsKey(module)) {
			offsets.put(module, new AtomicInteger(0));
		}

		AtomicInteger offset = this.offsets.get(module);
		List<String> urls = module.getAllUrls();

		int tryTimes = 0;
		while (true) {
			String connUrl = urls.get(offset.get());
			offset.set((offset.get() + 1) % urls.size());
			NoOperationService nopTest = RemotingCallUtil.getHessianService(connUrl, NoOperationService.class);

			try {
				// 作为NOOP(No operation)调用，测试调用是否成功（对方是否可用）
				nopTest.nop();

				// 测试OK
				return this.exeCreateSession(connUrl, serviceInterface, RemotingCallUtil.getHessianService(connUrl, serviceInterface));
			} catch (Exception ex) {
				log.warn("Connection url test failed." + connUrl, ex);

				if (++tryTimes > urls.size()) {
					// 轮询一遍以后所有的Session均不可用。
					log.error("No availble service for module:" + module.getName());
					throw new RuntimeException("No available connections exists!");
				}

				continue;
			}
		}
	}

	/**
	 * 使用SessionId来获取之前的Session。 这里不会检查Connection的可用性。
	 * 
	 * @param <T>
	 * @param sessionId
	 * @param serviceInterface
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T> HessianSession<T> getSession(long sessionId, Class<T> serviceInterface) {
		for (HessianSession<?> v : this.sessions.values()) {
			if (v.getSessionId() == sessionId) {
				HessianSession<T> target = (HessianSession<T>) v.clone();
				T obj = RemotingCallUtil.getHessianService(v.getConnectionUrl(), serviceInterface);
				target.setHessianService(obj);
				return target;
			}
		}

		log.error("Session id :" + sessionId + " not found.");
		return null;
	}

	/**
	 * 给定一个Session去获得另外一个Service
	 * 
	 * @param <T>
	 * @param hessianSession
	 * @param serviceInterface
	 * @return
	 */
	public synchronized <T> T getServiceBySession(HessianSession<T> hessianSession, Class<T> serviceInterface) {
		return RemotingCallUtil.getHessianService(hessianSession.getConnectionUrl(), serviceInterface);
	}

	@SuppressWarnings("unchecked")
	private <T> HessianSession<T> exeCreateSession(String connUrl, Class<T> cls, T service) {
		if (this.sessions.containsKey(connUrl)) {
			HessianSession<?> prototype = this.sessions.get(connUrl);
			HessianSession<T> target = (HessianSession<T>) prototype.clone();

			target.setHessianService(service);
			return target;
		} else {
			HessianSession<T> session = new HessianSession<T>(service, this.sessionIdCounter.incrementAndGet(), connUrl);
			this.sessions.put(connUrl, session);
			return session;
		}
	}

}
