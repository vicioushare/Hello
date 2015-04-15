package com.vicioushare.tool;

public class StringUtil {

	public static String wrapXmlContent(String content) {
		StringBuffer appender = new StringBuffer("");
		if ((content != null) && (!content.trim().isEmpty())) {
			appender = new StringBuffer(content.length());
			appender.append("");
			for (int i = 0; i < content.length(); i++) {
				char ch = content.charAt(i);
				if ((ch == '\t') || (ch == '\n') || (ch == '\r') || ((ch >= ' ') && (ch <= 55295))
						|| ((ch >= 57344) && (ch <= 65533)) || ((ch >= 65536) && (ch <= 1114111))) {
					appender.append(ch);
				}
			}
		}
		String result = appender.toString();

		return result;
	}
	
}
