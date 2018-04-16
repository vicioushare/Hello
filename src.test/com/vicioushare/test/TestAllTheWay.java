package com.vicioushare.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;

public class TestAllTheWay {

	@Test
	public void test3() {

	System.out.println("120154321".substring(0, 4)+"00000");
		
		int a1 = 120100201;
		
		System.out.println((a1/100000)*100000);
		System.out.println((a1/100000)*100000);
		
		
		
		String s1 = null;
		
		System.out.println("123".equals(s1));
		
		
		String str="冉文君承包张焕先负责的腊满高速工程部分，王远高为其手下工人，施工一段时间后，张焕先方认为冉文君、冉茂光、冉启珍、王远高等人进度、质量达不到自己的要求，要求换人，冉文君、冉启珍、冉茂光、王远高等十二人要求张焕先支付己方投入的设备费、人工费及工人工资，双方就补偿款总额发生纠纷。";
		System.out.println(str);
				
		
		
	//	System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}
	
	public void test2() {
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}
	
	public void test1() throws ParseException{
		String ds1="2017-07";
		String ds2="2017-09";
		System.out.println(getDateSQL(ds1, ds2));
	}
	
	
	/**
	 * ((YEAR='2017' AND MONTH ='07') or(YEAR='2017' AND MONTH ='08'))
	 * @param strat
	 * @param end
	 * @return
	 */
	public String getDateSQL(String strat,String end){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			if(strat.equals(end)){
				String d = sdf.format(sdf.parse(strat));
				return" (YEAR='"+d.split("-")[0]+"' AND MONTH ='"+d.split("-")[1]+"') ";
			}else{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(sdf.parse(strat));
				StringBuffer sb = new StringBuffer(" (");
				while(calendar.getTime().compareTo(sdf.parse(end))<=0){//判断是否到结束日期
					String d = sdf.format(calendar.getTime());
					sb.append("(YEAR='"+d.split("-")[0]+"' AND MONTH ='"+d.split("-")[1]+"') or ");
					calendar.add(Calendar.MONTH, 1);//进行当前日期月份加1
				};
				sb.deleteCharAt(sb.length()-1);
				sb.deleteCharAt(sb.length()-1);
				sb.deleteCharAt(sb.length()-1);
				sb.deleteCharAt(sb.length()-1);
				sb.append(") ");
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
}
