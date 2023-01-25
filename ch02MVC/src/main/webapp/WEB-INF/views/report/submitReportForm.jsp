<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리포트 등록 폼 </title>
</head>
<body>
<form:form action = "submitReport.do" enctype="mutlipart/form-data" modelAttribute="report">
<ul>
	<li>
		<label for = "subject">제목</label>
		<form:input path="subject"/>
		<form:errors path = "subject"/>
	</li>
	<li>
		<label for = "reportFile">리포트 타입</label>
		<input type = "file" id = "reportFile" name = "reportFile">
	</li>
	<li>
		<form:button>리포트 전송</form:button>
	</li>
</ul>
</form:form>
</body>
</html>