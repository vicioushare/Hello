package src.vicioushare.web;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.httpclient.util.HttpURLConnection;

import net.sf.json.JSONObject;

public class HttpPost {
	/**
	 * 调用http接口
	 * @param jObject
	 * @param url
	 * @return
	 */
	private String post(JSONObject jObject,String url){
		InputStream in = null;
		ByteArrayOutputStream barray = null;
		try{
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestProperty("Content-type", "application/x-java-serialized-object");
			conn.setConnectTimeout(120000);
			conn.setReadTimeout(120000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			DataOutputStream out = new DataOutputStream(conn
					.getOutputStream());
			out.writeBytes(jObject.toString());
			// 接收返回信息
			in = new DataInputStream(conn.getInputStream());
			byte[] array = new byte[4096];
			int count = -1;
			barray = new ByteArrayOutputStream();
			while (-1 != (count = in.read(array))) {
				barray.write(array, 0, count);
			}
			byte[] data = barray.toByteArray();
			barray.close();
			String ret = new String(data, "utf-8");
			return ret;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(barray != null){
				try {
					barray.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/** 请求方ID */
	public static final String SENDER_ID = "senderId";
	/** 服务方ID */
	public static final String SERVICE_ID = "serviceId";
	/** * 用户信息 */
	public static final String AUTHORIZE_INFO = "authorizeInfo";
	/** * 请求的webService接口方法 */
	public static final String QUERY = "webServiceMethod";
	/** * 请求的webService接口方法的参数 */
	public static final String METHODPARAMETER ="webServiceParameter";
	/**	 * 操作信息 */
	public static final String OPERATE = "operate";
	/**
	 * 调用httpPost获取结果集
	 * @param senderId请求方ID
	 * @param serviceId服务方ID
	 * @param method请求的方法名称
	 * @param authorizeInfo授权信息
	 * @param operate操作信息
	 * @param methodParameter方法的参数
	 * @param url调度节点路径
	 * @return
	 */
	public String post(String senderId,String serviceId,String method,String[] authorizeInfo,String operate,Object methodParameter[],String url){
		JSONObject jObject = new JSONObject();
		jObject.put(SENDER_ID,senderId);
		jObject.put(SERVICE_ID,serviceId);
		jObject.put(AUTHORIZE_INFO,authorizeInfo);
//		jObject.put(METHOD,method);
		jObject.put(METHODPARAMETER,methodParameter);
		jObject.put(OPERATE,operate);
		String resoult = post(jObject, url);
		return resoult;
	}
	/**
	 * 打印结果集
	 * @param resoult
	 */
	private static void printResoult(String resoult){
		JSONObject jObject = JSONObject.fromObject(resoult);
		System.out.println(jObject);
		System.out.println("请求方ID："+jObject.get("senderId"));
		System.out.println("服务方ID："+jObject.get("serviceId"));
		System.out.println("返回类别："+jObject.get("msgType"));
		if("0102".equals(jObject.get("msgType"))){
			System.out.println("结果集："+jObject.get("payLoad"));
		}else{
			System.out.println("错误代码："+jObject.get("errorCode")+" | 错误信息："+jObject.get("errorMessage"));
		}
	}	

	
}
