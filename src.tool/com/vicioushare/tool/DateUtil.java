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
	   * �õ������Ӻ��ʱ�� 
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
	   * �õ���Сʱ���ʱ�� 
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
	   * �õ�������ʱ�� 
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
	   * �õ����ܺ��ʱ�� 
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
	   * �õ����º��ʱ�� 
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
	   * �õ�������ʱ�� 
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
	   * �õ�ĳ�������ʱ��:0��0��0�� 
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
	   * �õ���ǰһСʱ�������ʱ��:0��0�� 
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
	   * �õ�ĳ�������ʱ��:0��0��0�� 
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
	   * �õ�ĳ�������ʱ��:23��59��59�� 
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
	   * �õ����������ʱ��:0��0�� 
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
	   * �õ�ĳ�������ʱ��:0��0�� 
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
	   * �õ�ĳ�������ʱ��:0��0�� 
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
	   * �õ�ĳ����ٵ�ʱ��:0��0�� 
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
	   * �õ���ǰһ���������ʱ��:0��0�� 
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
	   * �õ���ǰ���������ʱ��:59��59�� 
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
	   * �õ�ĳ���������ʱ��:59��59�� 
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
	   * �õ���ǰһ���������ʱ��:59��59�� 
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
		 * ת��һ����yyyy-MM-dd���ַ���Ϊһ��Date
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
		 * ת��һ��Date��yyyy-MM-dd��ʽ���ַ���
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
