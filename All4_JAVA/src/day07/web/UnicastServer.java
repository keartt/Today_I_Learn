package day07.web;
// 유니캐스트는 기존 방식에서 서버와 클라이언트가 지속적으로 통신한다
// 지속적인 통신은 스레드로 표현했으며
// 클라이언트와 서버의 1:1 통신이라는 점은 변함이 없다. 

import java.io.*;
import java.net.*;
public class  UnicastServer{
	// 버퍼와 스트림은 -> 스레드로 이동 
    private ServerSocket serverS;
  
 // 생성자를 통해 포트 넘버를 받아와 서버 소켓을 실행
    public UnicastServer(int port){
        try{
            serverS = new ServerSocket(port);
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }
        
        UnicastServerThread ust=null;
        // 무한 루프
        while(true){
            System.out.println("클라이언트 대기중");
    		Socket s=null;
    		try{
    			// 서버에 들어오면... s = Socket 타입 객체
    			// 서버소켓의 accept = 소켓의 getSocket 
    			// 클라이언트가 연결되면 accept() 메소드는 Socket 객체를 반환
    			s = serverS.accept();
    			
    		}catch(IOException ioe){
    			ioe.printStackTrace();
    		}
    		
    			// 클라이언트 아이피를 출력한다. 
    							// 소켓 객체를 inetaddress 객체로 반환 . 호스트 ip 주소 반환
            System.out.println("client ip : "+s.getInetAddress().getHostAddress());
    		
            // 스레드로 이동 
    		ust = new UnicastServerThread(s);			
    		Thread t = new Thread(ust);
    		t.start();			
    	}
    }
    public static void main(String[] args){
        new UnicastServer(3000);
    }
}
