/*����ο� �Ű����� �����Ͽ� �����غ��� */
class MainArgs{
	public static void main(String[] args){
		//main�� ��ü 
		//���� ����ζ� �Ҹ���. �ٵ� ������ ���� �и� �޼����ӿ��� 
		//�츮�� ȣ���� ���� ���µ� ������ �ȴ� 
		//��) ���� �޼���� java.exe �� ���� ȣ��ȴ� 
		//���� �ڵ峻���� ȣ���ϴ� ����� �ƴ϶� ,�ڹ��� ���� ���Ͽ� ���� ȣ��ȴ�
		//main�� �޼����� , �� �ȿ� ����� ������ �Ű������̴� .
		//�׷��ٸ� java.exe�� ���� main �޼���ȣ��� �Ű������� ȣ�⵵ �Բ� �Ѱܾ��ϴ� ���� ���� 
		//java.exe�� ������ ���̴�.
		System.out.println("����� �Ѱܹ��� �Ű������� �� "+args.length);
		System.out.println("�����"+args[0]);
		System.out.println("�ȳ�");

		//�Ѿ�� �Ű����� ��� ��� 
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
		
	}

}

