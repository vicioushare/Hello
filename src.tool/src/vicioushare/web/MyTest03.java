package src.vicioushare.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyTest03 {

	@Test
	public void test001(){
		String  re = query();
		System.out.println(re);
	}
	
	
	public static String query(){
		String senderId = "C10-10000138";//����ID
		String serviceId = "S10-10000139";//����ID
		String method = "Query";//�����webService�ӿڷ���
		String[] endUser = { "10000", "pmc", "010000",""};//�û���Ϣ
		String[] authorizeInfo = { "10000", "test", "010000",""};//��Ȩ��Ϣ
		String[] requestItems = {"XB","XM","SFZH"};
		String condition = "";
		try {
			condition = URLEncoder.encode("XM='����'","utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Object methodParameter[] = {senderId,serviceId, endUser,"A002",condition,requestItems,"1"};//�����Ĳ���
		String url = "http://192.168.0.247:8888/pdn/service";//���Ƚڵ��·��
        JSONObject operate = new JSONObject();//������Ϣ
		/*operate.put("userId",userId);
		operate.put("userName",userName);
		operate.put("userDept",userDept);
		operate.put("macIp",macIp);*/
		HttpPost httpPost = new HttpPost();//ͨ��ƽ̨�ӿڷ��ʷ���
		String resoult = httpPost.post(senderId,serviceId,method,authorizeInfo,operate.toString(), methodParameter, url);
		return resoult;
	}
	
	/**
	 * ���ؽ�����������
	 * @param resoult
	 */
	private static void selectResoult(Object resoult){
		if(resoult instanceof JSONArray){
			JSONArray jsonArray = JSONArray.fromObject(resoult);
			for(int i = 0;i<jsonArray.size();i++){
				JSONArray json = JSONArray.fromObject(jsonArray.get(i));
				for(Object obj:json){
					System.out.print(obj+"             ");
				}
				System.out.println();
			}
			
		}else{
			System.out.println(resoult);
		}
	}


}
