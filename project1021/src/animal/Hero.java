public class Hero {
	int hp=10;
	boolean fly=false;
	String name="�ް���"; //has a ������, ���� �󵵼��� ������ �׳� �Ϲ��ڷ���ó�� ����
	Bullet bullet; //��ü���̹Ƿ�, has a ���� 

	
	public void setHp(int hp) { //hp ���� �����ϰ� �ʹ� 
		this.hp=hp;
	}
	public void setFly(boolean fly) {//fly ���� �����ϰ� �ʹ�
		this.fly=fly;
	}
	public void setName(String n) {//name ���� �����ϰ� �ʹ�		
		name=n;
	}
	public void fire(Bullet bullet){//bullet �� �ٸ� ����� �����ϰ� �ʹ�
		bullet=bullet;
	}
	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.setHp(500);//call by value
		hero.setFly(true);//call by value
		hero.setName("����");// call by reference ��Ʈ���� ��ü�̹Ƿ� 
		Bullet b = new Bullet();
		hero.fire(b);	//�޼��� ȣ���, �Ѱ����� ���� ���� ��ü ��ü�� �ƴ� �� ��ü�� �ּҰ��̶���Ͽ� 
						//call(ȣ���Ѵ�) by(�� ����) reference(����)
	}	
}
