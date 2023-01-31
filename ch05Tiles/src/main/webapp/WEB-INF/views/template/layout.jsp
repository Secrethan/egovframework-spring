<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name = "title"/></title>
</head>
<body>
<table style = "width:900px;">
	<tr>
		<td colspan = "2">
			<tiles:insertAttribute name = "header"/>
		</td>
	</tr>
	
	<tr height = "500">
		<td colspan = "2" width = "15%" valign="top">
			<tiles:insertAttribute name = "menu"/>
		</td>
		<td colspan = "2" width = "85%" align = "center">
			<tiles:insertAttribute name = "body"/>
		</td>
	</tr>

	<tr>
		<td colspan = "2">
			<tiles:insertAttribute name = "footer"/>
		</td>
	</tr>	
	
</table>
</body>
</html>