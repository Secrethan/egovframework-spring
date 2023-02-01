<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script type = "text/javascript" src = "${pageContext.request.contextPath}/js/member.js"></script>
<!-- MyPage 메뉴 시작 -->
<div class = "side-bar">
	<ul>
		<li>
			<c:if test="${empty member.photo_name}">
				<img src = "${pageContext.request.contextPath}/image/face.png" width="200" height="200" class = "my-photo">
			</c:if>
			
			<c:if test="${!empty member.photo_name}">
				<img src = "${pageContext.request.contextPath}/member/photoView.do" width="200" height="200" class = "my-photo">
			</c:if>		
		</li>
		<li>
			<div class = "align-center">
				<input type = "button" value = "수정" id = "photo_btn">
			</div>
			<div id = "photo_choice" style = "display:none;">
				<input type = "file" id = "upload" accept = "image/gif,image/png,image/jpeg">
				<input type = "button" value ="전송" id = "photo_submit">
				<input type = "button" value ="취소" id = "photo_reset">
			</div>
		</li>
		<li>
			<input type = "button" class = "menu-btn" value = "비밀번호 변경" onclick = "location.href='changePassword.do'">
		</li>
		<li>
			<input type = "button" class = "menu-btn" value = "회원 탈퇴" onclick = "location.href='delete.do'">
		</li>
	</ul>
</div>
<!-- MyPage 메뉴	끝 -->
