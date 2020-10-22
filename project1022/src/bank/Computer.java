class Computer{
    Ram ram;
    HardDisk disk;

	//올바른 초기화방법 


}

class UseComputer{
    public static void main(String[] args){
      
        Computer  com=new Computer(); (A)
		//무식한 방법 
		com.ram = new Ram();
		com.disk = new HardDisk();
         
    }
}
