/*����Ŀ�� �����Ѵ� */
package music;
import riding.Wing;

//����Ŀ�� ����� ����̽�����, ��Ʈ���̴� 
//���ΰ� ���� �ڷ����̴� 
//���ΰ� ����ȯ�̰��� !!!!.�ڡڡڡڡڡڡ�
public class Speaker extends AudioDevice implements Wing{
					/*����̶�? �θ��� ��� ����� �ڽ��� �����޴� ���� 
						�θ�Ŭ������ �ҿ����� �߻�Ŭ������ ���, �̰� ����̾ƴ϶� �����̴�
						�� �θ��� �߻����� �޼����� �ϼ��� �ڽĿ��� ���ѱ� ���̴�
						���� �ڽ� Ŭ����������, �θ��� �ҿ����� �޼��带 ������ �������ؾ� 
						�� Ŭ������ ������ Ŭ������ �ȴ� 
						�̷� ���� ������ ������ ���������� �Ѵ� 
					*/
	boolean ooper; //�������� 
	String color="red";

	public void sound(){
		
	}/*����� ������ ����*/
	public void setVolume(){ //�극�̽��� �����ϱ⸸ �ص� �����Ǹ� �ϼ��Ѱ���
		System.out.println("������ �����ؿ�");
	}
	public void playMP3(){
		System.out.println("mp3����̿��� ");
	}
	public void fly(){
		System.out.println("�� �� �־ ");
	}
	
}

