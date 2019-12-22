package com.luban.dao;

import java.util.List;

import com.luban.po.BlogComment;
/**
 * BlogArticleServlet.java
 *describe:
 *2019 年 下午3:28:49
 *小张
 */


public interface BlogCommentDao {

	
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
	
	
	
	/**t
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
