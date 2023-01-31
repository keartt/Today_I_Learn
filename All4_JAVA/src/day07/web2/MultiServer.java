package day07.web2;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	
	
	public MultiServer()throws IOException{
		list = new ArrayList<MultiServerThread>();
		ServerSocket serverSocket = new ServerSocket(5000);
		
		//스레드
		MultiServerThread mst = null;
		boolean isStop = false;
		
		// 무한반복 진행
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();
			
			mst = new MultiServerThread(this);
			
			// ArrayList 에 스레드 입력
			list.add(mst);
			
			// 그 스레드 실행
			Thread t = new Thread(mst);
			t.start();
		}
	}
	
	
	public ArrayList<MultiServerThread>getList(){
		return list;
	}
	public Socket getSocket()
	{
		return socket;
	}
	public static void main(String arg[])throws IOException{
		new MultiServer();
	}
}
