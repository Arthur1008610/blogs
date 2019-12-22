package com.luban.service;

import java.util.List;

import com.luban.po.BlogUser;
import com.luban.po.PageInfo;

public interface BlogUserSerivce {
	/**
	 * 登录
	 */

	public BlogUser queryBlogByNameAndPwd(String username, String pwd);
	/**
	 * 
	 * 查询全部
	 */

	public List<BlogUser> query();
	/**
	 * 添加文章分类
	 * 
	 * 
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
