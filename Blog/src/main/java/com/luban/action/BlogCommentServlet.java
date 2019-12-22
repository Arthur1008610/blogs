package com.luban.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luban.po.BlogComment;
import com.luban.po.BlogUser;
import com.luban.service.BlogCommentSerivce;
import com.luban.service.impl.BlogCommentServiceimpl;
/**
 * BlogArticleServlet.java
 *describe:
 *2019 年 下午3:28:49
 *小张
 */
@WebServlet(urlPatterns="*.cuba")
public class BlogCommentServlet  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//获取URI
		String uri=req.getRequestURI();
		//载取
		String url = (String)uri.subSequence(uri.lastIndexOf("/")+1, uri.lastIndexOf(".")); 
	
		System.out.println(url);
		BlogCommentSerivce blogcommentservice=new BlogCommentServiceimpl();
		
		if("queiry".equals(url)){
			
			List<BlogComment> list=blogcommentservice.query();
		
			req.setAttribute("list", list);
		
			req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
			System.out.println("queiry");
		}else if("query".equals(url)){
			
			List<BlogComment> list=blogcommentservice.query();
		
			req.setAttribute("list", list);
		
			req.getRequestDispatcher("gbook.jsp").forward(req, resp);
			System.out.println("queiry");
		}else if("save".equals(url)){
			//1页面数据获取
			String content=req.getParameter("content");
			String username=req.getParameter("username");
			//2封装数据到BlogUser中
			BlogComment blogcomment=new BlogComment();
			blogcomment.setContent(content);
			blogcomment.setBUCommentNAME(username);
			
			//3调用业务层
			int i=blogcommentservice.save(blogcomment);
			if(i>0){
				 out.print("<script type='text/javascript'>alert('添加成功');window.location.href='query.cuba';</script>");
			 }
			 
			System.out.println("save");
		}else if("delete".equals(url)){
			//获取参数
			Integer id=Integer.parseInt(req.getParameter("BU_ID"));
			//调用yewuceng
			int i=blogcommentservice.delete(id);
			if(i>0){
				out.print("删除成功");
			}else{
				out.print("删除失败");
			}
			System.out.println("delete");
		}else if("findById".equals(url)){
			//1.接收页面传递过来的id
			System.out.println(req.getParameter("idddd"));
			Integer id=new Integer(req.getParameter("idddd"));
			//2.调用dao中的方法，根据id去查询
			BlogComment blogcomment=blogcommentservice.findById(id);
			//3.把user存入request中
			req.setAttribute("list",blogcomment);
			//3.转发到
			System.out.println(req.getParameter("idddd"));
			req.getRequestDispatcher("guestbook-modify.jsp").forward(req, resp);
			System.out.println("findById");
		}else if("update".equals(url)){
			//1获得页面数据
			System.out.println("id==>"+req.getParameter("id"));
			Integer id=new Integer(req.getParameter("id"));
			
			String BUCONTENT=req.getParameter("BUCONTENT");
			//2封装数据到BlogUser中
			BlogComment blogcomment=new BlogComment();
			blogcomment.setBU_ID(id);
			blogcomment.setBUCONTENT(BUCONTENT);
			//调用业务层
			int i=blogcommentservice.update(blogcomment);
			if(i>0){
				out.print("修改成功");
			}else{
				out.print("修改失败");
			}
			System.out.println("update");
		}
		
		
		
	}
}
