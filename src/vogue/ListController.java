package vogue;

import common.JDBConnector;
import common.Paging;
import common.PagingDTO;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;

/////////////////////////////////////
// MVC �𵨿��� ��Ʈ�ѷ� ������ �ϴ� Ŭ����//
/////////////////////////////////////

// ����: DB���� �۾� �� ����Ͻ����� ����,�����
// ��(Model) : DB�۾�, ����Ͻ� ���� ���
// ��(View) : ȭ�鿡 ������ �����ϴ� ���
// ��Ʈ�ѷ�(Controller) : ���� ������� �並 �����ϴ� ���

public class ListController {

	// DB���� Ŭ���� ����
	JDBConnector jdbc = new JDBConnector();

	// ����¡ Ŭ���� ���� : ������ ����¡ ��� ���̺���� ������!
	Paging pg = new Paging("member");

	// ����¡ DTO Ŭ���� ����
	PagingDTO pgdto = new PagingDTO();
	
	// ������ �޼���� ���� ������ �� �����Ƿ�
	// ������ �޼��带 �����Ͽ� ����Ʈ ������� ����Ʈ �������� �����Ѵ�!
	
	///////////////////////////////////
	// ����Ʈ �並 �����Ͽ� �����ϴ� �޼��� ///
	///////////////////////////////////
	// pgNum�� ����Ʈ ���������� ������ �Ķ���Ͱ��� ������ �ش�!
	// �˻��� ���� �Ķ���� pmCol, pmKey �� ������ �ش�!
	public String setList(String pgNum, String pmCol, String pmKey) {
		// pgNum - ��������ȣ / pmCol - �˻��׸� / pmKey - �˻���

		// �Ķ���� ���ް� Ȯ��!
		System.out.println("��������ȣ:"+pgNum
				+"\n�˻��׸�:"+pmCol+"\n�˻���:"+pmKey);
		
		// DB���ڵ�������
		String result = "";

		try {

			// 1. �������ۼ� �Ҵ�
			String query = 
					"SELECT * FROM `member` "+
					"ORDER BY `name` ASC LIMIT  ?,?";
			
			// 1.5. ���� �˻�� ������ ���� ����!
			if(pmKey!=null) {
				query = "SELECT * FROM `member` "
						+ "WHERE `"+pmCol+"` "
						+ "LIKE \"%"+pmKey+"%\" "
						+ "ORDER BY `name` ASC LIMIT  ?,?";
				System.out.println("���� �Ƴ�!");
			}

			// 2. ������ ���� ����غ��ϱ�
			jdbc.pstmt = jdbc.conn.prepareStatement(query);

			/**************************************** 
				[ ����¡ ����ó���� ��������ȣ�� ���۹�ȣ �����ϱ� ]
			 *****************************************/
			// 3.startNum�� �����ϴ� ���̹Ƿ� setStartNum()���� ������!
			// DB�������� limit ���۹�ȣ��!
			pgdto.setStartNum(pg.changeStartNum(pgNum));

			// 4.pageSeq ���� �ʱ� ���� �ʼ�!(�Ķ���Ͱ����� ����!)
			// �� �������� ���۹�ȣ�� �����ش�!
			pgdto.setPageSeq(Integer.parseInt(pgNum));

			/****************************************
					5. ����¡ ���� ó���ϱ�
			 *****************************************/
			// LIMIT ������ ���۹�ȣ����
			jdbc.pstmt.setInt(1, pgdto.getStartNum());
			// LIMIT ������ ��������
			jdbc.pstmt.setInt(2, pgdto.getOnePageCnt());

			// 6. ������ DB�� �����Ͽ� ������ �������(�����)�� ������!
			// ResultSet��ü�� DB���� ��������� �����ϴ� ��ü��!
			jdbc.rs = jdbc.pstmt.executeQuery();
			// executeQuery() �������� �޼���

			// 7. ����� ��������� ���ڵ� �� ��ŭ ���鼭 �ڵ常���!
			// �����ִ� �����? while(����){���๮}
			// ���ڵ� ���� üũ �޼����? next()
			// rs�� ResultSet ��ü��!!!
			// rs.next() -> ù���� ���������� ������ true / ������ false!
			// ù��° ������ �׻� �÷����� ù��° �����̴�!
			// ���� ���������� �ִٴ� ���� ��� ���ڵ尡 �ִٴ� ��!!!

			// [ �Ϸù�ȣ�� ���� ]
			// �������� ���� �����Ϸù�ȣ ���ϱ�
			int listNum = 1;
			if (pgdto.getPageSeq() != 1){
				listNum = 
						(pgdto.getPageSeq() - 1) * pgdto.getOnePageCnt() + 1;
				// (���� ��������ȣ - 1) * ���������簳�� + 1
			} ////// if ////////

			// ���� ��� :
			// (2-1) * 3 + 1 = 4
			// (3-1) * 3 + 1 = 7
			// (4-1) * 3 + 1 = 10

			/// ����¿� ���ڵ尡 �ִ� ���� ��� ��ȸ��!
			// rs.getString(�÷���)
			// -> �������� ��� getString(), �������� getInt()
			// -> �÷����� DB ���̺� ������ ������ �÷����̴�!
			while (jdbc.rs.next()) {
				// += ���Կ����ڷ� �������� ��� ����!
				result += "<tr>" + "   <td>" + listNum + "</td>" +
						// "   <td>"+rs.getInt("idx")+"</td>"+
						// �Ϸù�ȣ�� DB�� idx �⺻Ű�� ���� �ʰ�
						// �ݺ��Ǵ� ���� ������ ���� ����Ѵ�!
						"   <td><a href='modify.jsp?idx=" + 
						jdbc.rs.getInt("idx") + "&pgnum=" + 
						pgdto.getPageSeq() + "'>" +
						// ��ȸ���� �������� modify.jsp�� ����
						// ?idx=����Ű�� : Get������� ������!
						// pgnum=������������ȣ : �߰�����!
						// ������� : ���̵�,�̸�,����,�̸���1,�̸���2,����
						jdbc.rs.getString("mid") + "</a></td>" + "   <td>" + 
						jdbc.rs.getString("name") + "</td>" + "   <td>" + 
						jdbc.rs.getString("gen") + "</td>" + "   <td>" + 
						jdbc.rs.getString("email1") + "@" + 
						jdbc.rs.getString("email2") + "</td>" + "   <td>" + 
						jdbc.rs.getString("auth") + "</td>" + "</tr>";
				// �Ϸù�ȣ����
				listNum++;

			} //////////// while //////////////

			// ���ȭ����� 	
			//    out.println(result);

			// 16. ���������ϱ�
			jdbc.close();

		} //// try /////
		catch (Exception e) {
			e.printStackTrace();
		} ///// catch //////
		
		// ��� ����
		return result;
		
	} ////////////// setList �޼��� //////
	
	//////////////////////////////////////////
	// ����¡ �ڵ� ���� �޼��带 �߰��� �ִ� �޼��� ///
	/////////////////////////////////////////
	public String setPaging() {
		// ����¡ Ŭ������ ����¡ �ڵ� ���� �޼��带 ȣ��
		// �� ������� �����Ѵ�!
		return pg.makePaging();
	} //////// setPaging �޼��� /////////////
	
	
	
	
	

} //////// Ŭ���� //////////////////