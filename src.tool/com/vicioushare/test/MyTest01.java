package com.vicioushare.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.vicioushare.tool.IDCardUtil;

public class MyTest01 {
	String name = "a";
	@Test
	public void test011(){
		String test = "ABC,£¨123";
		System.out.println(test);
		test.replaceAll("£¨", ",");
		System.out.println(test);
		test =test.replaceAll("£¨", ","); 
		System.out.println(test);
	}
	
	public void test010(){
		List<Object> list = new ArrayList<Object>();
		list.add("c");
		list.add("c");
		list.add("c");
		System.out.println(list);
		JSONArray array = JSONArray.fromObject(list);
		System.out.println(array);
	}
	
	public void test009(){
		String year = "+2015";
		System.out.println(year.substring(0,1));
		System.out.println(year.substring(1,5));
		
		
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		List<String> temp = new ArrayList<String>();
		temp.add("q");
		temp.add("w");
		temp.add("e");
		temp.addAll(list);
		
		for (String str : temp) {
			System.out.println(str);
		}
		
		System.out.println("123EEee".toUpperCase());
		System.out.println(IDCardUtil.IDCardValidate("53012919901209073X"));
	}
	
	
	public void test008(){
		Long l1 = 100L;
		Long l2 = 101L;
		Long l3 = 100L;
		
		System.out.println(l1>l2);
		System.out.println(l1==l3);
		
		
		
		String str = "11";
		Long ln = Long.parseLong(str);
		System.out.println(ln);
		
		/*System.out.println(""!=name);
		System.out.println("a"!=name);
		System.out.println(!"".equals(name));*/
	}
	
	public void test007(){
		Date now = new Date();
		System.out.println(now);
		Calendar date = Calendar.getInstance();
		date.setTime(now);
		System.out.println(date.get(Calendar.HOUR_OF_DAY));
		
		
		StringBuffer sb = new StringBuffer();
		sb.append((date.get(Calendar.MONTH)+1)).append("‘¬").append(date.get(Calendar.DAY_OF_MONTH)).append("»’£¨");
		sb.append(date.get(Calendar.HOUR_OF_DAY)).append(":").append(date.get(Calendar.MINUTE));
		System.out.println(sb.toString());
	}
	
	public void test006(){
		String strs[]={"a","b","c","d"};
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "c");
		
		for (int i = 0; i < strs.length; i++) {
			if(map.containsValue(strs[i])){
				System.out.println("---"+strs[i]);
			}
		}
	}
	
	
	public void test005(){
		double yzm =  Math.random()*10000;
		System.out.println(yzm);
	}

	public void test004(){
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API","Date and Time API");
	//	features.forEach(n -> System.out.println(n));
	//	()->System.out.println("==");
		String fileNames=null;
		String filePaths =null;
		if (!"".equals(fileNames)&&!"".equals(filePaths)) {
			System.out.println("-≤‚ ‘111-");
		}
		if (!"".equals(null)&&!"".equals(null)) {
			System.out.println("-≤‚ ‘22-");
		}
		
	}
	
	public void test003(){
		String [] year = new String[]{"2013","2014","+2015","-2015","2015","+2016"};
		for (int i = 0; i < year.length; i++) {
			System.out.println(year[i]);
			for (int j = i+1; j < year.length; j++) {
				System.out.println(year[i]+","+year[j]);
				for (int k = j+1; k < year.length; k++) {
					System.out.println(year[i]+","+year[j]+","+year[k]);
					for (int l = k+1; l < year.length; l++) {
						System.out.println(year[i]+","+year[j]+","+year[k]+","+year[l]);
						for (int m = l+1; m < year.length; m++) {
							System.out.println(year[i]+","+year[j]+","+year[k]+","+year[l]+","+year[m]);
							for (int n = m+1; n < year.length; n++) {
								System.out.println(year[i]+","+year[j]+","+year[k]+","+year[l]+","+year[m]+","+year[n]);
								
							}
						}
					}
				}
			}
			
		}
		
	}

	public void test002(){
		List<Area> areas = new ArrayList<Area>(); 
		areas.add(new Area("1", "1", "1"));
		areas.add(new Area("2", "2", "2"));
		areas.add(new Area("3", "3", "3"));
		Map<String,Area> map = new HashMap<String,Area>();
		for (Area area : areas) {
			map.put(area.getName(), area);
		}
		
		System.out.println(map.get("1"));
		
		
		String subcode="12345678";
		System.out.println(subcode.substring(0,6).equals("123456"));
	}
	
	public void text001(){
		for (int i = 0; i < 100; i++) {
			String fileName = System.currentTimeMillis()+(int)(new Random()).nextInt(1000)+"";
			System.out.println(fileName);
		}
	}
	
	
	@SuppressWarnings("unused")
	private class Area{
		public Area(String pk,String name,String subcode){
			this.pk=pk;
			this.name=name;
			this.subcode=subcode;;
		}
		
		private String pk;
		private String name;
		private String subcode;
		
		public String getPk() {
			return pk;
		}
		public void setPk(String pk) {
			this.pk = pk;
		}
		public String getSubcode() {
			return subcode;
		}
		public void setSubcode(String subcode) {
			this.subcode = subcode;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	public void test01(){
		String code = "123456";
		String[] str = code.trim().split("");
		System.out.println("--->"+str.length);
	}
	public static void  main(String re[]){
		String code = "123456";
		String[] str = code.trim().split("");
		System.out.println("--->"+str.length);
	}
	
}
