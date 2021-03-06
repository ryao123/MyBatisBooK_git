<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改图书信息页面</title>
 <link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/wangEditor.min.js"></script>
</head>
<body>
	<div class="container" align="center" >
        <h2 class="text-center vitar">修改图书信息页面</h2><br/>
        
       	<c:forEach items="${bid}" var="bid">	
        <form method="post" class="form-inline" role="form" action="Update"  >
        	<table >
        		<tr>
        			<td><input type="hidden" value="${bid.id}"  name="id"/></td>
        		</tr>
        		<tr>
        			<td>书名:</td>
        			<td><input type="text"  name="name" value="${bid.name }"></td>
        		</tr>
        		<tr>
        			<td>作者:</td>
        			<td> <input type="text"  name="author" value="${bid.author }"></td>
        		</tr>
        		<tr>
        			<td>出版社:</td>
        			<td><input type="text" name="publish" value="${bid.publish }"></td>
        		</tr>
        		<tr>
        			<td>出版日期:</td>
        			<td >
        			
        		 <fmt:formatDate  value="${bid.publishdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
        			</td>
        		</tr>
        		<tr>
        			<td>页数:</td>
        			<td> <input type="text"  name="page" value="${bid.page }"></td>
        		</tr>
        		<tr>
        			<td>价格:</td>
        			<td> <input type="text"  name="price" value="${bid.price }"></td>
        		</tr>
        		<tr>
        			<td>摘要内容:</td>
        			<td>
						  <textarea rows="5" cols="20" name="content" id="text1"></textarea>
				    		<div id="editor"><p>${bid.content}</p></div>
					</td>
        			
        		</tr>
        		<tr>
        			<td><a href="Index">返回图书信息页面</a></td>
        			<td class="text-center" > 
        			<input value="修改"    type="submit"  class="form-control btn-primary ">
        			</td>
        		</tr>
        	</table>
           	
        </form>
        
        </c:forEach>
        
         <script type="text/javascript">
		var U = window.wangEditor;
		// 通过构造函数的形式创建要操作的对象
		var editor = new U("#editor");
		var $text = $("#text1");// ${"text1"}
		$text.css("display", "none");
		editor.customConfig.onchange = function(html) {
			// 监控变化，同步更新到 textarea
			$text.val(html)
		}
		// 调用create()方法创建出富文本框编辑器
		editor.create();
	</script>
	</div>
</body>
</html>