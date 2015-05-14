package com.vicioushare.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class KeywordsAnalysis {
	// 0=һ�㣬1=�ϼ���2=�ؼ���3=����
	// 01=�ΰ������°���,02=ì�ܾ���,03=�����¹�,04=��ͨ�¹�,
	// 05=Ⱥ�����¼�,06=��������,07=������Ա,08=��Ȼ�ֺ�,
	// 09=Ⱥ������,10=δ����,99=����
	public String type[] = new String[10];
	public static int count = 0;
	public static int countAll = 0;
	public KeywordsAnalysis(){
		type[0] = "��Ʒ,ɱ��,��,��,���,����,��,��,͵,�ΰ�,Υ��,Υ��,����,��,��,��,��,��,��,��ƭ,����";
		type[1] = "��Ƿ,��ͬ,����,Э,��,��,��,��,��,��,��,Ȱ,��,ϱ,��,��,��,��,��,��,ì��,����,�⳥,���,����,�ѵ���,ʩ��,����,�ľ�";//02
		type[2] = "��,��,����,��,ɭ��";//03
		type[3] = "ײ��,����,��ͨ";//04
		type[4] = "Ⱥ��,��������,Ⱥ������,����";//05
		type[5] = "����,����,�ɹ�";//06
		type[6] = "���ٹ���,������Ա,�����˿�";//07
		type[7] = "��,����,����,ɽ�廬��,��ȫ,��,���ݿ���,��·,��,ɽ,��,��,��,ˮ,����,����,�¹�,��Ԯ,ҽ,����,�쳣,ͻ��,�籩";//08
		type[8] = "Ӱ��,��ҵ,����,����,����,����,��Ⱦ,����,����,����,��,�ٱ�,��,���,·,��,��,����,��,Ⱥ��,ũ,��,�ͱ�,�Ϸ�,�����Ϸ�,����,�߶�,����,����,��Ӧ,Υ�½���,������,��ʧ,�쵼,��,ο��,���,Ѳ��,�ؽ�,���";//09
	}
	
	public String getTypeByKeyworlds(String content) {
		countAll++;
		boolean boo = false;
		String returnString = "10";		
		for (int i = 0; i < type.length-1; i++) {
			String[] singleType = type[i].split(",");
			for (int j = 0; j < singleType.length; j++) {
				if (content.contains(singleType[j])) {
					count++;
					return returnString =  "0"+(i+1);
				}
			}
		}	
		
			System.out.println(content);
	
		return returnString;
	}
	
	@Test
	public void test1(){
		String[] strs = new String[10];
		for (int i = 0; i < 10; i++) {
			strs[i] = i+"00";
		}
		for (String string : strs) {
			System.out.println(string);
		}
	}
	
	
	
	public void test() {}
}
