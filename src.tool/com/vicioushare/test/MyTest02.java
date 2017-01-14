package com.vicioushare.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class MyTest02 {
	@Test
	public void test06() {
		
		System.out.println("/pt/gsgl/gsxq".startsWith("/pt/gsgl/"));
		String url = "/pt/gsgl/gsxq.do";
		System.out.println(url.matches("^*/pt/gsgl/*.do$"));

		String filePath = "D:upoad/FileLibLocal";
		String allFilePath = filePath.replace("FileLibLocal", "FileLibAll");
		System.out.println(allFilePath);
	}
	
	
	public void test05() {
		try {
			  FileOutputStream fos = null;
			  BufferedInputStream bis = null;
			  HttpURLConnection httpUrl = null;
			  URL url = null;
			  byte[] buf = new byte[1024];
			  int size = 0;

			  url = new URL("http://sql:8088/省/BULLETIN/201612211006103490.xls");
			  httpUrl = (HttpURLConnection) url.openConnection();
			  httpUrl.connect();
			  System.out.println(httpUrl);
			  bis = new BufferedInputStream(httpUrl.getInputStream());
			  fos = new FileOutputStream(new File("D:/upload/test/20161101044458129.xlsx"));
			  while ((size = bis.read(buf)) != -1)
			   fos.write(buf, 0, size);
			  fos.close();
			  bis.close();
			  httpUrl.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test04() {
		try {
			int bytesum = 0;    
			int byteread = 0; 
			File hasDownload = new File("D:/upload/test/20161101044458129.xlsx");
			File remoteFile = new File("//sql/sqlfpt/upload/201612211006103490.xls");
			InputStream inStream = new FileInputStream(remoteFile);     
			FileOutputStream fs = new FileOutputStream(hasDownload);    
			byte[] buffer = new byte[1444];    
			while((byteread = inStream.read(buffer)) != -1){    
				bytesum     +=     byteread;        
				System.out.println(bytesum);    
				fs.write(buffer,     0,     byteread);    
			}    
			inStream.close();   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void test01() {
		int[] a = { 5, 9, 3, 6, 7, 1 };
		int minIndex = 0;
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			minIndex = i;// 无序区的最小数据数组下标
			for (int j = i + 1; j < a.length; j++) {
				// 在无序区中找到最小数据并保存其数组下标
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// 如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
				temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}
	public void test02() {
		List<Student> list = createStudent();
		System.out.println("---");
		printStudent(list);
		list =  getRank(list,"getC");
		System.out.println("---");
		printStudent(list);
	}

	
	public void test03() {
		String re[] = new String[5];
		for (int i = 0; i < re.length; i++) {
			if(i!=2){
				re[i]="aa"+i;
			}
		}
		for (int i = 0; i < re.length; i++) {
			System.out.println(re[i]);
		}
		
		
	}

	public List<Student> getRank(List<Student> returnlist,String rankBy){
		List<Student> list = new ArrayList<MyTest02.Student>();
		list.addAll(returnlist);
		int minIndex = 0;
		Method[] methods = Student.class.getMethods();
		for(int i = 0; i < methods.length; i++){
			System.out.println(methods[i].getName());
		    if(methods[i].getName().equals(rankBy)){
		    }
		}
		
		for (int i = 0; i < list.size() - 1; i++) {
			minIndex = i;// 无序区的最小数据数组下标
			for (int j = i + 1; j < list.size(); j++) {
				// 在无序区中找到最小数据并保存其数组下标
				 try {
				    	Method method = Student.class.getMethod(rankBy);
						Object objA = method.invoke(list.get(j));
						Object objB = method.invoke(list.get(minIndex));
						if(objB.getClass().getName().equals("java.lang.Integer")){
							if ((Integer)objA > (Integer)objB) {
								minIndex = j;
							}
						}else if(objB.getClass().getName().equals("java.lang.Double")){
							if ((Double)objA > (Double)objB) {
								minIndex = j;
							}
						}else{
							if (Double.parseDouble(objA.toString())> Double.parseDouble(objA.toString())) {
								minIndex = j;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					} 
			}
			if (minIndex != i) {
				// 如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
				Student s = list.get(i);
				list.set(i, list.get(minIndex));
				list.set(minIndex, s);
			}
		}
		for (int j = 0; j < returnlist.size(); j++) {
			System.out.println(j + "--" + returnlist.get(j).toString());
			for (int i = 0; i < list.size(); i++) {
				if (returnlist.get(j).getB() == list.get(i).getB()) {
					System.out.println(i);
					returnlist.get(j).setA(i + 1);
				}
			}
		}
		return returnlist;
	}
	
	public List<Student> createStudent() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(0, 5, 4));
		list.add(new Student(0, 9, 7));
		list.add(new Student(0, 3, 9));
		list.add(new Student(0, 6, 1));
		list.add(new Student(0, 7, 2));
		list.add(new Student(0, 1, 8));
		return list;
	}

	public void printStudent(List<Student> list) {
		for (Student s : list) {
			System.out.println(s.toString());
		}
	}

	private class Student {
		private int a;
		private int b;
		private int c;
		Student() {}
		Student(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.setC(c);
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public String toString() {
			return "a=" + a + " | b=" + b+ " | c=" + c;

		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}
	}
}
