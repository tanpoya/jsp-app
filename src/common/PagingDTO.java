package common;

// ����¡ �Ӽ�(����) ĸ��ȭ Ŭ����
// DTO - Data Transfer Object �� ���Ӹ���
// ������ ĸ��ȭ�� ����,���Ͱ� �ִ� Ŭ������ �θ��¸���!
public class PagingDTO {
	// ***** ����¡ ���� ******
	// 1.���� ���ڵ��ȣ : LIMIT�� ���۰�
	private int startNum;
	// 2.�������� ���ڵ尳�� : LIMIT�� ����
	final private int onePageCnt = 10;
	// 3.��ü ���ڵ��
	private int totalCnt;
	// 4.����Ʈ �׷�� : ��ü���� �� �������簳��
	private int listGroup;
	// 5.���� ���ڵ�� : ����Ʈ �׷쿡�� ���� ���ڵ��
	private int etcRecord;
	// 6.�Ķ���� ����ȯ ����(���� ��������ȣ)
	private int pageSeq; // �⺻�� 1(�Ķ���Ͱ� ������ 1��!)
	// 7.�Ѱ�� üũ: �������� �ְ� ���� ���� 1�����̳�
	private int limit;
	// 8.����¡ ��������
	final private int oneBlockCnt = 10;
	// 9.����¡ �׷�� : ����Ʈ�׷�� �� ����¡ ��������
	private int blockGroup;
	// 10.���� ����¡�� : ����Ʈ�׷�� % ����¡ ��������
	private int etcBlock;

	// ���Ϳ� ���� ���� /////////////////
	// 1.���� ���ڵ��ȣ : LIMIT�� ���۰�
	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	// 2.�������� ���ڵ尳�� : LIMIT�� ����
	// -> final �̹Ƿ� ���Ͱ� ����!
	public int getOnePageCnt() {
		return onePageCnt;
	}

	// 3.��ü ���ڵ��
	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	// 4.����Ʈ �׷�� : ��ü���� �� �������簳��
	public int getListGroup() {
		return listGroup;
	}

	public void setListGroup(int listGroup) {
		this.listGroup = listGroup;
	}

	// 5.���� ���ڵ�� : ����Ʈ �׷쿡�� ���� ���ڵ��
	public int getEtcRecord() {
		return etcRecord;
	}

	public void setEtcRecord(int etcRecord) {
		this.etcRecord = etcRecord;
	}

	// 6.�Ķ���� ����ȯ ����(���� ��������ȣ)
	public int getPageSeq() {
		return pageSeq;
	}

	public void setPageSeq(int pageSeq) {
		this.pageSeq = pageSeq;
	}

	// 7.�Ѱ�� üũ: �������� �ְ� ���� ���� 1�����̳�
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	// 8.����¡ ��������
	public int getOneBlockCnt() {
		return oneBlockCnt;
	}

	// 9.����¡ �׷�� : (����Ʈ�׷��+�������ڵ��) �� ����¡ ��������
	public int getBlockGroup() {
		return blockGroup;
	}

	public void setBlockGroup(int blockGroup) {
		this.blockGroup = blockGroup;
	}

	// 10.���� ����¡�� : (����Ʈ�׷��+�������ڵ��) % ����¡ ��������
	public int getEtcBlock() {
		return etcBlock;
	}

	public void setEtcBlock(int etcBlock) {
		this.etcBlock = etcBlock;
	}

}