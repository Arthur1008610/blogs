package com.luban.dao;


import java.util.List;



import com.luban.po.BlogUser;
import com.luban.po.PageInfo;
/**
 * BlogArticleServlet.java
 *describe:
 *2019 年 下午3:28:49
 *小张
 */
public interface BlogUserDao {

	/**
	 * 登录
	 */

	public BlogUser queryBlogByNameAndPwd(String username, String pwd);
	
	
	
	
	/**
	 * 查询 文章分类信息
	 * @return List<BlogUser>
	 */
	public List<BlogUser> query();
		
	
	/**
	 * 添加文章分类
	 * @param articleCategory
	 * @return int
	 */
	public int save(BlogUser bloguser);
	
	
	
	/**
	 * 删除  
	 * 
	 */
	public int delete(int id);
	
	
	
	/**
	 * 
	 * 修改
	 */
	public int update(BlogUser bloguser);
	
	/**
	 * 根据id查询分类信息
	 */
	public BlogUser findById(int id);
	
	
	/**
	 * 分页查询
	 */
	public List<BlogUser> pagelist(PageInfo  info,BlogUser bloguser);
	
	/**
	 * 获得总条数
	 */
	public int getTotalcount(BlogUser bloguser);
	
}
