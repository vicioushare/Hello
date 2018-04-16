package com.vicioushare.lucence;

import java.util.UUID;

/**
 * 提案信息
 * @author reall
 *
 */
public class Taxx {

	public Taxx(String title,String content){
		this.content=content;
		this.title=title;
		this.pk=UUID.randomUUID().toString();
	}
	
	
	private String pk;
	private String title;
	private String content;
	
	public String getPk() {
		return pk;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
