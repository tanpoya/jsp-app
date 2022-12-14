<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert처리페이지</title>
</head>
<body>
<%
	//POST 방식의 한글처리 : 이것 안쓰면 한글깨짐!!!
	request.setCharacterEncoding("UTF-8");
	
	try{
		
		// 파라미터 정보 가져오기
		// 전송한 페이지인 insert.jsp의 form태그 안의 input요소들의
		// name 속성명으로 읽어온다!
		// request객체를 사용한다 -> HttpServletRequest 객체로 생성함!
		// request는 "요청"이라는 뜻!
		// 파라미터를 요청한다 -> 파라미터는 전달값을 말함!
		// 가져오는 메서드는? -> getParameter(name속성값)
		// ->>> request.getParameter(name속성값)
		String dname = request.getParameter("dname");
		String actors = request.getParameter("actors");
		String broad = request.getParameter("broad");
		String gubun = request.getParameter("gubun");
		String stime = request.getParameter("stime");
		String total = request.getParameter("total");
		
		// 넘어온값 찍기!
		out.println(
			"<h1>" +
			"♣ dname : " + dname + "<br>" +
			"♣ actors : " + actors + "<br>" +
			"♣ broad : " + broad + "<br>" +
			"♣ gubun : " + gubun + "<br>" +
			"♣ stime : " + stime + "<br>" +
			"♣ total : " + total + "</h1>"
		);
		

	// 1. DB 연결 문자열값 만들기!
	String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	// 형식 -> jdbc:db시스템종류://db아이피/db이름
	// MySQL -> jdbc:mysql://localhost:3306/mydb
	// 참고) 오라클 JDBC 드라이버 로드 문자열
// Oracle -> jdbc:oracle:thin:@localhost:1521:xe
	
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
	String query = "INSERT INTO `drama_info`" +
			"(`dname`, `actors`, `broad`, `gubun`, `stime`, `total`)" +
			"VALUES (?,?,?,?,?,?)";
	// 쿼리문작성시 삽입될 데이터 부분을 물음표(?)로 처리함녀
	// PreparedStatement 객체에서 이부분을 입력하도록 해준다
	
	// 8. DB 종류 클래스 등록하기 -> 해당 연결 드라이브 로딩!
	Class.forName("com.mysql.jdbc.Driver");
	// lib폴더의 jar파일과 연결!
	
	// 9. DB연결하기
	conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
	
	// 10. 성공메시지띄우기
	out.println("DB연결 성공하였습니다!");
	
	// 11. 쿼리문 연결 사용준비하기
	// conn연결된 DB객체
	pstmt = conn.prepareStatement(query);
	// prepareStatement(쿼리문변수)
	// - 쿼리문을 DB에 보낼 상태완료!
	// - 중간에 쿼리문에 넣을 값을 추가할 수 있음!
	
	// 12. 준비된 쿼리에 물음표부분을 처리하는 순서
	// set데이터형(순번, 값변수)
	// 순번은 1부터 시작
	// 데이터형 이름은 대문자로 시작
	// 예) setString(), setInt(), setDouble()...
	pstmt.setString(1, dname);
	pstmt.setString(2, actors);
	pstmt.setString(3, broad);
	pstmt.setString(4, gubun);
	pstmt.setString(5, stime);
	pstmt.setString(6, total);
	// 물음표 순서대로 값을 셋팅해 준다
	
	// 13. 쿼리를 DB에 전송하여 실행후 결과집합(결과셋)을 가져옴!
	pstmt.executeUpdate(); // insert문을 실행
	// executeQuery() 쿼리실행 메서드
	// executeUpdate() 쿼리실행 메서드 -> insert문을 실행함
            
	// 14. 연결해제하기
// 	rs.close(); 필요없음
	pstmt.close();
	conn.close();
	
	// 15. 입력성공시 메시지 띄우기
	// JS alert창 띄우고 확인시 list페이지 돌아가기
	out.println(
			"<script>" +
			"alert('저장성공');" +
			"location.href='../list.jsp'" +
			"</script>" 
	);
	
	// -> 입력성공후 한글이 물음표(?)로 입력된 경우 원인은?
			// DB 살펴보면 utf8-general-ci 형식으로 잘 만들어져있음
			// 원인은 MySQL 환경설정파일에 있다
			// XAMPP 패널에 config버튼 클릭시 my.ini파일에서 "utf" 검색
			// 결과: utf8mb4 가 설정되어있음 이것을 모두 utf8로 변경
			
			// default-character-set=utf8
			// cahracter-set-server=utf8
			// collation-server=utf8_general_ci
			
			// 변경후 반드시 MySQL 서버를 내렸다 올려야 my.ini를 다시 읽는다
			
			// 실제 my.ini 위치는
			// 설치드라이브:\xampp\mysql\bin\my.ini
		
	       
		
	} ////////// try //////////
	catch(Exception e){
		// DB연결 실패시 여기로 들어옴!
 		out.println("에러메시지:");
 		out.println(e.toString());
 		// toString() 문자데이터로 변환하는 메서드
	} ///////// catch //////////







%>

</body>
</html>