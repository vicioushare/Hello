package com.vicioushare.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String HH_MM_ss = "HH:mm:ss";
	public static final String HHMMss = "HHmmss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/** 
	   * 得到几分钟后的时间 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMinAfter(Date d,int count){  
	   Calendar now =Calendar.getInstance();  
	   now.setTime(d);  
	   now.set(Calendar.MINUTE,now.get(Calendar.MINUTE)+count);  
	   return now.getTime();  
	  }
	/** 
	   * 得到几小时后的时间 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getHourAfter(Date d,int count){  
	   Calendar now =Calendar.getInstance();  
	   now.setTime(d);  
	   now.set(Calendar.HOUR,now.get(Calendar.HOUR)+count);  
	   return now.getTime();  
	  } 
	   /** 
	   * 得到几天后的时间 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getDateAfter(Date d,int count){  
	   Calendar now =Calendar.getInstance();  
	   now.setTime(d);  
	   now.set(Calendar.DATE,now.get(Calendar.DATE)+count);  
	   return now.getTime();  
	  } 
	  
	   /** 
	   * 得到几周后的时间 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getWeekAfter(Date d,int count){  
	   Calendar now =Calendar.getInstance();  
	   now.setTime(d);  
	   now.set(Calendar.DATE,now.get(Calendar.DATE)+count*7);  
	   return now.getTime();  
	  } 
	  
	   /** 
	   * 得到几月后的时间 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMonthAfter(Date d,int count){  
	   Calendar now =Calendar.getInstance();  
	   now.setTime(d);  
	   now.set(Calendar.MONTH,now.get(Calendar.MONTH)+count);  
	   return now.getTime();  
	  } 
	  
	   /** 
	   * 得到几年后的时间 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getYearAfter(Date d,int count){  
	   Calendar now =Calendar.getInstance();  
	   now.setTime(d);  
	   now.set(Calendar.YEAR,now.get(Calendar.YEAR)+count);  
	   return now.getTime();  
	  } 
	  
	  /** 
	   * 得到某天最早的时间:0点0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfDate(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(new Date());
	      cal.set(Calendar.HOUR_OF_DAY, 0);
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到当前一小时内最早的时间:0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfHour(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(new Date());	      
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  }
	  
	public static String formatDate(Date date) {
		 java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat(YYYY_MM_DD_HH_MM_ss);
		  String datetime = dformat.format(date);  
		return datetime;
	} 
	  
	  /** 
	   * 得到某天最早的时间:0点0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfDay(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);
	      cal.set(Calendar.HOUR_OF_DAY, 0);
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  } 
	  
	  
	  /** 
	   * 得到某天最晚的时间:23点59分59秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostLateOfDay(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);
	      cal.set(Calendar.MILLISECOND, 999);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到当月最早的时间:0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfMonth(){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(new Date());	 
	      cal.set(Calendar.DAY_OF_MONTH, 1);
	      cal.set(Calendar.HOUR_OF_DAY, 0);
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到某月最早的时间:0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfMonth(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);	 
	      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DATE));
	      cal.set(Calendar.HOUR_OF_DAY, 0);
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到某季最早的时间:0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfSeason(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);
	      cal.set(Calendar.MONTH, ((int)(cal.get(Calendar.MONTH)/3))*3);
	      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DATE));
	      cal.set(Calendar.HOUR_OF_DAY, 0);
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  }
	  /** 
	   * 得到某季最迟的时间:0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostLateOfSeason(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);
	      cal.set(Calendar.MONTH, ((int)(cal.get(Calendar.MONTH)/3)+1)*3-1);
	      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);
	      cal.set(Calendar.MILLISECOND, 999);	      
	   return cal.getTime();  
	  }
	  /** 
	   * 得到当前一年内最早的时间:0分0秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostEarlyOfYear(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);	    
	      cal.set(Calendar.MONTH, 0);
	      cal.set(Calendar.DAY_OF_MONTH, 1);
	      cal.set(Calendar.HOUR_OF_DAY, 0);
	      cal.set(Calendar.MINUTE, 0);
	      cal.set(Calendar.SECOND, 0);
	      cal.set(Calendar.MILLISECOND, 0);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到当前月内最晚的时间:59分59秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostLateOfMonth(){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(new Date());	
	      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);
	      cal.set(Calendar.MILLISECOND, 999);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到某月内最晚的时间:59分59秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostLateOfMonth(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);	
	      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);
	      cal.set(Calendar.MILLISECOND, 999);	      
	   return cal.getTime();  
	  } 
	  
	  /** 
	   * 得到当前一年内最晚的时间:59分59秒 
	   * @param d 
	   * @param day 
	   * @return 
	   */  
	  public static Date getMostLateOfYear(Date d){  
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(d);	    
	      cal.set(Calendar.MONTH, 11);
	      cal.set(Calendar.DAY_OF_MONTH, 31);
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);
	      cal.set(Calendar.MILLISECOND, 999);	      
	   return cal.getTime();  
	  } 
	  
	  /**
		 * 转换一个如yyyy-MM-dd的字符串为一个Date
		 * 
		 * @param dateStr
		 * @return
		 * @throws ParseException
		 * @throws Exception
		 */
		public static final Date getDateFromStrByFormatStr(String dateStr,String fromatStr) throws ParseException {
			Date date = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fromatStr);
			date = simpleDateFormat.parse(dateStr);
			return date;
		}

		/**
		 * 转换一个Date成yyyy-MM-dd格式的字符串
		 * 
		 * @param date
		 * @return
		 */
		public static final String getStrFromDateByFormatStr(Date date,String formatStr) {
			SimpleDateFormat simpleDateFormat = null;
			String dateStr = "";
			if (date != null) {				
				simpleDateFormat = new SimpleDateFormat(formatStr);
				dateStr = simpleDateFormat.format(date);
			}
			return dateStr;
		}
		
		public static String dateToString(Date date, String format){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		
		public static Date StringToDate(String source, String format) throws ParseException{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(source);
		}
		
		public static String getStringFromDateByCommon(Date date){
			SimpleDateFormat simpleDateFormat = null;
			String dateStr = "";
			if (date != null) {				
				simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_ss);
				dateStr = simpleDateFormat.format(date);
			}
			return dateStr;
		}  

}
