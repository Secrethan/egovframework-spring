<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
<a href = "${pageContext.request.contextPath}/hello.do">HelloController</a> <br>
<a href = "${pageContext.request.contextPath}/search/internal.do?query=seoul">searchController - internal.do</a> <br>
<a href = "${pageContext.request.contextPath}/search/external.do?query=busan&p=20">searchController - external.do</a><br>
<a href = "${pageContext.request.contextPath}/article/newArticle.do">NewArticleController</a><br>
<a href = "${pageContext.request.contextPath}/cookie/make.do">CookieController - make.do</a><br>
<a href = "${pageContext.request.contextPath}/cookie/view.do">CookieController - view.do</a><br>
<a href = "${pageContext.request.contextPath}/search/main.do">GameSearchController - main.do</a><br>
<a href = "${pageContext.request.contextPath}/account/create.do">CreateAccountController</a><br>
<a href = "${pageContext.request.contextPath}/login/login.do">LoginController</a><br>
<a href = "${pageContext.request.contextPath}/report/submitReport.do">SubmitReportController</a><br>
<a href = "${pageContext.request.contextPath}/member/write.do">MemberWriteConntroller</a><br>

  
</body>
</html>