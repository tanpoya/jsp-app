<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�񵿱� ��� �׽�Ʈ ó��������</title>
</head>
<body>
<%
	//POST ����� �ѱ�ó�� : �̰� �Ⱦ��� �ѱ۱���!!!
	request.setCharacterEncoding("UTF-8");

	// POST ������� �Ѿ�� �� �ޱ�
	String name = request.getParameter("name");

	// �Ѿ�°� ȭ�����
	out.print("������:" + name);
	
%>
</body>
</html>