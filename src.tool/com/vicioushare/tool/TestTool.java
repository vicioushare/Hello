package com.vicioushare.tool;

import java.util.Date;

import org.junit.Test;

public class TestTool {
	// ������֤���֤����
	@Test
	public void IDCardUtilTest() {
		String IDNumberString = "530129199012098766";
		System.out.println(IDCardUtil.IDCardValidate(IDNumberString));
	}
	
	// ����ʱ�乤�ߡ�
	@Test
	public void DateUtilTest() {
		System.out.println(DateUtil.getStringFromDateByCommon(new Date()));
	}

}
