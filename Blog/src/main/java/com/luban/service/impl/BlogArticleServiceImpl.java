package com.luban.service.impl;



import java.util.List;

import com.luban.dao.BlogArticleDao;
import com.luban.dao.impl.BlogArticleDaoImpl;
import com.luban.po.BlogArticle;
import com.luban.po.PageInfo;
import com.luban.service.BlogArticleServcie;


public class BlogArticleServiceImpl implements BlogArticleServcie {
	private BlogArticleDao blogArticleDao  = new BlogArticleDaoImpl();

	public List<BlogArticle> pageList(PageInfo info, BlogArticle article) {
		// TODO Auto-generated method stub
		return blogArticleDao.pageList(info, article);
	}

	public int getToltalCount(BlogArticle article) {
		// TODO Auto-generated method stub
		return blogArticleDao.getToltalCount(article);
	}

	public List<BlogArticle> query() {
		// TODO Auto-generated method stub
		return blogArticleDao.query();
	}

	public int save(BlogArticle article) {
		// TODO Auto-generated method stub
		return blogArticleDao.save(article);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return blogArticleDao.delete(id);
	}

	public BlogArticle findUserById(int id) {
		// TODO Auto-generated method stub
		return blogArticleDao.findUserById(id);
	}

	public int update(BlogArticle article) {
		// TODO Auto-generated method stub
		return blogArticleDao.update(article);
	}
	
}
