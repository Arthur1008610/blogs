package com.luban.service;

import java.util.List;

import com.luban.po.BlogComment;

public interface BlogCommentSerivce {
	/**
	 * 查询 文章分类信息
	 * @return ListBlogCommen
	 */
	public List<BlogComment> query();
	/**
	 * 添加文章分类
	 * @param 
	 * @return int
	 */
	public int save(BlogComment blogcomment);
	

	/**
	 * 删除  
	 * 
	 */
	public int delete(int id);
	
	/**
	 * 
	 * 修改
	 */
	public int update(BlogComment blogcomment);
	
	/**
	 * 根据id查询分类信息
	 */
	public BlogComment findById(int id);
	
}
