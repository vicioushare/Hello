package com.vicioushare.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.junit.Test;

/**
 * WebService调用测试
 * @author reall
 *
 */
public class SgzzClient {
	@Test
	public void webserviceTest(){
		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			options.setTimeOutInMilliSeconds(600000L);
			EndpointReference targetEPR = new EndpointReference(
					"http://59.216.224.31:8888/dataSwitching/services/HujiSvr");
			options.setTo(targetEPR);
			Class[] responseParam = new Class[] { String.class };
			QName requestMethod = new QName("http://webservices.com", "queryHuji");
			for (int i = 0; i < 1; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", "1");
				Object[] requestParam = new Object[] {map};
				System.out.println(serviceClient.invokeBlocking(requestMethod,requestParam, responseParam)[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void test001(){
		List<String> l1 =new ArrayList<String>();
		l1.add("1");
		l1.add("2");
		l1.add("3");
		List<String> l2 =new ArrayList<String>();
		l2.add("3");
		l2.add("4");
		l2.add("5");
		List<String> l3 =new ArrayList<String>();

		l1.removeAll(l2);
		l1.addAll(l2);
		System.out.println(l1.toString());
	}
	
	
	public void dataSwitching002(){
		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			options.setTimeOutInMilliSeconds(600000L);
			EndpointReference targetEPR = new EndpointReference(
					"http://localhost:8080/dataSwitching/services/HujiSvr");
			options.setTo(targetEPR);
			Class[] responseParam = new Class[] { String.class };
			QName requestMethod = new QName("http://webservices.com", "queryHuji");
			for (int i = 0; i < 1; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("1", "1");
				Object[] requestParam = new Object[] {map};
				System.out.println(serviceClient.invokeBlocking(requestMethod,requestParam, responseParam)[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dataSwitching001(){
		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			options.setTimeOutInMilliSeconds(600000L);
			EndpointReference targetEPR = new EndpointReference(
					"http://localhost:8080/dataSwitching/services/TestMain");
			options.setTo(targetEPR);
			Class[] responseParam = new Class[] { String.class };
			QName requestMethod = new QName("http://dataSwitching.ynnetit.com", "plus");
			for (int i = 0; i < 1; i++) {
				Object[] requestParam = new Object[] {"2121sssF", "颠三倒四的F" };
				System.out.println(serviceClient.invokeBlocking(requestMethod,requestParam, responseParam)[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@SuppressWarnings("rawtypes")
	public void dictItems(){
		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			options.setTimeOutInMilliSeconds(120000L);
			EndpointReference targetEPR = new EndpointReference(
		//			"http://116.52.158.211:8080/sgzz/services/gisSvc");
					"http://localhost/sgzz/services/gisSvc");
			options.setTo(targetEPR);
			Class[] responseParam = new Class[] { String.class };
	  	QName requestMethod = new QName("http://gis.com", "getDistributionCfg");
	//		Object[] requestParam = new Object[] { "trouble"};
			System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getDistributionCfg"),new Object[] { "permanent_people","EDUCATION"}, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getItems"),new Object[] { "trouble","TROUBLE_TYPE"}, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getAreaAndGridByFather"),new Object[] { "530602001008","530600ebf77aeb8be04d539ac864fb91fbea29"}, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getSpecialTypeDate"),new Object[] { "young_people", "NATION:8a4f83ad3b4b35bd013b4b3db416000a;SEX:1;AGE:0,6;YOUNG_TYPE:农村留守儿童,闲散青少年;SERVICES:1,2;CAUSE:1,2","area","530000000000" }, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getSpecialTypeDate"),new Object[] { "trouble","TROUBLE_TYPE:02","area","530000000000" }, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getSpecialTypeDate"),new Object[] { "permanent_people","NATION:8a4f83ad3b4b35bd013b4b45ffce002b;POLITICAL:5;SEX:1;EDUCATION:80","area","530000000000" }, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getSpecialTypeDate"),new Object[] { "special_people","","area","530000000000" }, responseParam)[0]);
	//		System.out.println(serviceClient.invokeBlocking(new QName("http://gis.com", "getBoundaryCfg"),new Object[] {  }, responseParam)[0]);
			


			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
