package com.vicioushare.client;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.junit.Test;

/**
 * WebService调用测试
 * @author reall
 *
 */
public class SgzzClient {
	@SuppressWarnings("rawtypes")
	@Test
	public void sms(){
		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			options.setTimeOutInMilliSeconds(600000L);
			EndpointReference targetEPR = new EndpointReference(
					"http://localhost/sgzz/services/smsSvc");
			options.setTo(targetEPR);
			Class[] responseParam = new Class[] { String.class };
			QName requestMethod = new QName("http://mobile.com", "smsSubmit");
			for (int i = 0; i < 1; i++) {
				Object[] requestParam = new Object[] {"15108827707", "惺惺惜惺惺代售点是多少颠三倒四的但是但是颠三倒四的多少点" };
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
			options.setTimeOutInMilliSeconds(600000L);
			EndpointReference targetEPR = new EndpointReference(
					"http://localhost/sgzz/services/gisSvc");
			options.setTo(targetEPR);
			Class[] responseParam = new Class[] { String.class };
			QName requestMethod = new QName("http://gis.com", "getItems");
			for (int i = 0; i < 1; i++) {
				Object[] requestParam = new Object[] {"530010", "text" };
				System.out.println(serviceClient.invokeBlocking(requestMethod,requestParam, responseParam)[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
