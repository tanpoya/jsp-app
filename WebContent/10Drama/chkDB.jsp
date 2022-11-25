<%@page import="java.sql.DriverManager" %>
	<%@page import="java.sql.ResultSet" %>
		<%@page import="java.sql.PreparedStatement" %>
			<%@page import="java.sql.Connection" %>
				<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="UTF-8">
						<title>DB 연결 체크하기</title>
					</head>
					
					<body>
						<% try{ // DB와 연결하려면 해당 DB의 jar파일이 DB폴더의 // lib 폴더안에 위치해 있어야한다 // MySQL 설치폴더 // C:\Program
							Files\Apache Software Foundation\Tomcat 9.0\lib // mysql-connector.jar 파일 확인 // 1. DB 연결
							문자열값 만들기 String DB_URL="jdbc:mysql://localhost:3306/mydb" ; // 형식 ->
							jdbc:db시스템종류://db아이피/db이름
							// MySQL -> jdbc:mysql://localhost:3306/mydb

							// 2. DB 아이디계정 : root는 슈퍼어드민 기본계정임
							String DB_USER = "root";

							// 3. DB 비밀번호 : root는 최초에 비밀번호가 없음
							String DB_PWD = "";

							// 4. 연결객체 선언
							Connection conn = null;

							// 5. 쿼리문 저장객체
							PreparedStatement pstmt = null;

							// 6. 결과저장 객체
							ResultSet rs = null;

							// 7. 쿼리문작성 할당
							String query = "SELECT * FROM `drama_info` DRDER BY `idx` DESC";

							// 8. DB 종류 클래스 등록하기 -> 해당 연결 드라이브 로딩
							Class.forName("com.mysql.jdbc.Driver");

							// 9. DB연결하기
							conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

							// 10. 성공메시지띄우기
							out.println("DB연결 성공하였습니다");

							// 11. 쿼리문 연결 사용준비하기
							// conn 연결된 DB객체
							pstmt = conn.prepareStatement(query);
							// prepareStatement(쿼리문변수)
							// - 쿼리문을 DB에 보낼 상태완료
							// - 중간에 쿼리문에 넣을 값을 추가할 수 있음

							// 12. 쿼리를 DB에 전송하여 실행후 결과집합(결과셋)을 가져옴
							// ResultSet객체는 DB에서 쿼리결과를 저장하는 객체임
							rs = pstmt.executeQuery();
							// executeQuery() 쿼리실행 메서드

							// 13. 저장된 결과집합의 레코드 수 만큼 돌면서 코드만들기
							// 돌아주는 제어문은? while(조건){실행문}
							// 레코드 유무 체크 메서드는? next()
							// rs는 ResultSet 객체임!
							// rs.next() -> 첫라인 다음라인이 있으면 true / 없으면 false
							// 첫번째 라인은 항상 컬럼명이 첫번째 라인이다
							// 따라서 다음라인이 있다는 것은 결과 레코드가 있다는

							// 레코드 결과값 저장변수
							String result = "";

							// 결과셋에 레코드가 있는 동안 계속 순회함
							while(rs.next()){
							result +=

							} ////// while ///////////


							//11. 연결해제하기
							rs.close();
							pstmt.close();
							conn.close();

							} /// try ///
							catch(Exception e) {
							// DB연결 실패시 여기로 들어옴
							out.println("에러메시지:");
							out.println(e.toString());

							}


							%>
					</body>

					</html>