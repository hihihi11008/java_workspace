/*�޼���*/
class ReturnType{
	int price; //0

	/*�޼��� �ۼ���*/
	public void setPrice1(){ //void�� ��ȯ���� ����! 
		price = 500;	
	}
	/*��ȯ���� �ش� ��ȯ���� �ڷ����� �״�� �������ָ� �ȴ�*/
	public int getPrice(){
		return price;
	}
	public boolean getBool(){
		return false;
	}
	public String getChar(){
		return "A";
	}
	public double getNum(){
		return 89.756;
	}
	public static void main (String[] args){
		ReturnType rt=new ReturnType();
		System.out.println(rt.getNum());
	}
}

