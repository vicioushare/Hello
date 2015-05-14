package com.vicioushare.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class KeywordsAnalysis {
	// 0=一般，1=较急，2=特急，3=其他
	// 01=治安、刑事案件,02=矛盾纠纷,03=火灾事故,04=交通事故,
	// 05=群体性事件,06=疑似疫情,07=可疑人员,08=自然灾害,
	// 09=群众诉求,10=未分类,99=其他
	public String type[] = new String[10];
	public static int count = 0;
	public static int countAll = 0;
	public KeywordsAnalysis(){
		type[0] = "毒品,杀人,抢,劫,涉军,吸毒,盗,窃,偷,治安,违纪,违法,逃跑,警,车,伤,亡,死,救,受骗,不良";
		type[1] = "拖欠,合同,补偿,协,商,家,争,养,育,婚,房,劝,夫,媳,妻,吵,架,纠,纷,调,矛盾,工程,赔偿,离婚,赡养,已调处,施工,条改,改决";//02
		type[2] = "火,灾,扑灭,烧,森林";//03
		type[3] = "撞车,车祸,交通";//04
		type[4] = "群架,聚众闹事,群众闹事,闹事";//05
		type[5] = "瘟疫,流感,成功";//06
		type[6] = "行踪诡异,可疑人员,流动人口";//07
		type[7] = "砸,塌方,地震,山体滑坡,安全,患,房屋垮塌,公路,雨,山,损,破,坏,水,天气,倒塌,事故,救援,医,发生,异常,突发,风暴";//08
		type[8] = "影响,就业,卫生,补助,垃圾,噪音,污染,严重,管理,故障,树,举报,修,物管,路,灯,乱,工作,挖,群众,农,款,低保,上访,集体上访,土地,线断,部门,重视,反应,违章建筑,垃圾堆,损失,领导,会,慰问,书记,巡罗,地界,解决";//09
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
