package com.vicioushare.test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 排列组合测试
 * 按规则生成qsl
 * 
 * @author reall
 *
 */
public class CandATest {
	String[] years = new String[] { "2013", "2014", "+2015", "-2015", "2015",
			"+2016", "-2016", "2016", "+2017" };

	@Test
	public void test() {
		try {
			File file = new File("D:\\year_2017.sql");
			if(!file.exists()){
				file.createNewFile();
			}
			writeStringInFile(file,"--/");
			writeStringInFile(file,"declare Q1_ALL number(22,2);Q21_ALL number(22,2); Q3_ALL number(22,2); Q4_ALL number(22,2); Q5_ALL number(22,2);Q6_ALL number(22,2);Q7_ALL number(22,2); Q8_ALL number(22,2); ALL_P number(22,2);");
			writeStringInFile(file,"begin");
			writeStringInFile(file,"for S in(select * from SUBCODE_OF_ALLCITY_146 ) loop ");
			
			List<String> list = new ArrayList<String>();
			for (int i = 1; i < years.length; i++) {
				begin(years, 0, i, list,file);
			}
			 writeStringInFile(file,"end loop;"); 
			 writeStringInFile(file,"end;"); 
			 writeStringInFile(file,"/"); 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	/**
	 * 递归
	 * @param number
	 * @param start
	 * @param num
	 * @param list
	 */
	public void begin(String[] number,int start,int num,List<String> list,File file){
		if (num==0) {
			//处理年份
			StringBuffer sb = new StringBuffer();
			StringBuffer sb_insert = new StringBuffer();
			sb_insert.append("'");
			for (int i = 0; i < list.size(); i++) {
				sb.append("'"+list.get(i)+"',");
				sb_insert.append(""+list.get(i)+",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb_insert.deleteCharAt(sb_insert.length()-1);
			sb_insert.append("'");
			//2、判断1368：全部年份一起计算
			String _1368s = "SELECT (SUM(Q1_S_1)+SUM(Q1_S_2))/SUM(Q1_S_C)*100 ,(SUM(Q3_S_1)+SUM(Q3_S_2))/(SUM(Q3_S_C)-SUM(Q3_S_4))*100 ,(SUM(Q6_S_1)+SUM(Q6_S_2))/(SUM(Q6_S_C)-SUM(Q6_S_4))*100,(sum(Q8_S_1)+sum(Q8_S_2))/(sum(Q8_S_C)-sum(Q8_S_4))*100"
					+ " into Q1_ALL,Q3_ALL，Q6_ALL,Q8_ALL "
					+ " FROM T_SENSE_OF_SECURITY WHERE  YEAR in "
					+ " ("+sb.toString()+")"
					+ " AND SUBCODE =S.SUBCODE;";
            
            //3、判断45：（13——15）,（16-2017）
			String _45s = "";
			//包含2013,2014,2015,-2015,+2015
			boolean _131415b =sb.toString().contains("2013")||sb.toString().contains("2014")||sb.toString().contains("2015"); 
			//包含 2016,2017
			boolean _16b =sb.toString().contains("2016")||sb.toString().contains("2017"); 
			//如果不同时存在，合并计算，否则为默认值0
			if(!(_131415b &&_16b)){
				_45s="SELECT SUM(Q4_S_1)/(SUM(Q4_S_C)-SUM(Q4_S_3))*100,(SUM(Q5_S_1)+SUM(Q5_S_3))/(SUM(Q5_S_C)-SUM(Q5_S_4))*100"
						+ " into Q4_ALL,Q5_ALL"
						+ " FROM T_SENSE_OF_SECURITY WHERE  YEAR in"
						+ " ("+sb.toString()+")"
						+ " AND SUBCODE =S.SUBCODE;";
			}
            
            //4、判断7：（-15），（15），（16），-（13,14，+15）
			String _7s = "";
			// -2015下半年，2015上半年 每个都有A7项，16年可以合并计算
			if(sb.toString().equals("'-2015'")||sb.toString().equals("'2015'")){
				_7s = "SELECT Q7_ALL into Q7_ALL FROM T_SENSE_OF_SECURITY WHERE  YEAR ="+
						sb.toString()+" AND SUBCODE =S.SUBCODE;"; 
            }else if(!_131415b &&_16b){
            	_7s = "SELECT (SUM(Q7_S_1)+SUM(Q71_S_1))/SUM(Q1_S_C)*100 into Q7_ALL FROM T_SENSE_OF_SECURITY WHERE  YEAR in "
            			+ " ("+sb.toString()+")"
						+ " AND SUBCODE =S.SUBCODE;";
            }
            
			//5、判断all：（13,14，+15），（-15），（15），（16），
			String _all = "";
			boolean _1314_15b =(sb.toString().contains("2013")||sb.toString().contains("2014")||sb.toString().contains("'+2015'"))
								&& !sb.toString().contains("'-2015'")&& !sb.toString().contains("'2015'") ;
			// -2015下半年，2015上半年 每个都有All项，16年可以合并计算，
			if(sb.toString().equals("'-2015'")||sb.toString().equals("'2015'")){
				_all = "SELECT ALL_P into ALL_P FROM T_SENSE_OF_SECURITY WHERE  YEAR ="+
						sb.toString()+" AND SUBCODE =S.SUBCODE;"; 
            }else if(_1314_15b && !_16b){
            	_all = "SELECT (SUM(Q1_S_1)+SUM(Q1_S_2)+SUM(Q3_S_1)+SUM(Q3_S_2)+SUM(Q4_S_1)+SUM(Q5_S_1)+SUM(Q5_S_3)+SUM(Q6_S_1)+SUM(Q6_S_2)+SUM(Q8_S_1)+SUM(Q8_S_2))/(SUM(Q1_S_C)+(SUM(Q3_S_C)-SUM(Q3_S_4))+(SUM(Q4_S_C)-SUM(Q4_S_3))+(SUM(Q5_S_C)-SUM(Q5_S_4))+(SUM(Q6_S_C)-SUM(Q6_S_4))+(SUM(Q8_S_C)-SUM(Q8_S_4)))*100"
            			+ " into ALL_P FROM T_SENSE_OF_SECURITY WHERE  YEAR in "
            			+ " ("+sb.toString()+")"
						+ " AND SUBCODE =S.SUBCODE;";
            }else if(!_1314_15b &&_16b){
            	_all = "SELECT (SUM(Q1_S_1)+SUM(Q1_S_2)+SUM(Q3_S_1)+SUM(Q3_S_2)"
            			+ "+SUM(Q4_S_1)+SUM(Q41_S_1)+SUM(Q41_S_2)"
            			+ "+SUM(Q5_S_1)+SUM(Q5_S_3)+SUM(Q51_S_1)+SUM(Q51_S_2)"
            			+ "+SUM(Q6_S_1)+SUM(Q6_S_2)"
            			+ "+SUM(Q7_S_1)+SUM(Q71_S_1)"
            			+ "+SUM(Q8_S_1)+SUM(Q8_S_2))/(SUM(Q1_S_C)+(SUM(Q3_S_C)-SUM(Q3_S_4))"
            			+ "+SUM(Q4_S_1)+SUM(Q4_S_2)+SUM(Q41_S_1)+SUM(Q41_S_2)+SUM(Q41_S_3)"
            			+ "+SUM(Q5_S_1)+SUM(Q5_S_2)+SUM(Q5_S_3)+SUM(Q51_S_1)+SUM(Q51_S_2)+SUM(Q51_S_3)"
            			+ "+(SUM(Q6_S_C)-SUM(Q6_S_4))"
            			+ "+SUM(Q7_S_1)+SUM(Q7_S_2)"
            			+ "+(SUM(Q8_S_C)-SUM(Q8_S_4)))*100"
            			+ " into ALL_P FROM T_SENSE_OF_SECURITY WHERE  YEAR in "
            			+ " ("+sb.toString()+")"
						+ " AND SUBCODE =S.SUBCODE;";
            }
			
			

			//6、输出查询语句
	//		System.out.println(_1368s);
			writeStringInFile(file,"Q1_ALL:=0; Q3_ALL:=0; Q4_ALL:=0; Q5_ALL:=0; Q6_ALL:=0; Q7_ALL:=0; Q8_ALL:=0; ALL_P:=0;");
			writeStringInFile(file,_1368s);
			if(_45s.length()>0){
		//		System.out.println(_45s);
				writeStringInFile(file,_45s);
			}
			if(_7s.length()>0){
		//		System.out.println(_7s);
				writeStringInFile(file,_7s);
			}
			if(_all.length()>0){
		//		System.out.println(_all);
				writeStringInFile(file,_all);
			}
			//7、生成插入语句
			String _insert = "INSERT INTO T_SENSE_OF_SECURITY_YEAR_2017"
					+ "(PK, YEAR, SUBCODE, NAME, PID,Q1_ALL, Q3_ALL, Q4_ALL, Q5_ALL, Q6_ALL,Q7_ALL, Q8_ALL, ALL_P, PNAME) VALUES"
					+ "(sys_guid(),"
					+ sb_insert.toString()
					+", S.SUBCODE, S.NAME, S.PID,  Q1_ALL, Q3_ALL, Q4_ALL, Q5_ALL, Q6_ALL,Q7_ALL, Q8_ALL, ALL_P, S.PNAME);";
			  
		//	System.out.println(_insert);
			writeStringInFile(file,_insert);
			writeStringInFile(file,"commit;");
			return;
		}
		if (start==number.length) {
			return;
		}
		list.add(number[start]);
		begin(number,start+1,num-1,list,file);
		list.remove(number[start]); 
		begin(number,start+1,num,list,file);
	}
	
	public void writeStringInFile(File file,String content){
		try {
			  FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
	            writer.write(content);
	            writer.write("\t\r");
	            writer.close();
			/*FileOutputStream fo = new FileOutputStream(file);
			fo.write(content.getBytes());
			fo.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
