/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-11-22 07:24:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t\t\t.err{\r\n");
      out.write("\t\t\t\tcolor: red;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.ok{\r\n");
      out.write("\t\t\t\tcolor: green;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("//验证用户名\r\n");
      out.write("\t//用来校验是否为空的\r\n");
      out.write("\tvar notNullExp=/^[\\s'　']*$/;\t\r\n");
      out.write("\tfunction checkName(obj){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar bu_user_name = obj.value;\r\n");
      out.write("\t\t//获取font元素\r\n");
      out.write("\t\tvar font1=document.getElementById(\"font1\");\r\n");
      out.write("\t\t//判断是否为空\r\n");
      out.write("\t\tif(notNullExp.test(bu_user_name)){\r\n");
      out.write("\t\t\tfont1.innerHTML=\"用户名不能为空\";\r\n");
      out.write("\t\t\tfont1.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//如果都正确设置的格式\r\n");
      out.write("\t\tfont1.innerHTML=\"正确\";\r\n");
      out.write("\t\tfont1.className=\"ok\";\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("//验证密码\r\n");
      out.write("\tfunction checkpwd(obj){\r\n");
      out.write("\t\tvar bu_password = obj.value;\r\n");
      out.write("\t\t//获取font元素\r\n");
      out.write("\t\tvar font2=document.getElementById(\"font2\");\r\n");
      out.write("\t\tif(notNullExp.test(bu_password)){\r\n");
      out.write("\t\t\tfont2.innerHTML=\"密码不能为空\";\r\n");
      out.write("\t\t\tfont2.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//判断密码不能低于6位\r\n");
      out.write("\t\tif(bu_password.length<6){\r\n");
      out.write("\t\t\tfont2.innerHTML=\"密码不能低于6位\";\r\n");
      out.write("\t\t\tfont2.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfont2.innerHTML=\"正确\";\r\n");
      out.write("\t\tfont2.className=\"ok\";\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("//验证重复密码\r\n");
      out.write("\tfunction checkrepwd(obj){\r\n");
      out.write("\t\t//获得密码\r\n");
      out.write("\t\tvar bu_password = document.getElementById(\"bu_password\").value;\r\n");
      out.write("\t\t//获得重复密码\r\n");
      out.write("\t\tvar bu_repassword = obj.value;\r\n");
      out.write("\t\tvar font3 = document.getElementById(\"font3\");\r\n");
      out.write("\t\t//校验是否为空\r\n");
      out.write("\t\tif(notNullExp.test(bu_repassword)){\r\n");
      out.write("\t\t\tfont3.innerHTML=\"重复密码不能为空\";\r\n");
      out.write("\t\t\tfont3.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//校验两次密码是否一致\r\n");
      out.write("\t\tif(bu_password!=bu_repassword){\r\n");
      out.write("\t\t\tfont3.innerHTML=\"两次密码输入不一致\";\r\n");
      out.write("\t\t\tfont3.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfont3.innerHTML=\"正确\";\r\n");
      out.write("\t\tfont3.className=\"ok\";\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("//验证性别\r\n");
      out.write("\tfunction checksex(obj){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//获取性别\r\n");
      out.write("\t\tvar bu_sex = obj.value;\r\n");
      out.write("\t\tvar font4 = document.getElementById(\"font4\");\r\n");
      out.write("\t\t//校验是否为空\r\n");
      out.write("\t\tif(notNullExp.test(bu_sex)){\r\n");
      out.write("\t\t\tfont4.innerHTML=\"性别不能为空\";\r\n");
      out.write("\t\t\tfont4.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfont4.innerHTML=\"正确\";\r\n");
      out.write("\t\tfont4.className=\"ok\";\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("//验证电话\r\n");
      out.write("\tfunction checkmobile(obj){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t//获取性别\r\n");
      out.write("\t\tvar bu_mobile = obj.value;\r\n");
      out.write("\t\tvar font5 = document.getElementById(\"font5\");\r\n");
      out.write("\t\t//校验是否为空\r\n");
      out.write("\t\tif(notNullExp.test(bu_mobile)){\r\n");
      out.write("\t\t\tfont5.innerHTML=\"电话不能为空\";\r\n");
      out.write("\t\t\tfont5.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfont5.innerHTML=\"正确\";\r\n");
      out.write("\t\tfont5.className=\"ok\";\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//验证邮箱\r\n");
      out.write("\t\r\n");
      out.write("\t//校验邮箱\r\n");
      out.write("\tfunction checkemail(obj){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar bu_email = obj.value;\r\n");
      out.write("\t\t//获取font元素\r\n");
      out.write("\t\tvar font6=document.getElementById(\"font6\");\r\n");
      out.write("\t\t//判断是否为空\r\n");
      out.write("\t\tif(notNullExp.test(bu_email)){\r\n");
      out.write("\t\t\tfont6.innerHTML=\"邮箱不能为空\";\r\n");
      out.write("\t\t\tfont6.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//用来校验邮箱格式\r\n");
      out.write("\t\tvar emailExp = /^\\w+(\\.\\w+)*@\\w+(\\.\\w+)+$/;\r\n");
      out.write("\t\tif(!emailExp.test(bu_email)){\r\n");
      out.write("\t\t\tfont6.innerHTML=\"请输入正确的邮箱\";\r\n");
      out.write("\t\t\tfont6.className=\"err\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//如果都正确设置的格式\r\n");
      out.write("\t\tfont6.innerHTML=\"正确\";\r\n");
      out.write("\t\tfont6.className=\"ok\";\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<h1>欢迎来到注册页面</h1>\r\n");
      out.write("\t\t\t\t\t<form action=\"register.abcd\"  method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >姓名：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"bu_user_name\"  id=\"bu_user_name\"   onblur=\"checkName(this)\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font id=\"font1\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >密码：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"bu_password\"  id=\"bu_password\"   onblur=\"checkpwd(this)\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font id=\"font2\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >重复：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"bu_repassword\" id=\"bu_repassword\"   onblur=\"checkrepwd(this)\"   />\r\n");
      out.write("\t\t\t\t\t\t\t\t<font id=\"font3\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >性别：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"bu_sex\" id=\"bu_sex\"   onblur=\"checksex(this)\" /> \r\n");
      out.write("\t\t\t\t\t\t\t\t<font id=\"font4\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >电话：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"bu_mobile\" id=\"bu_mobile\"   onblur=\"checkmobile(this)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<font id=\"font5\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>邮箱：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"bu_email\" id=\"bu_email\" onblur=\"checkemail(this);\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font id=\"font6\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t<td >\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"ui-blue\"><input type=\"submit\" name=\"submit\" value=\"添加\" /></label>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}