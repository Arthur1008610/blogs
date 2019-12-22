package com.luban.po;
/**
 * BlogArticleCategory.java
 *describe:
 *2019 年 上午11:01:49
 *小张
 */
public class BlogArticleCategory {
	private Integer bacId;//文章分类id
	private String bacName;//--文章分类名称
	private Integer bacParentId;//文章分类父id
	public Integer getBacId() {
		return bacId;
	}
	public void setBacId(Integer bacId) {
		this.bacId = bacId;
	}
	public String getBacName() {
		return bacName;
	}
	public void setBacName(String bacName) {
		this.bacName = bacName;
	}
	public Integer getBacParentId() {
		return bacParentId;
	}
	public void setBacParentId(Integer bacParentId) {
		this.bacParentId = bacParentId;
	}
	
	

}
