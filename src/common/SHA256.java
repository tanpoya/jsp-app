package common;

import java.security.MessageDigest;


//�ؽ���ȣ : �ֱٿ��� ��κ� SHA256�� ����Ѵ�.
//�ؽ��� ��ȣȭ�� �����ʴ´�.
//��ȣȭ�� ��ȣȭ�� �Ǵ� ����� base64

//�ؽ��� �ؽ��� ���Ͽ� ����
//�ؽ��� �������̶� ���� ���� ���� �� �ִ� (�浹)
//�ո� �� �ִ�


public class SHA256 {
	
	// �ұ�ġ��(��Ʈ���) - ���� ��ȣȭ�� Ư�����ڸ� ���
	// ���� �Ұ����ϰ� ����� ���� �ؽþ�ȣȭ�� �߰� ���
	// ���� ���ȼ��� ����!!!
	private final static String salt = "mysalt";// �������β� ��Ʈ��!!!
	// ���ǻ���: ��Ʈ ���ڿ��� �ѱ۰� ���� 2byte ���ڸ� ����ϰ� �Ǹ�
	// �������� ���ڼ��� ���ݾ� �ٸ� �� �ֱ⶧���� �� ��Ʈ���ڰ� �ٸ���
	// �����Ǿ ����� �����ϰԵȴ�!
	// ������ �Ǵ� ���� ������ �����ؼ� �̰��� �޶����� ���� ��� ����ڵ���
	// �ٸ� �������� ������ ������� ���� �α����� �ȵǴ� ���°� �߻��� �� �ִ�!
	// ���� ��Ʈ ���ڿ��� �� �������� ������!
	
	public String encSha256(String pwd) { // pwd : �Ϲݹ��� ��й�ȣ�� �޴´�!

		// �������
		String result = "";

		byte[] bytePlain = pwd.getBytes(); // ���� ���ڵ��� ����Ʈ ������ �ɰ���.

//		for (byte b : bytePlain) {
//			System.out.println(b);
//		}

		byte[] bytesalt = salt.getBytes();

//		for (byte b : bytesalt) {
//
//			System.out.println(b);
//		}


		byte[] bytePlainAndSalt = new byte[bytePlain.length + bytesalt.length];

		for (int i = 0; i < bytePlainAndSalt.length; i++) { // ��й�ȣ�� ��Ʈ �ֱ�

			if(i < bytePlain.length) { // ����Ʈ �÷��� ���̸�ŭ ä���ְ�

				bytePlainAndSalt[i] = bytePlain[i];

			} else { // �÷��� ���̸� �����ϸ� �� �ڿ� ��Ʈ�� ä���ִ´�.

				// i - bytePlain.length�� ������� i�� 6�̸� 6-6�� �Ǿ 0��° �迭 ������ ��ȯ�Ѵ�.
				bytePlainAndSalt[i] = bytesalt[i - bytePlain.length];

			}

		}


		System.arraycopy(bytePlain, 0, bytePlainAndSalt, 0, bytePlain.length);
		// �Ű����� ; ù��° �����迭, �ι�° �����迭 ������ġ, 
		// ����° �����迭, �׹�° �����迭 ������ġ, �ټ���° ��������

		System.arraycopy(bytesalt, 0, bytePlainAndSalt, bytePlain.length, bytesalt.length);


//		for (byte b : bytePlainAndSalt) {
//
//			System.out.print(b + " ");
//
//		}

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256��ȣȭ ��ü ����
			md.update(bytePlainAndSalt); // md ��ü �ȿ� ����

			byte[] bytedata = md.digest(); // md ��ü���� ������ �޾ƿ���

			// StringBuffer ����ȭ ����� �־ ���� ��ü�� �������� ���Ѵ�. �Ӱ豸��
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < bytedata.length; i++) {
				sb.append(Integer.toHexString((bytedata[i] & 0xFF) + 256).substring(1));
			}

//			System.out.println(sb.toString());

			result = sb.toString();


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ��ȣȭ�� ��� ���ڰ� ����!
		return result;

	} ///// method ///
} //// class /////