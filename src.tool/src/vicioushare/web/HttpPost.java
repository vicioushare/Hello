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
	 * ����http�ӿ�
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
			// ���շ�����Ϣ
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

	/** ����ID */
	public static final String SENDER_ID = "senderId";
	/** ����ID */
	public static final String SERVICE_ID = "serviceId";
	/** * �û���Ϣ */
	public static final String AUTHORIZE_INFO = "authorizeInfo";
	/** * �����webService�ӿڷ��� */
	public static final String QUERY = "webServiceMethod";
	/** * �����webService�ӿڷ����Ĳ��� */
	public static final String METHODPARAMETER ="webServiceParameter";
	/**	 * ������Ϣ */
	public static final String OPERATE = "operate";
	/**
	 * ����httpPost��ȡ�����
	 * @param senderId����ID
	 * @param serviceId����ID
	 * @param method����ķ�������
	 * @param authorizeInfo��Ȩ��Ϣ
	 * @param operate������Ϣ
	 * @param methodParameter�����Ĳ���
	 * @param url���Ƚڵ�·��
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
	 * ��ӡ�����
	 * @param resoult
	 */
	private static void printResoult(String resoult){
		JSONObject jObject = JSONObject.fromObject(resoult);
		System.out.println(jObject);
		System.out.println("����ID��"+jObject.get("senderId"));
		System.out.println("����ID��"+jObject.get("serviceId"));
		System.out.println("�������"+jObject.get("msgType"));
		if("0102".equals(jObject.get("msgType"))){
			System.out.println("�������"+jObject.get("payLoad"));
		}else{
			System.out.println("������룺"+jObject.get("errorCode")+" | ������Ϣ��"+jObject.get("errorMessage"));
		}
	}	

	
}
