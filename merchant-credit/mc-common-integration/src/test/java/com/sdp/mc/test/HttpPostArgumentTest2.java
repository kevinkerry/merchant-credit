package com.sdp.mc.test;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
  
/** 
 *  
 * @author <a href="mailto:just_szl@hotmail.com"> Geray</a> 
 * @version 1.0,2012-6-12  
 */  
public class HttpPostArgumentTest2 {  
  
    //file1与file2在同一个文件夹下 filepath是该文件夹指定的路径      
    public void SubmitPost(String url,String filename1,String filename2, String filepath){  
          
        HttpClient httpclient = new DefaultHttpClient();  
          
        try {  
      
            HttpPost httppost = new HttpPost(url);  
           // FileEntity bin = new FileEntity(new File(filepath + File.separator + filename1));  
            
           // httppost.setEntity(bin);  
            HttpResponse response = httpclient.execute(httppost);  
              
                  
            int statusCode = response.getStatusLine().getStatusCode();  
              
                  
            if(statusCode == HttpStatus.SC_OK){  
                      
                System.out.println("服务器正常响应.....");  
                  
                HttpEntity resEntity = response.getEntity();  
                  
                System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据  
                  
                System.out.println(resEntity.getContent());     
  
                EntityUtils.consume(resEntity);  
            }  
                  
            } catch (ParseException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } finally {  
                try {   
                    httpclient.getConnectionManager().shutdown();   
                } catch (Exception ignore) {  
                      
                }  
            }  
        }  
      
      
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
          
        HttpPostArgumentTest2 httpPostArgumentTest2 = new HttpPostArgumentTest2();  
          
        httpPostArgumentTest2.SubmitPost("http://10.241.14.74/Storage/upload.aspx?u=ZQA4AGEAZQAxADYAOAAwAC0AYgAxAGEAMAAtADQAMwBhADAALQBhADcAZQAxAC0AZAA0ADgAMAAyADcAZQBiADEAYgAxAGEAfAAyADAAMQA2ADEAMgAwADYAMQAzADEANQAyADIAfABjADEAMABmADMANQBjADUALQA2AGEAYgA4AC0ANABhAGQANwAtADgAMABjADcALQBkAGQAOQA3AGMAYQAyAGEAZAA1ADEAOAB8ADIAMQA1ADYAMwBjAGEAYwA3ADMAMgA1AGYAZgBiADgAMgA4ADgANAA5AGQANgA2ADEAMAAwAGQAMgA3ADAAOQA=",  
                "capture.png","capture.png","D://");  
    }  
      
}  