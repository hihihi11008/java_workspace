/*
 * ��Ŭ������ ������ 'ȸ��'�� ǥ���� Ŭ�����̴� 
 * ����) ������ �ۼ��ϱ� ���� ������ Ŭ������ �ƴ϶� ���� ��������� 
 * 			�����͸� ��� ���� ������ ���� ������ Ŭ�����̴� 
 * 
 * ���ø����̼� ����о߿����� �̷��� ������ ��ü�� ������ 
 * Data Transfer Object(�޼����� �Ű������� �����ϱ� ���� ��ü) 
 * Value Object(���� ������� ��ü)
 * 
 * �ַ� �����ͺ��̽� ������ �ϳ��� ���ڵ带 ��� ���� �뵵�� ���� ���ȴ� 
 * */
package day1111.member;

public class BoardMember {
	private int member_id;
	private String m_id;
	private String m_pass;
	private String m_name;
	private String regdate;
	
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
}
