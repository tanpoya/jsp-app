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
	// [ �񵿱� ��� �׽�Ʈ ó�������� ] //
	// -> ������Ͻ� ȭ�鿡 ����ִ� ���� ���ϵǹǷ�
	// ó�������������� html������ ��� �����ش�
	

	//POST ����� �ѱ�ó�� : �̰� �Ⱦ��� �ѱ۱���!!!
	request.setCharacterEncoding("UTF-8");

	// POST ������� �Ѿ�� �� �ޱ�
	String name = request.getParameter("name");

	// �Ѿ�°� ȭ�����
	// out.print("������:" + name);
	
	// ������� ȭ�鿡 ����Ѵ�
	// �Ѿ�°��� ��Ȯ�� ���ϱ� ���� equals() ���)
	if(name.equals("�����")){
		out.print("�����");
	} else if(name.equals("������")){
		out.print("������");
	} else {
		out.print("?");
	}
	
%>
</body>
</html>