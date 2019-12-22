<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 博客网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="blog.jsp">文章</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">博客网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user.jsp">用户管理</a></dd>
				<dt>博文管理</dt>
				<dd><em><a href="blogClass-add.jsp">新增</a></em><a href="blogClass.jsp">分类管理</a></dd>
				<dd><em><a href="blog-add.jsp">新增</a></em><a href="blog.jsp">文章管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>=
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form action="update.abcd"  method="post">
				<table class="form">
					<input type="hidden" name="id" value="${bloguser.bu_user_id }">
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text"  name="bu_user_name" value="${bloguser.BU_USER_NAME }" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text"  name="bu_password" value="${bloguser.BU_PASSWORD }"/></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="text"  name="bu_sex" value="${bloguser.BU_SEX }" /> 
					</tr>
					
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text"  name="bu_mobile" value="${bloguser.BU_MOBILE }" /></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text"  name="bu_email" value="${bloguser.BU_EMAIL }"/></td>
					</tr>
					
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
