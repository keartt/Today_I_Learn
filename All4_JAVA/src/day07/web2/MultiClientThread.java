package day07.web2;
public class MultiClientThread extends Thread{
	
    private MultiClient mc;
    public MultiClientThread(MultiClient mc){
        this.mc = mc;
    }
    
    // 실행
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        
        boolean isStop = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject();
                
                // receivedMsg 배열은 위 메시지를 #으로 나눈 배열 string 형
                receivedMsg = message.split("#");
            }catch(Exception e){
                e.printStackTrace();
                isStop = true;
            }
            // 콘솔창에 아이디, 내용
            System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            
            // 메시지가 exit 와 같으면
            if(receivedMsg[1].equals("exit")){
            	// 메세지 받은거랑 현재 실행중인 창 아이디랑 같으면 종료
                if(receivedMsg[0].equals(mc.getId())){
                    mc.exit();	
                // 아니면 종료 메시지 전송
                }
                else{
                	// jta = 채팅방에 종료메시지 전송
                    mc.getJta().append(receivedMsg[0] +"님이 종료 하셨습니다."+
                    System.getProperty("line.separator"));
                    
                    // 알아서 내려가게 -스크롤 내려감
                    mc.getJta().setCaretPosition(mc.getJta().getDocument().getLength());
                }
            
                // 삭제 부분
//            }else if (receivedMsg[1].equals("/clear")) {
//            			mc.getJta().append(" ");
//                        mc.getJta().setCaretPosition(
//                        mc.getJta().getDocument().getLength());

//            	mc.getJta().selectAll();
            	
            	
            	
             // 메시지가 exit 와 같지 않으면	
			}else if (receivedMsg[1].equals("/clear")) {
				mc.getJta().setText("");
			}
            
            else{               
				// 이름 : 메시지 /n
				mc.getJta().append(receivedMsg[0] +" : "+receivedMsg[1]+System.getProperty("line.separator"));
                // 줄바꿈
                mc.getJta().setCaretPosition( mc.getJta().getDocument().getLength());
                
            }
        }
    }
}