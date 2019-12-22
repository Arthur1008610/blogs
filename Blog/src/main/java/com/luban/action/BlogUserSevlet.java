package com.luban.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luban.po.BlogArticleCategory;
import com.luban.po.BlogUser;
import com.luban.po.PageInfo;
import com.luban.service.BlogUserSerivce;
import com.luban.service.impl.BlogUserSerivceimpl;
/**
 * BlogUserSevlet.java
 *describe:
 *2019 年 下午9:37:10
 *小张
 */
@WebServlet(urlPatterns = "*.abcd")
public class BlogUserSevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 处理编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// 获取URI
		String uri = req.getRequestURI();
		// 载取
		String url = (String) uri.subSequence(uri.lastIndexOf("/") + 1,
				uri.lastIndexOf("."));
		System.out.println(url);

		// 调用业务层
		BlogUserSerivce bacServ = new BlogUserSerivceimpl();
		if ("queiry".equals(url)) {

			List<BlogUser> list = bacServ.query();
			// 3.把对象存入request作用域中
			req.setAttribute("list", list);
			// 4.转发到blogClass.jsp
			req.getRequestDispatcher("user.jsp").forward(req, resp);
			System.out.println("queiry");
		} else if ("save".equals(url)) {
			// 1获得页面数据
			String username = req.getParameter("bu_user_name");
			String pwd = req.getParameter("bu_password");
			String sex = req.getParameter("bu_sex");
			String mobile = req.getParameter("bu_mobile");
			String email = req.getParameter("bu_email");
			// 2封装数据到BlogUser中
			BlogUser bloguser = new BlogUser();
			bloguser.setBU_USER_NAME(username);
			bloguser.setBU_PASSWORD(pwd);
			bloguser.setBU_SEX(sex);
			bloguser.setBU_MOBILE(mobile);
			bloguser.setBU_EMAIL(email);
			// 3调用业务层
			int i = bacServ.save(bloguser);
			System.out.println(i);
			if (i > 0) {
				out.print("<script type='text/javascript'>alert('添加成功');window.location.href='queiry.abcd';</script>");
			}

			System.out.println("save");
		} else if ("delete".equals(url)) {
			// 获取参数
			Integer id = Integer.parseInt(req.getParameter("bu_user_id"));
			// 调用业务层
			int i = bacServ.delete(id);
			if (i > 0) {
				out.print("删除成功");
			} else {
				out.print("删除失败");
			}
		} else if ("update".equals(url)) {
			System.out.println("update");
			// 1获得页面数据
			Integer id = new Integer(req.getParameter("id"));
			String username = req.getParameter("bu_user_name");
			System.out.println(req.getParameter("bu_user_name"));
			String pwd = req.getParameter("bu_password");
			String sex = req.getParameter("bu_sex");
			String mobile = req.getParameter("bu_mobile");
			String email = req.getParameter("bu_email");
			// System.out.println(username);
			// 2封装数据到BlogUser中

			BlogUser bloguser = new BlogUser();
			bloguser.setBu_user_id(id);
			bloguser.setBU_USER_NAME(username);
			bloguser.setBU_PASSWORD(pwd);
			bloguser.setBU_SEX(sex);
			bloguser.setBU_MOBILE(mobile);
			bloguser.setBU_EMAIL(email);

			// 3调用业务层
			int i = bacServ.update(bloguser);
			System.out.println("i");
			if (i > 0) {
				out.print("修改成功");
			} else {
				out.print("修改失败");
			}
		} else if ("findById".equals(url)) {

			// 1.接收页面传递过来的id
			Integer id = new Integer(req.getParameter("idddd"));
			// 2.调用dao中的方法，根据id去查询
			BlogUser bloguser = bacServ.findById(id);
			// 3.把user存入request中
			req.setAttribute("bloguser", bloguser);
			// 3.转发到
			req.getRequestDispatcher("user-modify.jsp").forward(req, resp);
		} else if ("login".equals(url)) {
			System.out.println("login");
			// 获取参数
			String username = req.getParameter("username");
			String pwd = req.getParameter("pwd");

			String msg = "";
			// 判断 不为空，才去调 用登陆方法
			if (!username.equals("") && !pwd.equals("")) {
				// 调用登陆方法

				BlogUser user = bacServ.queryBlogByNameAndPwd(username, pwd);
				if (user != null) {

					resp.sendRedirect(req.getContextPath() + "index.jsp");

				} else {

					msg = "用户名或密码有误";
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			} else {

				msg = "用户名或密码有误";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else if ("register".equals(url)) {
			// 1获得页面数据
			String username = req.getParameter("bu_user_name");
			String pwd = req.getParameter("bu_password");
			String sex = req.getParameter("bu_sex");
			String mobile = req.getParameter("bu_mobile");
			String email = req.getParameter("bu_email");
			// 2封装数据到BlogUser中
			BlogUser bloguser = new BlogUser();
			bloguser.setBU_USER_NAME(username);
			bloguser.setBU_PASSWORD(pwd);
			bloguser.setBU_SEX(sex);
			bloguser.setBU_MOBILE(mobile);
			bloguser.setBU_EMAIL(email);
			// 3调用业务层
			int i = bacServ.save(bloguser);
			System.out.println(i);
			if (i > 0) {
				out.print("<script type='text/javascript'>alert('添加成功');window.location.href='login.jsp';</script>");
			}

			System.out.println("register");
		}else if("fenye".equals(url)){
			//获取参数
			String currPageNo =req.getParameter("currPageNo");//当前页码
			//封装参数
			PageInfo info = new PageInfo();
			if(currPageNo!=null){
				info.setCurrPageNo(Integer.parseInt(currPageNo));
			}
			BlogUser bloguser=new BlogUser();
			//调用业务层分页
			 List<BlogUser> list=bacServ.pagelist(info, bloguser);
			//调用业务层查询总条数
			 int totalCount=bacServ.getTotalcount(bloguser);
			//把总条数存入info中
			info.setTotalCount(totalCount);
			//存入request作用域
			req.setAttribute("info", info);
			req.setAttribute("bloguser", bloguser);
			req.setAttribute("list", list);
			//转发到user.jsp
			req.getRequestDispatcher("user.jsp").forward(req, resp);
			
			System.out.println("fenye");
		}
	}

}
