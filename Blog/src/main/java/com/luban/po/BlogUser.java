package com.luban.po;

import java.util.Date;
/**
 * BlogUser.java
 *describe:
 *2019 年 下午7:56:22
 *小张
 */
public class BlogUser {
	
	private Integer	bu_user_id ;      
	private String BU_EMAIL ;        
	private String BU_USER_NAME ;    
	private String BU_PASSWORD ;     
	private String BU_SEX ;        
	private Date BU_BIRTHDAY ;   
	private String BU_IDENTITY_CODE ;
	private String BU_MOBILE;        
	private Date bu_createtime ; 
	private Date bu_createuser ;  
	private Date bu_updatetime ; 
	private Date bu_updateuser ;
	private Integer BU_STATUS  ;
	public Integer getBu_user_id() {
		return bu_user_id;
	}
	public void setBu_user_id(Integer bu_user_id) {
		this.bu_user_id = bu_user_id;
	}
	public String getBU_EMAIL() {
		return BU_EMAIL;
	}
	public void setBU_EMAIL(String bU_EMAIL) {
		BU_EMAIL = bU_EMAIL;
	}
	public String getBU_USER_NAME() {
		return BU_USER_NAME;
	}
	public void setBU_USER_NAME(String bU_USER_NAME) {
		BU_USER_NAME = bU_USER_NAME;
	}
	public String getBU_PASSWORD() {
		return BU_PASSWORD;
	}
	public void setBU_PASSWORD(String bU_PASSWORD) {
		BU_PASSWORD = bU_PASSWORD;
	}
	public String getBU_SEX() {
		return BU_SEX;
	}
	public void setBU_SEX(String bU_SEX) {
		BU_SEX = bU_SEX;
	}
	public Date getBU_BIRTHDAY() {
		return BU_BIRTHDAY;
	}
	public void setBU_BIRTHDAY(Date bU_BIRTHDAY) {
		BU_BIRTHDAY = bU_BIRTHDAY;
	}
	public String getBU_IDENTITY_CODE() {
		return BU_IDENTITY_CODE;
	}
	public void setBU_IDENTITY_CODE(String bU_IDENTITY_CODE) {
		BU_IDENTITY_CODE = bU_IDENTITY_CODE;
	}
	public String getBU_MOBILE() {
		return BU_MOBILE;
	}
	public void setBU_MOBILE(String bU_MOBILE) {
		BU_MOBILE = bU_MOBILE;
	}
	public Date getBu_createtime() {
		return bu_createtime;
	}
	public void setBu_createtime(Date bu_createtime) {
		this.bu_createtime = bu_createtime;
	}
	public Date getBu_createuser() {
		return bu_createuser;
	}
	public void setBu_createuser(Date bu_createuser) {
		this.bu_createuser = bu_createuser;
	}
	public Date getBu_updatetime() {
		return bu_updatetime;
	}
	public void setBu_updatetime(Date bu_updatetime) {
		this.bu_updatetime = bu_updatetime;
	}
	public Date getBu_updateuser() {
		return bu_updateuser;
	}
	public void setBu_updateuser(Date bu_updateuser) {
		this.bu_updateuser = bu_updateuser;
	}
	public Integer getBU_STATUS() {
		return BU_STATUS;
	}
	public void setBU_STATUS(Integer bU_STATUS) {
		BU_STATUS = bU_STATUS;
	}      

}
