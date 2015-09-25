<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
<style type="text/css">
	#box {border:1px solid #000000;
		  width: 600px;
		  height: 300px;
		  margin-top: 120px;
		 }
	table {text-align: center;}
	tr {height: 45px;}
	input {font-size: 18px;}
	a {font-size: 20px;}
	#myform {margin-top: 50px;}
</style>
<script type="text/javascript">

	$(function() {		
		$("#submit").click(function(){
			var userName = $("#userName").val();
			var password = $("#password").val();
			if (userName.trim() == null || userName.length < 2) {
				alert("用户名不能为空，且长度必须大于2位！");
				return false;
			} else if (userName.trim() == null || password.length < 6) {
				alert("密码不能为空，且长度必须大于6位！");
				return false;
			} else {
				var url = "user-login";
				var args = {"loginName":userName, "loginPwd":password, "time":new Date()};
				$.post(url, args, function(data){
					if (data == "用户不存在") {
						alert("登录失败，用户名不存在！");
					} else if (data == "密码错误") {
						alert("登录失败，用户名或密码错误！");
					} else if (data == "用户冻结") {
						alert("登录失败，该用户账户已冻结！");
					} else if (data == "登录成功") {
						window.location.href = "user-list.action";
					} else {
						alert("内部错误！");
					}
				});
			}
			return false;
		});
	})
	
</script>

</head>
<body>
	
	<center>
	<div id="box">
		<div id="myform">
		
			<h1>商务会员管理系统</h1>
			<s:form action="" method="post" id="userForm">
			<table>
				<tr>
					<td><a>用户名：</a></td>
					<td><s:textfield type="text" name="loginName" id="userName"/></td>
				</tr>
				<tr>
					<td><a>密&nbsp;&nbsp;码：</a></td>
					<td><s:textfield type="password" name="loginPwd" id="password"/></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit name="submit" value="登录" id="submit"/></td>
				</tr>
			</table>
			
			</s:form>
			
		</div>
	</div>
	</center>
	
</body>
</html>