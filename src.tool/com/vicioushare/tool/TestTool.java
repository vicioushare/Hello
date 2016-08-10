package com.vicioushare.tool;

import java.util.Date;

import org.junit.Test;

public class TestTool {
	// 测试验证身份证号码
	@Test
	public void IDCardUtilTest() {
		String IDNumberString = "530129199012098766";
		System.out.println(IDCardUtil.IDCardValidate(IDNumberString));
	}

	// 测试时间工具。
	@Test
	public void DateUtilTest() {
		System.out.println(DateUtil.getStringFromDateByCommon(new Date()));
		System.out.println(DateUtil.getStrFromDateByFormatStr(new Date(), DateUtil.YYYY_MM_DD_HH_MM_ss));
	}

	// 测试时间工具。
	@Test
	public void StringUtilTest() {
		String content = "\\\b\\";
		String str1 = StringUtil.wrapXmlContent(content);
		System.out.println(content);
		System.out.println("<---------->");
		System.out.println(str1);
		System.out.println(str1.equals(content));
	}
}
