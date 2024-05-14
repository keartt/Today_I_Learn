package day07.web2;
import java.net.*;
import java.io.*;
public class MultiServerThread implements Runnable{
    private Socket socket;
    private MultiServer ms;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    // 생성자를 통해 실행 ms = 멀티서버
    public MultiServerThread(MultiServer ms){
        this.ms = ms;
    }
    
    // 스레드 run - synchronized .. 단일
    public synchronized void run(){
        boolean isStop = false;
        
        try{
        	// 소켓 반환 = 서버소켓 accept = 소켓 객체 반환
            socket = ms.getSocket();
            
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            String message = null;
            
            
            while(!isStop){
            	// 받은 인풋 값 to String
                message = (String)ois.readObject();
                // 이걸 배열에 넣는데 나누어서
                String[] str = message.split("#");
                // str[0] 은 아이디 [1] 은 내용 
                //입력이 exit 면 
                if(str[1].equals("exit")){
                    broadCasting(message);
                    // 탈출
                    isStop = true;
                }else{
                	// 서버 스레드에 메시지를 보낸다.전부
                    broadCasting(message);
                }
            }
            
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+ "정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+ "비정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }
    }
    
    
    public void broadCasting(String message)throws IOException{
        for(MultiServerThread ct : ms.getList()){
           ct.send(message);
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);        
    }
}
