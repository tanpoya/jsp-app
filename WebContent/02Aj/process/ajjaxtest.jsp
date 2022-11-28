<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비동기 통신 테스트 처리페이지</title>
</head>
<body>
<%
	// [ 비동기 통신 테스트 처리페이지 ] //
	// -> 결과리턴시 화면에 찍어주는 값이 리턴되므로
	// 처리페이지에서는 html형식을 모두 지워준다
	

	//POST 방식의 한글처리 : 이것 안쓰면 한글깨짐!!!
	request.setCharacterEncoding("UTF-8");

	// POST 방식으로 넘어온 값 받기
	String name = request.getParameter("name");

	// 넘어온값 화면출력
	// out.print("받은값:" + name);
	
	// 결과값을 화면에 출력한다
	// 넘어온값만 정확히 비교하기 위해 equals() 사용)
	if(name.equals("고양이")){
		out.print("고양이");
	} else if(name.equals("강아지")){
		out.print("강아지");
	} else {
		out.print("?");
	}
	
%>
</body>
</html>