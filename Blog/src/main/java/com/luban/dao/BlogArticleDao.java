package com.luban.dao;

import java.util.List;

import com.luban.po.BlogArticle;
import com.luban.po.BlogArticleCategory;
import com.luban.po.BlogUser;
import com.luban.po.PageInfo;

/**
 * BlogArticleDao.java
 *describe:
 *2019 年 下午7:20:11
 *小张
 */
public interface BlogArticleDao {

	/**
	 * 根据分类id查询文章信息
	 */
	public int queryCountArticle(int bacId);

	public int queryCount(Integer bacChildId, Integer bacParentId);
	
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
