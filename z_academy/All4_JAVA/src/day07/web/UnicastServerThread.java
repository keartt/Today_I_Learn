package day07.web;

import java.net.*;
import java.io.*;
public class UnicastServerThread implements Runnable{
	private Socket socket;
	private BufferedReader bufferR; 
    private BufferedWriter bufferW;
    private InputStream is;
    private OutputStream os;
    
	private String message;	
	
	// 생성자를 통해 소켓을 받아온다. 
	public UnicastServerThread(Socket socket){
		this.socket = socket;		
	}
	
	// 스레드 실행
	public void run(){
		boolean isStop = false;		
		
		try{
			// Reader = input =Scanner 
			is = socket.getInputStream();
			bufferR = new BufferedReader(new InputStreamReader(is));
			// Writer = output = Sys.out
			os = socket.getOutputStream();            
		    bufferW = new BufferedWriter(new OutputStreamWriter(os));	
        }catch(IOException ioe){
			isStop=true;	// 예외 발생 즉 잘못되면 트루가 됨
		}
		try{	
			while(!isStop){	// 트루가 되면 무한 루프 종료 
							
					// 메세지를 읽는데 그게 exit 면 트로 = 종료
	                String message = bufferR.readLine();
					if(message.equals("exit")) isStop = true;
					
					// 읽은 메시지 출력
					System.out.println("수신메시지 : "+message);
					
	                message += System.getProperty("line.separator");
	                // 버퍼를 통해 출력하고 
					bufferW.write(message);
					// 버퍼 비우기
	                bufferW.flush();	            
	        }//while end		
			
		}catch(IOException ioe){
			System.out.println("클라이언트가 강제로 \" +	\"종료되었습니다..");
            isStop=true;
            
        }finally{
            try{
                if(bufferR != null) bufferR.close();
                if(bufferW != null) bufferW.close();
                if(socket != null) socket.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }//finally end
	}//run end	
}