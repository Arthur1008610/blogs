<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>留言_无涯个人博客 - </title>
<meta name="keywords" content="个人博客,无涯个人博客,个人博客模板,无涯" />
<meta name="description" content="无涯个人博客，8年IT行业经验,曾就职于蓝盾股份、广发银行、XX知名学校教学。" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script>
window.onload = function ()
{
	var oH2 = document.getElementsByTagName("h2")[0];
	var oUl = document.getElementsByTagName("ul")[0];
	oH2.onclick = function ()
	{
		var style = oUl.style;
		style.display = style.display == "block" ? "none" : "block";
		oH2.className = style.display == "block" ? "open" : ""
	}
}
</script>
</head>
<body>
<header>
  <div class="tophead">
    <div class="logo"><a href="/">无涯个人博客</a></div>
    <div id="mnav">
      <h2><span class="navicon"></span></h2>
      <ul>
        <li><a href="index.jsp">网站首页</a></li>
        <li><a href="about.jsp">关于我</a></li>
        <li><a href="query.ba">学无止境</a></li>
        <li><a href="gbook.jsp">留言</a></li>
      </ul>
    </div>
    <nav class="topnav" id="topnav">
      <ul>
        <li><a href="index.jsp">网站首页</a></li>
        <li><a href="about.jsp">关于我</a></li>
        <li><a href="query.ba">学无止境</a></li>
        <li><a href="gbook.jsp">留言</a></li>
      </ul>
    </nav>
  </div>
</header>
<article>
  <h1 class="t_nav"><span>像“草根”一样，紧贴着地面，低调的存在，冬去春来，枯荣无恙。</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">留言</a></h1>
  <div class="ab_box">
    <div class="leftbox">
      <div class="newsview">
     
       
				<form action="save.cuba"  method="post">
				<table class="form">
					
					<tr>
						<td class="field">留言：</td>
						<td><input type="text"  name="content" /></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text"  name="username" /></td>
					</tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加留言" /></label></td>
					</tr>
				</table>
			</form>
			
      </div>
    </div>
    <div class="rightbox">
      <div class="aboutme">
        <h2 class="hometitle">关于我</h2>
        <div class="avatar"> <img src="images/avatar.jpg"> </div>
        <div class="ab_con">
          <p>网名： 无涯</p>
          <p>职业：JAVA高级讲师 </p>
          <p>个人微信：无涯</p>
          <p>邮箱：adam8831@163.com</p>
        </div>
      </div>
      <div class="weixin">
        <h2 class="hometitle">微信关注</h2>
        <ul>
          <img src="images/wx.jpg">
        </ul>
      </div>
    </div>
  </div>
</article>
<footer>
  <p>Design by <a href="/">无涯个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>
