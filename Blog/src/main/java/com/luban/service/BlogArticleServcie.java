package com.luban.service;



import java.util.List;

import com.luban.dao.BlogArticleDao;
import com.luban.po.BlogArticle;
import com.luban.po.PageInfo;

/**
 * BlogArticleServcie.java
 *describe:
 *2019 年 下午3:23:43
 *小张
 */
public interface BlogArticleServcie {
  
	/**
	 *  分页查询
	 */
	public List<BlogArticle> pageList(PageInfo info,BlogArticle article);
	
	/**
	 * 获得总条数
	 */
	public int getToltalCount(BlogArticle article);
	
	
	/**
	 * 查询 文章分类信息
	 * @return List<BlogUser>
	 */
	public List<BlogArticle> query();
	
	
	/**
	 * 添加文章分类
	 * @param a
	 * @return int
	 */
	public int save(BlogArticle article);
	
	/**
	 * 删除  
	 * 
	 */
	public int delete(int id);
	
	/**
	 * 根据id查询
	 */
	public BlogArticle findUserById(int id);

	/**
	 * 修改方法
	 */
	public int update(BlogArticle article);
}
