class Shoes{
	String color; //String�� ��ü�̹Ƿ� �����Ϸ��� ���� null
 	int price; //������ �����Ϸ��� ���� �ּ����� ���� ���� 0 ���� �ʱ�ȭ 
	//�Ʒ��� �θ޼���� �Ӽ��� �����ϴ� �Ͱ� 
	//�����ڿ� ���� �ʱ�ȭ�ϴ� �Ϳ� ������ 
	//
	public Shoes(String color, int price){
		this.color=color;
		this.price=price;
	}
	public void setColor(String color){
		this.color=color;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public static void main(String[] args){
		Shoes s = new Shoes();	
		s.setColor("red");
		s.setPrice(20000);

		System.out.println("�Ź��� ������ "+s.color+", ������ "+s.price);
	}
}

�Ʒ��� Ŭ������ ���� �������� �������� �������� ����� �ִ� Ŭ������ �ϼ��Ͻÿ�
�Ʒ��� Ŭ������ ���� �������� ���������� ���� �� �ִ� ��� �� ������ ���Ŀ� ������ ������
 ���������� ���� �� �� �ִ� Ŭ������ �ϼ��Ͻÿ�

class  HighHeel{
   String color="None Color"; 
   public void setColor(String color){
	this.color=color;
   }

	public HighHeel(String color){
		this.color = color;
	}

	public static void main(String[] args){
		HighHeel hHeel= new HighHeel("red");
		hHeel.color="black";
	}
}


