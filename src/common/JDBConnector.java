package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DB���� ��ü import�ϱ�

public class JDBConnector {
	// 1. ���ᰴü ����
	public Connection conn;	
	// 2. ������ ���尴ü
	public PreparedStatement pstmt;	
	// 3. ������� ��ü
	public ResultSet rs;
	
	// ������ �޼���
	public JDBConnector() {
		try {
			System.out.println("���� ó���ڹپ�!");
			// 1. DB ���� ���ڿ��� �����!
			String DB_URL = "jdbc:mysql://localhost:3306/mydb";
			// 2. DB ���̵���� : root�� ���۾��� �⺻������
			String DB_USER = "root";
			// 3. DB ��й�ȣ : root�� ���ʿ� ��й�ȣ�� ����
			String DB_PWD = "";
			
			// 8. DB ���� Ŭ���� ����ϱ� -> �ش� ���� ����̺� �ε�!
			Class.forName("com.mysql.jdbc.Driver");
			
			// 9. DB�����ϱ�
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			
			// 10. �����޽�������
			System.out.println("DB���� �����Ͽ����ϴ�!");
		} /////// try ////////////////
		catch (Exception e) {
			e.printStackTrace();
		} //// catch ////////
	} ////// ������ �޼��� /////
	
	// ���� ���� �޼��� ///////
	public void close() {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} /// try ///
		catch (Exception e) {
			e.printStackTrace();
		} /// catch ///
	} /////// close �޼��� ///////////
	
	
	
} //////// Ŭ���� /////////