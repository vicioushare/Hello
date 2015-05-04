package com.vicioushare.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	@Test
	public void test() {
		File file = new File("D:\\tmp\\xml.xml");
		String content = fileToString(file);
		System.out.println(content);
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			NodeList products = doc.getElementsByTagName("ITEM");
			System.out.println("---"+products.getLength());
			for (int i = 0; i < products.getLength(); i++) {
				Node node = products.item(i);
				System.out.println(node.getAttributes().getNamedItem("NAME"));
				System.out.println(node.getAttributes().getNamedItem("MOBILE"));
				System.out.println(node.getAttributes().getNamedItem("EMAIL"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取文件转String
	 * 
	 * @return
	 */
	public String fileToString(File file) {
		String xml = "";
		try {
			StringBuffer sb = new StringBuffer();
			String line = null;
			FileInputStream in = new FileInputStream(file);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			while ((line = bf.readLine()) != null) {
				sb.append(line);
			}
			bf.close();
			in.close();
			xml = sb.toString();
		} catch (Exception e) {
		}
		return xml;
	}
}
