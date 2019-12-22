package com.luban.service.impl;

import java.util.List;

import com.luban.dao.BlogUserDao;
import com.luban.dao.impl.BlogUserDaoimpl;
import com.luban.po.BlogUser;
import com.luban.po.PageInfo;
import com.luban.service.BlogUserSerivce;

public class BlogUserSerivceimpl implements BlogUserSerivce {
 private BlogUserDao bloguserdao=new BlogUserDaoimpl();
 	
	public List<BlogUser> query() {
		// TODO Auto-generated method stub
		return bloguserdao.query();
	}

	public int save(BlogUser bloguser) {
		// TODO Auto-generated method stub
		return bloguserdao.save(bloguser);
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return bloguserdao.delete(id);
	}
	public int update(BlogUser bloguser) {
		// TODO Auto-generated method stub
		return bloguserdao.update(bloguser);
	}
	public BlogUser findById(int id) {
		// TODO Auto-generated method stub
		return bloguserdao.findById(id);
	}

	public BlogUser queryBlogByNameAndPwd(String username, String pwd) {
		// TODO Auto-generated method stub
		return bloguserdao.queryBlogByNameAndPwd(username, pwd);
	}
	/**
	 * 分页查询
	 */
	public List<BlogUser> pagelist(PageInfo  info,BlogUser bloguser){
		return bloguserdao.pagelist(info, bloguser);
	}
	
	/**
	 * 获得总条数
	 */
	public int getTotalcount(BlogUser bloguser){
		return bloguserdao.getTotalcount(bloguser);
	}
	
	
	
	
}
