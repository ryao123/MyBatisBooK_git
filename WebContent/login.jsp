<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<style type="text/css">
	
</style>

    <link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container" align="center" >
	
	
	
        <h2 class="text-center vitar">登录图书管理页面</h2><br/>
        
        <form method="post" class="form-inline" role="form" action="Login"  >
        	<table >
        		<tr>
        			<td>用户名:</td>
        			<td> <input name="name"   type="text"   ></td>
        		</tr>
        		<tr>
        			<td>密码:</td>
        			<td> <input name="password"  type="password"></td>
        		</tr>
        		<tr>
        			<td  colspan="2" class="text-center" > 
        			<input value="登录"    type="submit"  class="form-control btn-primary ">
        			</td>
        		</tr>
        	</table>
        </form>
        <br/>
        <div class="font" style="color: red" > 用户名或密码错误</div>
        
	</div>
</body>
</html>