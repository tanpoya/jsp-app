<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// ### 로그아웃 처리 페이지 ###
	// 세션을 유효하지 않게 하라 (유효하지 않다 -> invalidate)
	try {
		session.invalidate();
		out.print("ok");		
	} //// try /////
	catch(Exception e){
		out.print("로그아웃에 문제가 생겼습니다"+e.toString());
	} /////// catch ////////

%>
