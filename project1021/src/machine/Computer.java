class Computer{
	String color = "yellow";
	int price = 50;
}

class UseComputer {
	public void setColor(Computer p){ //(��)
		p.color="red";
	}
	public void setPrice(int price) {
		price=5; //(��)
	}
	
	public static void main(String[] args) {
		Computer com = new Computer();
		com.color = "black";

		UseComputer up = new UseComputer();
		up.setColor(com); // (��)
		up.setPrice(com.price);//(��)
		
		System.out.println(com.price);// (��)
	}
}
