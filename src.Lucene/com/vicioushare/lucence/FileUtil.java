package com.vicioushare.lucence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	private final static String scanPath="F:\\Lucene\\article";
	private final static String savePath="F:\\Lucene\\data";

	/**
	 * 读取文件夹下的文件
	 * @param scanPath
	 * @return
	 */
	public static List<File> listAllFiles() {
		List<File> list = new ArrayList<>();
		File file = new File(scanPath);
		File files[] = file.listFiles();
		for (File f : files) {
			String filePath = f.getAbsolutePath();
			String fileType = filePath.substring(filePath.lastIndexOf(".")+1);
			if(fileType.equals("txt")){
				list.add(f);
			}
		}
		return list;
	}
	
	public static String readFile(File file){
		StringBuffer sb = new StringBuffer();
		try {
			FileInputStream fin = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fin,"GB2312"));
			String line = br.readLine();
			while(line!= null){
				sb.append(line);
				line = br.readLine();
			}
			br.close();
			fin.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sb.toString();
	}
	
	
	
	public void saveFile(){
		System.out.println(savePath);
	}

	public static void createFileByTaxx(Taxx taxx) {
		try {
			File file = new File(savePath+"\\"+taxx.getTitle());
			FileWriter writer = new FileWriter(file);
			writer.write(taxx.getPk()+"\n"+taxx.getContent());
			writer.flush();
            writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


}
