package com.luban.service.impl;

import java.util.List;

import com.luban.dao.BlogCommentDao;
import com.luban.dao.impl.BlogCommentDaoimpl;
import com.luban.po.BlogComment;
import com.luban.service.BlogCommentSerivce;

public class BlogCommentServiceimpl implements BlogCommentSerivce {
private	BlogCommentDao dao=new BlogCommentDaoimpl();
	public List<BlogComment> query() {
		// TODO Auto-generated method stub
		return dao.query();
	}
	public int save(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		return dao.save(blogcomment);
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	public int update(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		return dao.update(blogcomment);
	}
	public BlogComment findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
