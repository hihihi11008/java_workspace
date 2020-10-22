아래의 클래스를 은닉화 하세요.
package bank;
class  Company{
	int  memberCount;
	String location;
	
	public void setMemberCount(int memberCount){
		this.memberCount=memberCount;
	}
	public void getMemberCount(int memberCount){
		return memberCount;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public void getLocation(String lcation){
		return location;
	}
}
