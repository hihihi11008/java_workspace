class Doll{
	static String name="��ī��";
	int price;
	
	public void walk(){
		
	}
	/*
	�����ڰ� �������� ������ sun���� ������ 
	�����Ϸ��� ���� ���� �⺻���� �ּ����� ������ ���� �����ڸ� �����Ѵ� 
	����Ʈ ������ 
	public Doll(){
		//������ ���� . �ּ����� �������ϹǷ� (�������ȳ��� )
	}
	*/

	//�����ڰ� �����ڸ� �����ϸ�, �� �̻� �����Ϸ��� ���� ������ ���Ǵ� ���� 
	//���� �����ڰ� ������ �����ڸ� �����Ѵ� 
	//public Doll(){
	//	System.out.println("���� ������ ������");
	//}
	public static void main(String[] args){
		Doll d=new Doll();//defalut ������ �޼��� ȣ���� ���� 
		d.name="����";
		System.out.println(d.name);
	}	
}
