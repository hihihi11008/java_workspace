package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import common.image.ImageUtil;




//��ǻ� ��� ~������ �׷���ó���� �г��� ����ϰ� ��! 
public class GamePanel extends JPanel {
	Thread loopThread;//���ӷ����� ���ѷ����� ������ ������! 
	public static final int WIDTH=1200;
	public static final int HEIGHT=700;
	
	Hero hero;
	//Bullet bullet;
	//�ټ��� �Ѿ��� ��� ���� �÷��� �����ӿ� �� List�� �̿��غ��� 
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Block> blockList = new ArrayList<Block>();
	GameBg[] gameBg=new GameBg[2];
	ArrayList<HP> hpList = new ArrayList<HP>();
	
	boolean flag = false; //���ʿ��� ������ �����־�� �ϹǷ� ... 
	boolean over = false; //game over �޽��� ����� ���� 
	int score=0; //���� 
	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		createBg();
		createHero();//�������
		createEnemy();
		createBlock();
		createHP();
		
		loopThread = new Thread() {
			public void run() {
				while (true) {
					if(flag)gameLoop();
					try {
						Thread.sleep(10);// 10/1000��
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		loopThread.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2=(Graphics2D)g; //2D�� �� ������ �׷��Ƚ� ��ü�� ����ȯ ! 
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);//�г��� ũ�⸸ŭ �簢���� ä������ (ȭ���� ������ �۴� ȿ��)
		
		render(g2);
	}

	//�÷����� ���ӵ� ��� : Toolkit
	// Ŭ�����н� :url 
	public void createHero() {
		Image img=ImageUtil.getIcon(this.getClass(), "res/game/plane.png", 100, 65).getImage();
		hero = new Hero(this, img , 200, 200, 100, 65, 0, 0);
	}

	//����������κ��� � ����Ű�� ���ȴ����� ���޹���!! 
	public void movekey(int key) {
		switch(key) {
			case KeyEvent.VK_LEFT:hero.velX=-5;break;
			case KeyEvent.VK_RIGHT:hero.velX=5;break;
			case KeyEvent.VK_UP:hero.velY=-5;break;
			case KeyEvent.VK_DOWN:hero.velY=5;break;
			case KeyEvent.VK_SPACE:fire();break;
		}
	}
	public void stopkey(int key) {
		switch(key) {
			case KeyEvent.VK_LEFT:hero.velX=0;break;
			case KeyEvent.VK_RIGHT:hero.velX=0;break;
			case KeyEvent.VK_UP:hero.velY=0;break;
			case KeyEvent.VK_DOWN:hero.velY=0;break;
		}
	}

	public void fire() {
		Image img = ImageUtil.getIcon(this.getClass(), "res/game/ball.png", 20, 20).getImage(); 
		Bullet bullet=new Bullet(this,img, hero.x+hero.width, hero.y+(hero.height/2), 20, 20, 10, 10);
		bulletList.add(bullet);//������ �Ѿ��� bulletList�� ��ƺ���
	}
	
	//����̹��� ���� 
	public void createBg() {
		Image img = ImageUtil.getIcon(this.getClass(), "res/game/bg.jpg", WIDTH, HEIGHT).getImage(); 
		//������ �̹����� ��水ü 2���� �������� 
		gameBg[0]=new GameBg(img, 0, 0, WIDTH, HEIGHT, -1, 0);
		gameBg[1]=new GameBg(img, WIDTH, 0, WIDTH, HEIGHT, -1, 0);
	}
	
	//���� ���� 
	public void createEnemy() {
		String [] path= {"e1.png","e2.png","e3.png","e4.png","e5.png"};
		
		for (int i = 0; i < 15; i++) {
			double r = Math.random();
			int n =(int)(r*path.length);
			//System.out.println(n);
			Image img = ImageUtil.getIcon(this.getClass(), "res/game/"+path[n], 80, 60).getImage(); 			
			Enemy enemy = new Enemy(img, WIDTH-100, 50+(80*i), 80, 60, -2, 0);
			enemyList.add(enemy); // ������Ͽ� �߰� 
		}
	}
	
	//��� ���� 
	public void createBlock() {
		
		for(int i=0;i<20;i++) {
			Image img=ImageUtil.getIcon(this.getClass(), "res/game/block.png", 40, 40).getImage();
			Block block = new Block(img, 150+(i*40) , 300 , 40, 40, 0, 0);
			blockList.add(block); //��� ��Ͽ� �߰�!!
		}
	}
	//HP���� 
	public void createHP() {
		
		for(int i=0;i<4;i++) {
			Image img=ImageUtil.getIcon(this.getClass(), "res/game/block.png", 30, 30).getImage();
			HP hp = new HP(img, 50+(32*i), 60, 30,30, 0, 0);
			hpList.add(hp);
		}
	}
	
	public void showGameOver(Graphics2D g2) {
		g2.setFont(new Font("Arial Black",Font.BOLD,200));
		
		StringBuffer sb = new StringBuffer();
		sb.append("Game Over");
		g2.drawString(sb.toString(),50, 400);
	
	}
	//������ ��Ȳ, ���� ��� 
	public void printData(Graphics2D g2) {
		g2.setFont(new Font("Arial Black", Font.BOLD, 25));
		
		StringBuffer sb = new StringBuffer();
		sb.append("Bullet : 	"+bulletList.size());
		sb.append("   Enemy  : "+enemyList.size());
		sb.append("   Score : "+score);
		
		g2.drawString(sb.toString(),100, 50);
		
	}
	
	public void tick() {
		hero.tick();
		//if(bullet!=null)bullet.tick();
		//�ټ��� �Ѿ˿� ���� .tick()
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.tick();
		}
		
		//������ ���� tick() 
		for	 (int i = 0; i < enemyList.size(); i++) {
			Enemy enemy = enemyList.get(i);
			enemy.tick();
			
		}
		//���� ���� tick()
		for	 (int i = 0; i < blockList.size(); i++) {
			Block block= blockList.get(i);
			block.tick();		
		}
		//��濡 ���� tick()
		for (int i = 0; i < gameBg.length; i++) {
			gameBg[i].tick();
		}
		//hp ���� tick()
		for(int i=0;i<hpList.size();i++) {
			HP hp = hpList.get(i);
			hp.tick();
		}
	}
	
	public void render(Graphics2D g2) {		
		for (int i = 0; i < gameBg.length; i++) {
			gameBg[i].render(g2);;
		}
		hero.render(g2);
		//if(bullet!=null)bullet.render(g2);
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.render(g2);
		}
		//����
		for	 (int i = 0; i < enemyList.size(); i++) {
			Enemy enemy = enemyList.get(i);
			enemy.render(g2);	
		}
		for	 (int i = 0; i < blockList.size(); i++) {
			Block block= blockList.get(i);
			block.render(g2);		
		}
		printData(g2);
	}
	//��� ������ tick(), render()�� ȣ�� ! �� ���ӿ���! 
	private void gameLoop() {
		tick();
		this.repaint();
		//	System.out.println("gameLoop() called ... ");
	}
}
