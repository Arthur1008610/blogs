<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
			.err{
				color: red;
			}
			.ok{
				color: green;
			}
		</style>
<script type="text/javascript">

//验证用户名
	//用来校验是否为空的
	var notNullExp=/^[\s'　']*$/;	
	function checkName(obj){
		
		var bu_user_name = obj.value;
		//获取font元素
		var font1=document.getElementById("font1");
		//判断是否为空
		if(notNullExp.test(bu_user_name)){
			font1.innerHTML="用户名不能为空";
			font1.className="err";
			return false;
		}
		
		//如果都正确设置的格式
		font1.innerHTML="正确";
		font1.className="ok";
		return true;
	}
//验证密码
	function checkpwd(obj){
		var bu_password = obj.value;
		//获取font元素
		var font2=document.getElementById("font2");
		if(notNullExp.test(bu_password)){
			font2.innerHTML="密码不能为空";
			font2.className="err";
			return false;
		}
		//判断密码不能低于6位
		if(bu_password.length<6){
			font2.innerHTML="密码不能低于6位";
			font2.className="err";
			return false;
		}
		
		font2.innerHTML="正确";
		font2.className="ok";
		return true;
		
	}
//验证重复密码
	function checkrepwd(obj){
		//获得密码
		var bu_password = document.getElementById("bu_password").value;
		//获得重复密码
		var bu_repassword = obj.value;
		var font3 = document.getElementById("font3");
		//校验是否为空
		if(notNullExp.test(bu_repassword)){
			font3.innerHTML="重复密码不能为空";
			font3.className="err";
			return false;
		}
		
		//校验两次密码是否一致
		if(bu_password!=bu_repassword){
			font3.innerHTML="两次密码输入不一致";
			font3.className="err";
			return false;	
		}
		font3.innerHTML="正确";
		font3.className="ok";
		return true;
		
	}

//验证性别
	function checksex(obj){
		
		//获取性别
		var bu_sex = obj.value;
		var font4 = document.getElementById("font4");
		//校验是否为空
		if(notNullExp.test(bu_sex)){
			font4.innerHTML="性别不能为空";
			font4.className="err";
			return false;
		}
		font4.innerHTML="正确";
		font4.className="ok";
		return true;
		
	}
//验证电话
	function checkmobile(obj){
			
		//获取性别
		var bu_mobile = obj.value;
		var font5 = document.getElementById("font5");
		//校验是否为空
		if(notNullExp.test(bu_mobile)){
			font5.innerHTML="电话不能为空";
			font5.className="err";
			return false;
		}
		font5.innerHTML="正确";
		font5.className="ok";
		return true;
		
	}


//验证邮箱
	
	//校验邮箱
	function checkemail(obj){
		
		var bu_email = obj.value;
		//获取font元素
		var font6=document.getElementById("font6");
		//判断是否为空
		if(notNullExp.test(bu_email)){
			font6.innerHTML="邮箱不能为空";
			font6.className="err";
			return false;
		}
		//用来校验邮箱格式
		var emailExp = /^\w+(\.\w+)*@\w+(\.\w+)+$/;
		if(!emailExp.test(bu_email)){
			font6.innerHTML="请输入正确的邮箱";
			font6.className="err";
			return false;
		}
		
		//如果都正确设置的格式
		font6.innerHTML="正确";
		font6.className="ok";
		return true;
	}

</script>
</head>
<body>			<div align="center">
					<h1>欢迎来到注册页面</h1>
					<form action="register.abcd"  method="post">
						<table class="form">
							
							<tr>
								<td >姓名：
								<input type="text"  name="bu_user_name"  id="bu_user_name"   onblur="checkName(this)"/>
								<font id="font1"></font>
								</td>
							</tr>
							<tr>
								<td >密码：
								<input type="text"  name="bu_password"  id="bu_password"   onblur="checkpwd(this)"/>
								<font id="font2"></font>
								<td >
							</tr>
							<tr>
								<td >重复：
								<input type="text"  name="bu_repassword" id="bu_repassword"   onblur="checkrepwd(this)"   />
								<font id="font3"></font>
								<td >
							</tr>
							<tr>
								<td >性别：
								<input type="text"  name="bu_sex" id="bu_sex"   onblur="checksex(this)" /> 
								<font id="font4"></font>
								<td >
							</tr>
							
							<tr>
								<td >电话：
								<input type="text"  name="bu_mobile" id="bu_mobile"   onblur="checkmobile(this)" />
								<font id="font5"></font>
								<td >
							</tr>
							<tr>
								<td>邮箱：
								<input type="text"  name="bu_email" id="bu_email" onblur="checkemail(this);"/>
								<font id="font6"></font>
							<td >	
							</tr>
							
							<td>
							<label class="ui-blue"><input type="submit" name="submit" value="添加" /></label>
							</td>
							</tr>
						</table>
					</form>
				</div>	
</body>
</html>