package com.luban.service.impl;

import java.util.List;

import com.luban.dao.BlogArticleCategoryDao;
import com.luban.dao.BlogArticleDao;
import com.luban.dao.impl.BlogArticleCategoryDaoImpl;
import com.luban.dao.impl.BlogArticleDaoImpl;
import com.luban.po.BlogArticleCategory;
import com.luban.service.BlogArticleCategoryService;



public class BlogArticleCategoryServiceImpl implements
		BlogArticleCategoryService {		
		BlogArticleCategoryDao aa=new BlogArticleCategoryDaoImpl();
		BlogArticleDao articleDao = new BlogArticleDaoImpl();
	public List<BlogArticleCategory> query() {
		// TODO Auto-generated method stub
		return aa.query();
	}
	public List<BlogArticleCategory> queryParent() {
		// TODO Auto-generated method stub
		return aa.queryParent();
	}
	public int save(BlogArticleCategory articleCategory) {
		// TODO Auto-generated method stub
		return aa.save(articleCategory);
	}
	public int delete(Integer bacChildId, Integer bacParentId) {
		int i =0;
		//需要业务逻辑处理
		//通过id查询文章信息
		int count =articleDao.queryCount(bacChildId,bacParentId);
		System.out.println(count);
		if(count==0){//只有等于0的时候操作删除
			i=aa.delete(bacChildId,bacParentId);
		}
		return i;
	}
	
	
	

}
