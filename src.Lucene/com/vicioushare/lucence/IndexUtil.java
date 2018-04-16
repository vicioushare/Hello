package com.vicioushare.lucence;

import java.nio.file.FileSystems;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IndexUtil {
	public static final String INDEX_PATH = "F:\\Lucene\\index"; // 存放Lucene索引文件的位置

	
	/**
	 * 创建索引
	 */
	public static void creatIndex(Taxx taxx) {
		IndexWriter indexWriter = null;
		try {
			Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
			Analyzer analyzer = new IKAnalyzer(true);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			Document document = new Document();
			System.out.println("==1==>");
			System.out.println(taxx.getPk());
			System.out.println(taxx.getTitle());
			System.out.println(taxx.getContent());
			document.add(new Field("pk", taxx.getPk(),TextField.TYPE_STORED)); 
			document.add(new Field("title", taxx.getTitle(),TextField.TYPE_STORED)); 
			document.add(new Field("content", taxx.getContent(),TextField.TYPE_STORED)); 
			indexWriter.addDocument(document);
			System.out.println("=2==>");
			indexWriter.commit();
			indexWriter.close();
			System.out.println("=3==>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 对比传入字符串
	 * @param content
	 */
	public static void queryIndex(String content){
		try {
			Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			
			Analyzer analyzer = new IKAnalyzer(true);
		    QueryParser parser = new QueryParser("content",analyzer);
		    
		    Query q = parser.parse(content);
		    TopDocs docs = searcher.search(q, 10);
		 //   Assert.assertEquals(3, docs.totalHits);
		    System.out.println("搜索内容为分词后： ”" + q.toString() + "“ ，结果排序如下");
		    for (int i = 0; i < docs.scoreDocs.length; ++i) {
		    	Document document = searcher.doc(docs.scoreDocs[i].doc);
				System.out.println(document.get("pk")+"<>"+document.get("title")+"<>"+document.get("content"));
		      System.out.println("得分:" + docs.scoreDocs[i].score);
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
