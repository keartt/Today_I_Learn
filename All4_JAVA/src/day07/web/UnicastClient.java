package day07.web;

import java.io.*;
import java.net.*;
public class UnicastClient {
    private String ip;
    private int port;
    private String message; 
    
    private BufferedReader file=null;
    private BufferedWriter bufferW = null;
    private BufferedReader bufferR = null;
    
    // 생성자를 통해 아이피와 포트를 받아온다. 
    public UnicastClient(String ip,int port) throws IOException{
        this.ip = ip;
        this.port = port;
        boolean isStop=false;
        
     // 서버소켓의 accept = 소켓의 getSocket -> 둘다 Socket 객체 반환
        Socket tcpSocket = getSocket();
		
        OutputStream os = tcpSocket.getOutputStream();      
        InputStream is = tcpSocket.getInputStream();    
        bufferW = new BufferedWriter(new OutputStreamWriter(os));
        bufferR = new BufferedReader(new InputStreamReader(is));
        
        
		while(!isStop){ // 트루가 되면 무한 루프 종료
			
			// 메시지를 받아 스트림, 버퍼에 넣고
			System.out.print("message : ");
			file = new BufferedReader(new InputStreamReader(System.in));			
			message = file.readLine();      
			message += System.getProperty("line.separator");    
			bufferW.write(message);     
			bufferW.flush();
						
			message = bufferR.readLine(); 
			if(message.equals("exit")) {
				isStop = true;
				System.out.println("종료되었습니다..");
			}else{
				System.out.println("Received message : " +	message);
			}
		}
        tcpSocket.close();
        bufferW.close();    
        bufferR.close();
        file.close();
    }
    public Socket getSocket(){
        Socket tcpSocket=null;
        try{
            tcpSocket = new Socket(ip,port);           
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }
        return tcpSocket;
    }
    public static void main(String[] args)  throws IOException{      
        new UnicastClient("localhost",3000);
    }
}
