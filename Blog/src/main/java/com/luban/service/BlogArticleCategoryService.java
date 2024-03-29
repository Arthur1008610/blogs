package com.luban.service;

import java.util.List;

import com.luban.po.BlogArticleCategory;

public interface BlogArticleCategoryService {

	public List<BlogArticleCategory> query();

	public List<BlogArticleCategory> queryParent();

	public int save(BlogArticleCategory articleCategory);

	public int delete(Integer bacChildId, Integer bacParentId);

}
