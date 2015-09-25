<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {margin:0px; padding-top: -100px;}
	table {border:2px solid gray;
		   border-collapse:collapse;
		   width:1024px;
		   height:600px;
		   text-align: center;
		  }
	td{border:2px solid gray;}
	#top-title {float: left; padding-left: 100px;}
	#top-b,#top-c {padding-left: 40px;}
	
</style>

</head>
<body>
	<br/>
	<center>
	<table border="1">
		<tr height="150px;">
			<td colspan="2">
				<h1>商务会员管理系统</h1>
				<div id="top-title">
					<a id="top-a">用户名： </a><a>admin</a>
					<a id="top-b">用户类型： </a><a>管理员</a>
					<a id="top-c" href="">退出</a>				
				</div>
			</td>
		</tr>
		<tr>
			<td width="200px;">
				<a id="left-a" href="b" target="dataFarme">查看所有会员</a><br/><br/>
				<a id="left-b" href="b" target="dataFarme">新增会员</a><br/><br/>
				<a id="left-c" href="b" target="dataFarme">修改会员</a><br/><br/>
				<a id="left-d" href="b" target="dataFarme">删除会员</a><br/><br/>
				<a id="left-e" href="a" target="dataFarme">修改密码</a>
			</td>
			<td>
				<iframe name="dataFarme" frameborder="0" width="100%" height="400px" src="index.jsp"></iframe>
			</td>
		</tr>
	</table>
	</center>	
</body>
</html>