package com.vicioushare.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class MyTest01 {
	@Test
	public void test004(){
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API","Date and Time API");
		features.forEach(n -> System.out.println(n));
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
