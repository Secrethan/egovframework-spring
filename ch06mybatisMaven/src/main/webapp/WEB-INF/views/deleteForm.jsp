<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> 
<title>글 삭제</title>
</head>
<body>
<div class = "page-main">
	<h2>글 삭제 </h2>
	<form:form action = "delete.do" modelAttribute="boardVO">
		<form:hidden path="num"/>
		<ul>
			<li>
				<label for = "passswd">비밀번호</label>
				<form:password path="passwd"/>
				<form:errors path = "passwd" cssClass = "error-color"/>
			</li>
		</ul>
		<div class = "align-center">
			<form:button>삭제</form:button>
			<input type ="button" value ="목록" onclick = "location.href='list.do'">
			
		</div>
	</form:form>
</div>
</body>
</html>