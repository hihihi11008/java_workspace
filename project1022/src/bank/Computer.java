class Computer{
    Ram ram;
    HardDisk disk;

	//�ùٸ� �ʱ�ȭ��� 


}

class UseComputer{
    public static void main(String[] args){
      
        Computer  com=new Computer(); (A)
		//������ ��� 
		com.ram = new Ram();
		com.disk = new HardDisk();
         
    }
}
