package day1110.network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	ServerSocket server;//대화용 소켓이아니라, 접속자를 감지하고 접속자를 발견되면 대화용 소켄을 반환해주는 객체
	//(마치전화기의 벨이 울리면 그이후부터 자화를 받고 대화하는것과 비슷)
	//전화 받는용 소켓 
	int port=8989; //클라이언트를 받아들일 포트번호, 이 포트번호에 의해 다른 네트워크 프로세스와 구분될 수 있다 예)오라클 1521, mysql 3306
	
	
	public EchoServer() {
		try {
			server=new ServerSocket(port);//서버소켓 생성(아직 가동은 아님)
			System.out.println("서버소켓 생성완료");
			Socket socket=server.accept();//서버가동  및 클라이언트접속 기다림.. (접속이 들어올떄까지 무한대기 하다 지연발생)
			//개발자는 반환받은 소켓으로부터 통신에 필요한 입출력 스트림을 얻을 수 있다 
			//이때 개발자는 네트워크 하부에 대한 아무런 지식이없이 그냥 스트림처리만 하면 알아서 원격지의 대화상대와 통신이 가능하며 
			//이 모든 것들은 소켓이 알아서 해주는 거다 
			InputStream is=socket.getInputStream();//바이트기반의 입력스트림이므로 영문만 해석가능한 상태 
			InputStreamReader reader=new InputStreamReader(is);
			BufferedReader buffr= new BufferedReader(reader);
			String data;
			while (true) {
				data =buffr.readLine();//1byte읽기 (소켓과 연결된 스트림으로부터 ) 
				System.out.print(data);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public static void main(String[] args) {
		new EchoServer();
	}
}
