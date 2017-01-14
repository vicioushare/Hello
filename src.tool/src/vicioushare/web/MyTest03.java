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
		String senderId = "C10-10000138";//请求方ID
		String serviceId = "S10-10000139";//服务方ID
		String method = "Query";//请求的webService接口方法
		String[] endUser = { "10000", "pmc", "010000",""};//用户信息
		String[] authorizeInfo = { "10000", "test", "010000",""};//授权信息
		String[] requestItems = {"XB","XM","SFZH"};
		String condition = "";
		try {
			condition = URLEncoder.encode("XM='张三'","utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Object methodParameter[] = {senderId,serviceId, endUser,"A002",condition,requestItems,"1"};//方法的参数
		String url = "http://192.168.0.247:8888/pdn/service";//调度节点的路径
        JSONObject operate = new JSONObject();//操作信息
		/*operate.put("userId",userId);
		operate.put("userName",userName);
		operate.put("userDept",userDept);
		operate.put("macIp",macIp);*/
		HttpPost httpPost = new HttpPost();//通过平台接口访问服务方
		String resoult = httpPost.post(senderId,serviceId,method,authorizeInfo,operate.toString(), methodParameter, url);
		return resoult;
	}
	
	/**
	 * 返回结果集解析结果
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
