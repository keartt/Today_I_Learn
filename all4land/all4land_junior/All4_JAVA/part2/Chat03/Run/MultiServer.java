package Chat03.Run;

import java.io.*;
import java.net.*;
import java.util.*;

import Chat03.Threads.MultiServerThread;

public class MultiServer {
	
	private ArrayList<String> userList;
	private ArrayList<MultiServerThread> list;		// ArrayList 참조 변수
	private Socket socket;							
	
	//생성자 함수
	public MultiServer()throws IOException{
	
		// ServerThread -> ArrayList 
		list = new ArrayList<MultiServerThread>();
		ServerSocket serverSocket = new ServerSocket(5000);
		MultiServerThread mst = null;
		boolean isStop = false;
		
		userList = new ArrayList<String>();
		
		// 무한루프
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();
			
			// 서버 스레드를 ArrayList에서 관리
			mst = new MultiServerThread(this);
			list.add(mst);
			Thread t = new Thread(mst);
			t.start();
		}
	}
	
	public ArrayList<MultiServerThread>getList(){
		return list;
	}
	
	public ArrayList<String> getUserList(){
		return userList;
	}
	
	// 소켓 반환
	public Socket getSocket()
	{
		return socket;
	}
	
	public static void main(String arg[])throws IOException{
		new MultiServer();
	}
}
