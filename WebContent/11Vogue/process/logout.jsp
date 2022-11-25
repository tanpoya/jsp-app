<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.JDBConnector" %>
<%@ page import="common.SHA256" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그아웃 처리 페이지</title>
</head>
<body>
<%
	// 세션을 유효하지 않게 하라 (유효하지 않다 -> invalidate)
	session.invalidate();
	out.print("<script>" +
	"alert('로그아웃 되었습니다');" + 
	"location.replace('../index.jsp');" +
	"</script>");

%>

</body>
</html>