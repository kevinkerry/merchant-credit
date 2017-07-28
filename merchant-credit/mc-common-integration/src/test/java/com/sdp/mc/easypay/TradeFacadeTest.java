package com.sdp.mc.easypay;



import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.sdp.mc.easypay.vo.TradeRequest;


public class TradeFacadeTest {
	

	@Test
	public void query(){
		String url="http://10.241.80.140:8085/easypay-services/services/rest/trade/query";
		
		HttpHeaders headers=new HttpHeaders();
//		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		/*TradeRequest request=new TradeRequest();
		request.setMerchantNo("93618648");
		request.setPageNo(1);
		request.setPageSize(10);*/
		RestTemplate temp=new RestTemplate();
		
//		temp.getMessageConverters().add(new TradeRequestConvert());
		String request="merchantNo=93618648&pageNo=1&pageSize=10";
		HttpEntity<String> entity=new HttpEntity<String>(request,headers);
		String resp=temp.postForObject(url, entity, String.class);
		System.out.print(resp);
		
	}
	
	
//	@Test
	public void query3() {
		ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
        Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
		String url="http://10.241.80.140:8085/easypay-services/services/rest/trade/query";
		HttpClient client=new HttpClient();
		
		PostMethod post=new PostMethod(url);
		post.addParameter("merchantNo", "93618648");
		post.addParameter("pageNo", "1");
		post.addParameter("pageSize", "10");
		
		try {
			int httpCode = client.executeMethod(post);
			if(httpCode==200){
				String result=IOUtils.toString(post.getResponseBodyAsStream(), "UTF-8");
				System.out.println(result);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
	}
	class TradeRequestConvert extends AbstractHttpMessageConverter<TradeRequest>{

		@Override
		protected boolean supports(Class<?> clazz) {
			return TradeRequest.class.equals(clazz);
		}

		
		@Override
		public boolean canWrite(Class<?> clazz, MediaType mediaType) {
//			return super.canWrite(clazz, mediaType);
			return TradeRequest.class.equals(clazz);
		}


		@Override
		protected TradeRequest readInternal(
				Class<? extends TradeRequest> clazz,
				HttpInputMessage inputMessage) throws IOException,
				HttpMessageNotReadableException {
			System.out.println("222222");
			
			return null;
		}

		@Override
		protected void writeInternal(TradeRequest t,
				HttpOutputMessage outputMessage) throws IOException,
				HttpMessageNotWritableException {
			StringBuffer sb=new StringBuffer();
			Field[] Fields=t.getClass().getDeclaredFields();
			for(Field field:Fields){
				String name=field.getName();
				try {
					String val=BeanUtils.getProperty(t, name);
					if(StringUtils.isNotBlank(val)){
						sb.append(name).append("=").append(val).append("&");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			sb.deleteCharAt(sb.lastIndexOf("&"));
			Charset charset = outputMessage.getHeaders().getContentType().getCharSet();
			FileCopyUtils.copy(sb.toString(), new OutputStreamWriter(outputMessage.getBody(), charset));
		}
		
	}
}
