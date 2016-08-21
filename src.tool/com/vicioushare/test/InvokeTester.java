package com.vicioushare.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTester {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public InvokeTester() {
	}

	public int add(int param1, int param2) {
		return param1 + param2;
	}

	public String echo(String mesg) {
		return "echo" + mesg;
	}

	public static void main(String[] args) {
		Class classType = InvokeTester.class;
		try {
			Object invokertester = classType.newInstance(); // 1
			Method addMethod = classType.getMethod("add", new Class[] { // 2
					int.class, int.class });
			Object result = addMethod.invoke(invokertester, new Object[] { // 3
					new Integer(100), new Integer(200) });
			System.out.println(result);
			// ////////////////////
			Method echo = classType.getMethod("echo",
					new Class[] { String.class });
			Object obj = echo.invoke(invokertester, new Object[] { new String(
					"jy is very good!!!") });
			System.out.println("00000000000"+obj.toString());

			// //////////////////
			InvokeTester test = new InvokeTester(); // 1
			test.setName("���"); // 2

			// Method[] methods;
			Method[] methods = test.getClass().getDeclaredMethods(); // 3

			// ѭ�����һ�ȡid��������ִ�в鿴�Ƿ��з���ֵ
			for (int i = 0; i < methods.length; i++) {

				// ����˷�����get��Id�ؼ�����ִ��
				if (methods[i].getName().indexOf("get") != -1
						&& methods[i].getName().indexOf("Name") != -1) {
					try {
						// ��ȡ��get��������ֵ,�ж��Ƿ���ֵ,���û��ֵ˵������ִ�еĲ�������
						if (methods[i].invoke(test, null) == null) { // 4
							System.out.println("�˶���û��ֵ������");
						} else {
							Object strName = methods[i].invoke(test, null);
							System.out.println(strName);
						}
					} catch (Exception e) {
						System.out.print("");
					}
				}
			}
		} catch (IllegalAccessException ex) {
		} catch (InstantiationException ex) {
		} catch (SecurityException ex) {
		} catch (NoSuchMethodException ex) {
		} catch (InvocationTargetException ex) {
		} catch (IllegalArgumentException ex) {
		}
	}
}