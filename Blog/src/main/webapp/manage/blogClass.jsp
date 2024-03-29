<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 博客网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

	function DeleteBac(bacIdChild,bacParentId){
		alert(bacIdChild +"ddd"+bacParentId);
		$.ajax({
		   type: "POST",
		   url: "delete.abc",
		   data: "bacIdChild="+bacIdChild+"&bacParentId="+bacParentId,
		   success: function(msg){
		     alert( "Data Saved: " + msg );
		     window.location.href="/manage/queiry.abc";
		   }
		}); 
		
	}

</script>
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
				<dd><em><a href="user-add.jsp">新增</a></em><a href="queiry.abcd">用户管理</a></dd>
				<dt>博文管理</dt>
				<dd><em><a href="blogClassAddGo.abc">新增</a></em><a href="queiry.abc">分类管理</a></dd>
				<dd><em><a href="blog-add.jsp">新增</a></em><a href="blog.jsp">文章管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:forEach var="li" items="${list }">
				
					<c:if test="${li.bacId==li.bacParentId }" var="flag">
						<tr>
							<td class="first w4 c">${li.bacId }</td>
							<td>${li.bacName }</td>
							<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> 
							<<a href="javascript:DeleteBac(${li.bacId },${li.bacParentId });">删除1</a></td>
						</tr>
					</c:if>
					
					<c:if test="${!flag }">
						<tr>
							<td class="first w4 c">${li.bacId }</td>
							<td class="childClass">${li.bacName }</td>
							<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> 
							<a href="javascript:DeleteBac(${li.bacId },${li.bacParentId });">删除2</a></td>
						</tr>
					
					</c:if>
				
				</c:forEach>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
