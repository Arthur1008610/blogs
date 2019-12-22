<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>学无止境_无涯个人博客 - </title>
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

function onSubmit(){
	var ba_title = document.getElementById("searchform");
	ba_title.submit();
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
        <li><a href="query.cuba">留言</a></li>
      </ul>
    </div>
    <nav class="topnav" id="topnav">
      <ul>
        <li><a href="index.jsp">网站首页</a></li>
        <li><a href="about.jsp">关于我</a></li>
        <li><a href="query.ba">学无止境</a></li>
        <li><a href="query.cuba">留言</a></li>
      </ul>
    </nav>
  </div>
</header>
<article>
  <h1 class="t_nav"><span>不要轻易放弃。学习成长的路上，我们长路漫漫，只因学无止境。 </span><a href="/" class="n1">网站首页</a><a href="/" class="n2">学无止境</a></h1>
  <div class="blogs">
    <div class="mt20"></div>
    <c:forEach var="li" items="${list }">
    	 <li> 
		      <h3 class="blogtitle"><a href="/">${li.baTitle }</a></h3>
		      <div class="bloginfo">
		        <p>${li.baDescription }</p>
		      </div>
		      <div class="autor"><span class="lm"><a href="/" title="CSS3|Html5" target="_blank" class="classname">${li.bacName }</a></span><span class="dtime">${li.createtime }</span><span class="viewnum">浏览（<a href="/">0</a>）</span><span class="readmore"><a href="/">阅读原文</a></span></div>
		    </li> 
    
    </c:forEach>
   
    <div class="pagelist"><a title="Total record">&nbsp;
    <b>${info.totalCount }</b> 
    <c:forEach begin="1" step="1" end="${info.totalPageCount }">
    	<c:set var="i" value="${i+1 }"></c:set>
    	<a href="query.ba?currPageNo=${i }">${i }</a>&nbsp;
    </c:forEach>
    <c:if test="${info.currPageNo<info.totalPageCount }" var="flag">
	    <a href="query.ba?currPageNo=${info.currPageNo+1 }">下一页</a>&nbsp;
	    <a href="query.ba?currPageNo=${info.totalPageCount }">尾页</a></div>
    </c:if>
    <c:if test="${!flag }">
    	<a >下一页</a>&nbsp;
	    <a >尾页</a></div>
    </c:if>
  </div>
  <div class="sidebar">
    <div class="search">
      <form action="query.ba" method="post" name="searchform" id="searchform">
        <input name="ba_title" id="ba_title" class="input_text" value="${article.baTitle }" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
        <input name="Submit" class="input_submit" value="搜索" type="button" onclick="onSubmit();">
      </form>
    </div>
    <div class="lmnav">
      <h2 class="hometitle">栏目导航</h2>
      <ul class="navbor">
        <li><a href="#">文章分类</a></li>
        
        <c:forEach var="li" items="${bacList }">
        
        
        	<c:if test="${li.bacId==li.bacParentId }" var="flags">
        		<li><a href="query.ba?bacParentId=${li.bacParentId }">${li.bacName }</a>
        	</c:if>
	        
	          <ul>
	          	<c:if test="${!flags }">
	            	<li><a href="query.ba?childId=${li.bacId }">${li.bacName }</a></li>
	            </c:if>
	          </ul>
       </c:forEach>
        </li>
      </ul>
    </div>
    <div class="paihang">
      <h2 class="hometitle">点击排行</h2>
      <ul>
        <li><b><a href="/download/div/2015-04-10/746.jsp" target="_blank">【活动作品】柠檬绿兔小白个人博客模板30...</a></b>
          <p>展示的是首页html，博客页面布局格式简单，没有复杂的背景，色彩局部点缀，动态的幻灯片展示，切换卡，标...</p>
        </li>
        <li><b><a href="/download/div/2014-02-19/649.jsp" target="_blank"> 个人博客模板（2014草根寻梦）30...</a></b>
          <p>2014第一版《草根寻梦》个人博客模板简单、优雅、稳重、大气、低调。专为年轻有志向却又低调的草根站长设...</p>
        </li>
        <li><b><a href="/download/div/2013-08-08/571.jsp" target="_blank">黑色质感时间轴html5个人博客模板30...</a></b>
          <p>黑色时间轴html5个人博客模板颜色以黑色为主色，添加了彩色作为网页的一个亮点，导航高亮显示、banner图片...</p>
        </li>
        <li><b><a href="/download/div/2014-09-18/730.jsp" target="_blank">情侣博客模板系列之《回忆》Html30...</a></b>
          <p>Html5+css3情侣博客模板，主题《回忆》，使用css3技术实现网站动画效果，主题《回忆》,分为四个主要部分，...</p>
        </li>
        <li><b><a href="/download/div/2014-04-17/661.jsp" target="_blank">黑色Html5个人博客模板主题《如影随形》30...</a></b>
          <p>014第二版黑色Html5个人博客模板主题《如影随形》，如精灵般的影子会给人一种神秘的感觉。一张剪影图黑白...</p>
        </li>
        <li><b><a href="/jstt/bj/2015-01-09/740.jsp" target="_blank">【匆匆那些年】总结个人博客经历的这四年…30...</a></b>
          <p>博客从最初的域名购买，到上线已经有四年的时间了，这四年的时间，有笑过，有怨过，有悔过，有执着过，也...</p>
        </li>
      </ul>
    </div>
    <div class="cloud">
      <h2 class="hometitle">标签云</h2>
      <ul>
        <a href="/">陌上花开</a> <a href="/">校园生活</a> <a href="/">html5</a> <a href="/">SumSung</a> <a href="/">青春</a> <a href="/">温暖</a> <a href="/">阳光</a> <a href="/">三星</a><a href="/">索尼</a> <a href="/">华维荣耀</a> <a href="/">三星</a> <a href="/">索尼</a>
      </ul>
    </div>
    <div class="paihang">
      <h2 class="hometitle">站长推荐</h2>
      <ul>
        <li><b><a href="/download/div/2015-04-10/746.jsp" target="_blank">【活动作品】柠檬绿兔小白个人博客模板30...</a></b>
          <p>展示的是首页html，博客页面布局格式简单，没有复杂的背景，色彩局部点缀，动态的幻灯片展示，切换卡，标...</p>
        </li>
        <li><b><a href="/download/div/2014-02-19/649.jsp" target="_blank"> 个人博客模板（2014草根寻梦）30...</a></b>
          <p>2014第一版《草根寻梦》个人博客模板简单、优雅、稳重、大气、低调。专为年轻有志向却又低调的草根站长设...</p>
        </li>
        <li><b><a href="/download/div/2013-08-08/571.jsp" target="_blank">黑色质感时间轴html5个人博客模板30...</a></b>
          <p>黑色时间轴html5个人博客模板颜色以黑色为主色，添加了彩色作为网页的一个亮点，导航高亮显示、banner图片...</p>
        </li>
        <li><b><a href="/download/div/2014-09-18/730.jsp" target="_blank">情侣博客模板系列之《回忆》Html30...</a></b>
          <p>Html5+css3情侣博客模板，主题《回忆》，使用css3技术实现网站动画效果，主题《回忆》,分为四个主要部分，...</p>
        </li>
        <li><b><a href="/download/div/2014-04-17/661.jsp" target="_blank">黑色Html5个人博客模板主题《如影随形》30...</a></b>
          <p>014第二版黑色Html5个人博客模板主题《如影随形》，如精灵般的影子会给人一种神秘的感觉。一张剪影图黑白...</p>
        </li>
        <li><b><a href="/jstt/bj/2015-01-09/740.jsp" target="_blank">【匆匆那些年】总结个人博客经历的这四年…30...</a></b>
          <p>博客从最初的域名购买，到上线已经有四年的时间了，这四年的时间，有笑过，有怨过，有悔过，有执着过，也...</p>
        </li>
      </ul>
    </div>
    <div class="weixin">
      <h2 class="hometitle">个人微信</h2>
      <ul>
        <img src="images/wx.jpg">
      </ul>
    </div>
  </div>
</article>
<footer>
  <p>Design by <a href="/">无涯个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>

