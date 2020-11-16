/*산 1개를 담게될 클래스 정의 */
package day1116.pubapi;

public class Mountain {
	/*멤버변수로 오픈 데이터 포털의 산정보에 있는 모든 데이터를 다 넣기는 무리라 원하는걸 넣겠움 
	 * 은닉화!!! (getter/setter)
	 * */
	private int mntnid;//산의 고유 코드 
	private String mntnnm; // 산이름을 담게될 변수 
	private String mntninfopoflc; //산정보 소재지 (소재지)
	private int mntninfohght;//산높이
	
	public int getMntnid() {
		return mntnid;
	}
	public void setMntnid(int mntnid) {
		this.mntnid = mntnid;
	}
	public String getMntnnm() {
		return mntnnm;
	}
	public void setMntnnm(String mntnnm) {
		this.mntnnm = mntnnm;
	}
	public String getMntninfopoflc() {
		return mntninfopoflc;
	}
	public void setMntninfopoflc(String mntninfopoflc) {
		this.mntninfopoflc = mntninfopoflc;
	}
	public int getMntninfohght() {
		return mntninfohght;
	}
	public void setMntninfohght(int mntninfohght) {
		this.mntninfohght = mntninfohght;
	}
	
	
}
