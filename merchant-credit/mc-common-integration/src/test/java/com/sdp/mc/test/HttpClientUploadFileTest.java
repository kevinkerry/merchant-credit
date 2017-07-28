package com.sdp.mc.test;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

/**
 * @author wb-gaoy
 * @version $Id: HttpClientTest.java,v 0.1 2012-4-6 下午1:38:53 wb-gaoy Exp $
 */
public class HttpClientUploadFileTest {

    public void uploadFile(File file, String url) {
        if (!file.exists()) {
            return;
        }
        PostMethod postMethod = new PostMethod(url);
        try {
            //FilePart：用来上传文件的类
        FilePart fp = new FilePart("Filedata", file);
            Part[] parts = { fp };

            //对于MIME类型的请求，httpclient建议全用MulitPartRequestEntity进行包装
            MultipartRequestEntity mre = new MultipartRequestEntity(parts, postMethod.getParams());
            postMethod.setRequestEntity(mre);
            HttpClient client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
            int status = client.executeMethod(postMethod);
            if (status == HttpStatus.SC_OK) {
            	String respose=new String(postMethod.getResponseBody());
            	System.out.println("==="+respose);
            	
                System.out.println(postMethod.getResponseBodyAsString());
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            postMethod.releaseConnection();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HttpClientUploadFileTest test = new HttpClientUploadFileTest();
        test.uploadFile(new File("d:/capture.png"),
            "http://10.241.14.74/Storage/upload.aspx?u=ZQA4AGEAZQAxADYAOAAwAC0AYgAxAGEAMAAtADQAMwBhADAALQBhADcAZQAxAC0AZAA0ADgAMAAyADcAZQBiADEAYgAxAGEAfAAyADAAMQA2ADEAMgAwADYAMQAzADEANQAyADIAfABjADEAMABmADMANQBjADUALQA2AGEAYgA4AC0ANABhAGQANwAtADgAMABjADcALQBkAGQAOQA3AGMAYQAyAGEAZAA1ADEAOAB8ADIAMQA1ADYAMwBjAGEAYwA3ADMAMgA1AGYAZgBiADgAMgA4ADgANAA5AGQANgA2ADEAMAAwAGQAMgA3ADAAOQA=");
    }

}
