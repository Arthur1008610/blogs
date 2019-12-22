package com.luban.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luban.po.BlogArticle;
import com.luban.po.BlogArticleCategory;
import com.luban.po.BlogUser;
import com.luban.po.PageInfo;
import com.luban.service.BlogArticleCategoryService;
import com.luban.service.BlogArticleServcie;
import com.luban.service.impl.BlogArticleCategoryServiceImpl;
import com.luban.service.impl.BlogArticleServiceImpl;


/**
 * BlogArticleServlet.java
 *describe:
 *2019 年 下午3:28:49
 *小张
 */
@WebServlet(urlPatterns="*.ba")
public class BlogArticleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//获取URI
		String uri=req.getRequestURI();
		//载取
		String url = (String)uri.subSequence(uri.lastIndexOf("/")+1, uri.lastIndexOf(".")); 
		System.out.println(url);
		//1.创建业务层对象
		BlogArticleCategoryService bacServ = new BlogArticleCategoryServiceImpl();
		//博文业务层对象
		BlogArticleServcie blogArticleServcie = new BlogArticleServiceImpl();
		if("query".equals(url)){//分页查询
			
			//2.获得请求参数
			String currPageNo =req.getParameter("currPageNo");//当前页码
			String bacParentId = req.getParameter("bacParentId");
			String childId = req.getParameter("childId");
			String ba_title = req.getParameter("ba_title");
			//3.封装参数
			PageInfo info = new PageInfo();
			if(currPageNo!=null){
				info.setCurrPageNo(Integer.parseInt(currPageNo));
			}
			BlogArticle article = new BlogArticle();
			article.setBaTitle(ba_title);
			if(bacParentId!=null){
				article.setBacId(Integer.parseInt(bacParentId));
			}
			if(childId!=null){
				article.setBacChildId(Integer.parseInt(childId));
			}
			//4.调用业务层分页查询方法 
			List<BlogArticle> list = blogArticleServcie.pageList(info, article);
			//5.调用获得总条数方法
			int totalCount = blogArticleServcie.getToltalCount(article);
			//把总条数存入info中
			info.setTotalCount(totalCount);
			//6.查询文章分类信息
			List<BlogArticleCategory> bacList = bacServ.query();
			//7.把数据存入reqeust作用域 中
			req.setAttribute("info", info);
			req.setAttribute("article", article);
			req.setAttribute("list", list);
			req.setAttribute("bacList", bacList);
			
			//8.转发到list.jsp
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}else if("queiry".equals(url)){//分页查询
			
			List<BlogArticle> list = blogArticleServcie.query();
			// 3.把对象存入request作用域中
			req.setAttribute("list", list);
			// 4.转发到blogClass.jsp
			req.getRequestDispatcher("blog.jsp").forward(req, resp);
			System.out.println("queiry");
		}else if ("blogClassAddGo".equals(url)) {
			//2.调用业务层方法
			List<BlogArticleCategory> parentList = bacServ.queryParent();
			//3.把对象存入request作用域中 
			req.setAttribute("parentList", parentList);
			//4.转发到blogClass-add.jsp
			req.getRequestDispatcher("blog-add.jsp").forward(req, resp);
			System.out.println("blogClassAddGo");
		} else if("save".equals(url)){
			//获取请求参数
			String title=req.getParameter("title");
			//Integer parentId = Integer.parseInt(req.getParameter("parentId"));
			String description = req.getParameter("description");
			
			//把值存入对象中
			BlogArticle article=new BlogArticle();
			article.setBaTitle(title);
			article.setBaDescription(description);
			
			//调用业务层方法
			int i=blogArticleServcie.save(article);
			if(i>0){
				out.print("<script type='text/javascript'>alert('添加成功');window.location.href='queiry.ba';</script>");
			}
			
		}else if("delete".equals(url)){
			Integer id = Integer.parseInt(req.getParameter("baId"));
			//调用业务层
			int i=blogArticleServcie.delete(id);
			if(i>0){
				out.print("删除成功");
			}else{
				out.print("删除失败");
			}
			System.out.println("delete");
		}else if("findById".equals(url)){
			//1.接收页面传递过来的id
			Integer id=new Integer(req.getParameter("idddd"));
			//2.调用dao中的方法，根据id去查询
			BlogArticle article=blogArticleServcie.findUserById(id);
			//3.把article存入request中，
			req.setAttribute("article", article);
			
			//4.转发到
			req.getRequestDispatcher("blog-modify.jsp").forward(req, resp);
			System.out.println("findById");
		}else if("update".equals(url)){
			//1.接收页面的值
			Integer id=new Integer(req.getParameter("id"));
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			//2.封装
			BlogArticle article=new BlogArticle();
			article.setBaId(id);
			article.setBaTitle(title);
			article.setBaDescription(description);
			//3.调用dao中的修改方法
			int i=blogArticleServcie.update(article);
			if(i>0){
				out.print("修改成功");
			}else{
				out.print("修改失败");
			}
			System.out.println("update");
		}
		
	}

}
