package com.vicioushare.test;

import java.io.BufferedInputStream;  
import java.io.BufferedReader;  
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.net.URI;  
import java.net.URL;  
import java.net.URLConnection;  
  
import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.HttpStatus;  
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;  
  
/** 
 * 测试调用一些meeting第三方接口 
 * @author Jack.Song 
 */  
public class TestMeetingInterface {  
  
  
	@Test
	public void testDX(){
		 String dxurl = "http://124.126.120.35:2000/a.lif";  
		 String result = getHttpResultByXMLString(dxurl,getDXXmlInfo("15393811643"));
		 System.out.println(result);
	}
	
	
	public void testXD_OlD_PSW(){
		String dxurl = "http://183.224.2.212:8082/newRequest";  
		String result = post(dxurl,"13645692411.xml");
		System.out.println(result);
	}
	
	
	public void testXD(){
		String dxurl = "http://183.224.2.212:8082/newRequest";  
		String result = post(dxurl,"18387129739.xml");
		System.out.println(result);
	}
	
	
	
	
    private String getHttpResultByXMLString(String url, String string) {    
    	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");     
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");     
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");    
          
    	HttpClient client = new HttpClient();    
        PostMethod myPost = new PostMethod(url);    
        //设置请求超时时间   
        client.setConnectionTimeout(300*1000);  
        String responseString = null;    
        try{    
            //设置请求头部类型   
            myPost.setRequestHeader("Content-Type","text/xml");  
            myPost.setRequestHeader("charset","utf-8");  
            myPost.setRequestEntity(new StringRequestEntity(string,"text/xml","utf-8"));     
            int statusCode = client.executeMethod(myPost);    
            if(statusCode == HttpStatus.SC_OK){    
                BufferedInputStream bis = new BufferedInputStream(myPost.getResponseBodyAsStream());    
                byte[] bytes = new byte[1024];    
                ByteArrayOutputStream bos = new ByteArrayOutputStream();    
                int count = 0;    
                while((count = bis.read(bytes))!= -1){    
                    bos.write(bytes, 0, count);    
                }    
                byte[] strByte = bos.toByteArray();    
                responseString = new String(strByte,0,strByte.length,"utf-8");    
                bos.close();    
                bis.close();    
            }    
        }catch (Exception e) {    
            e.printStackTrace();    
        }    
        myPost.releaseConnection();    
        return responseString;    
    }




	public static void main(String[] args) {  
        try {
        	TestMeetingInterface tmi = new TestMeetingInterface();  
        	 String dxurl = "http://124.126.120.35:2000/a.lif";  
             System.out.println(tmi.post(dxurl,"18108811915.xml"));
      //      System.out.println(tmi.post(dxurl,"18088134115.xml"));
             
       //     211.139.29.35
      //      http://192.168.168.107:8080/correction/services/RealTimePositonImpl?WSDL
            
      //     String ydurl = "http://183.224.2.212:8080/newRequest";  
      //       String ydurl = "http://183.224.2.212:8080/correction/services/RealTimePositonImpl";  
      //       System.out.println(tmi.post(ydurl,"13645692411.xml"));
             
		} catch (Exception e) {
			e.printStackTrace();
		}  
    }  
    
      
      
  
    /**  
     * 发送xml数据请求到server端  
     * @param url xml请求数据地址  
     * @param xmlString 发送的xml数据流  
     * @return null发送失败，否则返回响应内容  
     */    
    public String post(String url,String xmlFileName){    
        //关闭   
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");     
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");     
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");    
          
        //创建httpclient工具对象   
        HttpClient client = new HttpClient();    
        //创建post请求方法   
        PostMethod myPost = new PostMethod(url);    
        //设置请求超时时间   
        client.setConnectionTimeout(300*1000);  
        String responseString = null;    
        try{    
            //设置请求头部类型   
            myPost.setRequestHeader("Content-Type","text/xml");  
            myPost.setRequestHeader("charset","utf-8");  
              
            //设置请求体，即xml文本内容，注：这里写了两种方式，一种是直接获取xml内容字符串，一种是读取xml文件以流的形式   
//          myPost.setRequestBody(xmlString);   
              
            File file = new File("D:\\temp\\sqjz\\"+xmlFileName); 
            
            InputStream body = new FileInputStream(file);
        //    InputStream body=this.getClass().getResourceAsStream("/"+xmlFileName);  
         //   myPost.setRequestBody("");
            myPost.setRequestBody(body);
//            myPost.setRequestEntity(new StringRequestEntity(xmlString,"text/xml","utf-8"));     
            int statusCode = client.executeMethod(myPost);    
            if(statusCode == HttpStatus.SC_OK){    
                BufferedInputStream bis = new BufferedInputStream(myPost.getResponseBodyAsStream());    
                byte[] bytes = new byte[1024];    
                ByteArrayOutputStream bos = new ByteArrayOutputStream();    
                int count = 0;    
                while((count = bis.read(bytes))!= -1){    
                    bos.write(bytes, 0, count);    
                }    
                byte[] strByte = bos.toByteArray();    
                responseString = new String(strByte,0,strByte.length,"utf-8");    
                bos.close();    
                bis.close();    
            }    
        }catch (Exception e) {    
            e.printStackTrace();    
        }    
        myPost.releaseConnection();    
        return responseString;    
    }    
      
    /** 
     * 用传统的URI类进行请求 
     * @param urlStr 
     */  
    public void testPost(String urlStr) {  
        try {  
            URL url = new URL(urlStr);  
            URLConnection con = url.openConnection();  
            con.setDoOutput(true);  
            con.setRequestProperty("Pragma:", "no-cache");  
            con.setRequestProperty("Cache-Control", "no-cache");  
            con.setRequestProperty("Content-Type", "text/xml");  
  
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());      
         //   String xmlInfo = getXmlInfo();  
            System.out.println("urlStr=" + urlStr);  
//            System.out.println("xmlInfo=" + xmlInfo);   
        //    out.write(new String(xmlInfo.getBytes("UTF-8")));  
            out.flush();  
            out.close();  
            BufferedReader br = new BufferedReader(new InputStreamReader(con  
                    .getInputStream()));  
            String line = "";  
            for (line = br.readLine(); line != null; line = br.readLine()) {  
                System.out.println(line);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    private String getDXXmlInfo(String tel) {  
        StringBuilder sb = new StringBuilder();  
        sb.append("<?xml version='1.0' encoding='UTF-8'?>           ");
        sb.append("<!DOCTYPE REQ SYSTEM 'LOCREQ.DTD'>               ");
        sb.append("<REQ>                                            ");
        sb.append("	<CLIENT>                                        ");
        sb.append("		<LCSCLIENTID>25110010</LCSCLIENTID>         ");
        sb.append("		<PASSWORD>abc123</PASSWORD>                 ");
        sb.append("	</CLIENT>                                       ");
        sb.append("	<ORIGINATOR>                                    ");
        sb.append("		<ORID>18088134115</ORID>                    ");
        sb.append("		<ORID_TYPE>0</ORID_TYPE>                    ");
        sb.append("	</ORIGINATOR>                                   ");
        sb.append("	<LIR>                                           ");
        sb.append("		<ORIGUSER_ACCESSTYPE>1</ORIGUSER_ACCESSTYPE>");
        sb.append("		<FINDME_INDIC>1</FINDME_INDIC>              ");
        sb.append("		<MSIDS>                                     ");
        sb.append("			<MSID>"+tel+"</MSID>  	                ");
        sb.append("			<MSID_TYPE>0</MSID_TYPE>                ");
        sb.append("		</MSIDS>                                    ");
        sb.append("		<POSREQTYPE >2</POSREQTYPE >                ");
        sb.append("		<GEO_INFO>                                  ");
        sb.append("			<COORD_SYS>LL</COORD_SYS>               ");
        sb.append("			<DATUM>WGS-84</DATUM>                   ");
        sb.append("			<LL_FORMAT>DMS3</LL_FORMAT>             ");
        sb.append("		</GEO_INFO>                                 ");
        sb.append("		<PQOS>                                      ");
        sb.append("			<RESP_REQ>LOW_DELAY</RESP_REQ>          ");
        sb.append("			<RESP_TIMER>0010</RESP_TIMER>           ");
        sb.append("			<HOR_ACC>800</HOR_ACC>                  ");
        sb.append("			<ALT_ACC>800</ALT_ACC>                  ");
        sb.append("		</PQOS>                                     ");
        sb.append("		<PRIO>1</PRIO>                              ");
        sb.append("	</LIR>                                          ");
        sb.append("</REQ>                                           ");
          
        return sb.toString();  
    }  
}  
