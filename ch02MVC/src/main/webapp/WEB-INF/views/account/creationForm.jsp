<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정생성</title>
</head>
<body>
<!-- method 속성을 명시하지 않으면 기본값이 post -->
<!-- modelAttribute 속성에 request에 저장된 자바빈의 속성명을 지정  -->
<form:form action = "create.do" modelAttribute="command">
	아이디 : <form:input path="id"/> <!-- path :자바빈의 프로퍼티 -->
	<form:errors path ="id"/><br>
	
	이름 : <form:input path="name"/>
	<form:errors path = "name"/><br>
	
	우편번호 : <form:input path="zipcode"/>
	<form:errors path = "zipcode"/><br>
	
	주소1 : <form:input path="address1"/>
	<form:errors path = "address1"/><br>
	
	주소2 : <form:input path="address2"/>
	<form:errors path = "address2"/><br>
	
	<form:button>전송</form:button>
	
</form:form>
</body>
</html>