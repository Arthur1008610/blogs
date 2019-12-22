package com.luban.po;

import java.sql.Date;
/**
 * PageInfo.java
 *describe:
 *2019 年 上午11:02:08
 *小张
 */
public class BlogComment {
	
	 
	private Integer	BU_ID;   
	private Integer	ba_id ; 
	private String	BUCommentNAME ;   
	private String	BUCONTENT ;     
	private String  Content;     
	private Date   BUCREATETIME;  
	private Date   BUreply_IME ;
	public Integer getBU_ID() {
		return BU_ID;
	}
	public void setBU_ID(Integer bU_ID) {
		BU_ID = bU_ID;
	}
	public Integer getBa_id() {
		return ba_id;
	}
	public void setBa_id(Integer ba_id) {
		this.ba_id = ba_id;
	}
	public String getBUCommentNAME() {
		return BUCommentNAME;
	}
	public void setBUCommentNAME(String bUCommentNAME) {
		BUCommentNAME = bUCommentNAME;
	}
	public String getBUCONTENT() {
		return BUCONTENT;
	}
	public void setBUCONTENT(String bUCONTENT) {
		BUCONTENT = bUCONTENT;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getBUCREATETIME() {
		return BUCREATETIME;
	}
	public void setBUCREATETIME(Date bUCREATETIME) {
		BUCREATETIME = bUCREATETIME;
	}
	public Date getBUreply_IME() {
		return BUreply_IME;
	}
	public void setBUreply_IME(Date bUreply_IME) {
		BUreply_IME = bUreply_IME;
	}
	
	
	
	  
	
}
