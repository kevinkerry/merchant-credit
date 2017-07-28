package com.sdp.mc.common.util;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

/**
 * IP工具类
 *
 * @author yangjianhua
 *
 */
public class IPUtils {
	private static final Logger log = LoggerFactory.getLogger(IPUtils.class);
	
	private static final String INIT_LOCAL_IP_ADDRESS = getLocalIp();

	/** 获取服务器IP(该IP在服务器启动后即保持不变) **/
	public static String getServerIp() {
		return INIT_LOCAL_IP_ADDRESS;
	}

	/** 通过动态枚举网卡地址获取本机的外网IP, 如无外网IP则返回本地IP **/
	public static String getLocalIp() {
		String localip = "127.0.0.1";// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP

		try {
			Enumeration<NetworkInterface> netInterfaces =
				NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			boolean finded = false;// 是否找到外网IP
			while (netInterfaces.hasMoreElements() && !finded) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> address = ni.getInetAddresses();
				while (address.hasMoreElements()) {
					ip = address.nextElement();
					if (!ip.isSiteLocalAddress()
							&& !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 外网IP
						netip = ip.getHostAddress();
						finded = true;
						break;
					} else if (ip.isSiteLocalAddress()
							&& !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
						localip = ip.getHostAddress();
					}
				}
			}
		}catch(Exception ex) {
			log.error("enums the nic ip address failed: "+ex.getMessage(), ex);
		}

		if (StringUtils.isNotBlank(netip)) {
			return netip;
		} else {
			return localip;
		}
	}
	/**
	 * 获取本机所有IP
	 *
	 * @return
	 * @throws SocketException
	 */
	public static List<String> getServerIps() throws SocketException {
		List<String> ips = new ArrayList<String>();
		// 根据网卡取本机配置的IP
		Enumeration<?> e1 = (Enumeration<?>) NetworkInterface
				.getNetworkInterfaces();
		while (e1.hasMoreElements()) {
			NetworkInterface ni = (NetworkInterface) e1.nextElement();
			Enumeration<?> e2 = ni.getInetAddresses();
			while (e2.hasMoreElements()) {
				InetAddress ia = (InetAddress) e2.nextElement();
				if (ia instanceof Inet6Address)
					continue;
				String ip = ia.getHostAddress();
				ips.add(ip);
			}
		}
		return ips;
	}

	/**
	 * 获取本机除127.0.0.1外的所有IP
	 *
	 * @return
	 * @throws SocketException
	 */
	public static List<String> getServerIpsExceptLocalHost()
			throws SocketException {
		List<String> allIps = getServerIps();
		List<String> ips = new ArrayList<String>();
		for (String ip : allIps) {
			if (!StringUtils.equalsIgnoreCase(ip, "127.0.0.1")) {
				ips.add(ip);
			}
		}
		return ips;
	}

	/**
	 * 是否是本机IP
	 *
	 * @param compareIp
	 * @return
	 * @throws SocketException
	 */
	public static boolean isThisServer(String compareIp) throws SocketException {
		List<String> ips = IPUtils.getServerIps();
		for (String ip : ips) {
			if (StringUtils.equalsIgnoreCase(ip, compareIp))
				return true;
		}
		return false;
	}

	/**
	 * 得到客户端真实IP地址。若存在反向代理header：http_x_forwarded_for，则取其值，否则，取header:
	 * remote_addr
	 *
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip)
				|| StringUtils.equalsIgnoreCase(ip, "unknown")) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	/**
	 * 返回服务器IP字符串
	 *
	 * @return
	 * @throws SocketException
	 */
	public static String getServerIPsStr() throws SocketException {
		StringBuilder sb = new StringBuilder();
		List<String> ips = IPUtils.getServerIpsExceptLocalHost();
		for (String ip : ips) {
			sb.append(ip);
			sb.append("   ");
		}
		return sb.toString();
	}

	public static String getServerHostAndIPsStr() throws SocketException, UnknownHostException {
		String hostName = InetAddress.getLocalHost().getHostName();
		StringBuilder sb = new StringBuilder();
		sb.append(hostName + ": ");
		List<String> ips = getServerIps();
		for (String ip : ips) {
			sb.append(ip);
			sb.append(";");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public static String getMacAddress(String host) {
		String mac = "";
		StringBuffer sb = new StringBuffer();
		try {
			NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getByName(host));
			byte[] macs = ni.getHardwareAddress();
			for (int i = 0; i < macs.length; i++) {
				mac = Integer.toHexString(macs[i] & 0xFF);
				if (mac.length() == 1) {
					mac = '0' + mac;
				}
				sb.append(mac + "-");
			}
		} catch (SocketException e) {
			log.error("IPUtil.getMacAddress.error" + e.getMessage(), e);
		} catch (UnknownHostException e) {
			log.error("IPUtil.getMacAddress.error", e);
		}
		mac = sb.toString();
		mac = mac.substring(0, mac.length() - 1);
		return mac;
	}
}
