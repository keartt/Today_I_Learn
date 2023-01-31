package Chat02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class AdminThread extends Thread {
	
	private AdminClient admin;
	private String message;
	String[] receivedMsg;
	ArrayList<UsersTable> info;
	
	public AdminThread(AdminClient admin) {
		this.admin= admin;
	}
	
	public void run() {

		boolean isStop = false;
		String name = "";

		// 무한 루프
		while (!isStop) {

			// 메시지 받아서 split
			try {
				
//-------------------회원정보-uesrA-------------------------------------------------------
				info =  DBRun.getInfo();
				admin.getUserA().setText("");
				admin.getUserA().append("순서\t이름\t이메일\t아이디\t비밀번호\t관리자여부\t"+System.getProperty("line.separator"));
				for (UsersTable m : info) {
					admin.getUserA().append( m.getId()
							+"\t"+ m.getName()
							+"\t"+ m.getEmail()
							+"\t"+ m.getUser_id()
							+"\t"+ m.getUser_pw()
							+"\t"+ m.isAdmin() +
							System.getProperty("line.separator"));
				}
				
				
				
				
//-------------------채팅히스토리-ChatA-------------------------------------------------------
				
				message = (String) admin.getOis().readObject();
				receivedMsg = message.split("#");
				// 시간
				String formatedNow = LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초"));

//				 처음 입장시
//				 클라이언트 스레드와 동일한 내용 
				if (message.contains("#")) {
					// 퇴장
					if (receivedMsg[1].equals("exit")) {
							admin.getChatA().append(receivedMsg[0] + "님이 종료 하셨습니다." + "\t" + LocalDate.now() + "\t"
									+ formatedNow + System.getProperty("line.separator"));
					// 강퇴
					}else if (receivedMsg[1].equals("kick")) {
							admin.getChatA().append(receivedMsg[2] + "님이" + receivedMsg[0] +" 님에 의해 강퇴되었습니다." + "\t" + LocalDate.now() + "\t"
									+ formatedNow + System.getProperty("line.separator"));
					}else {
						admin.getChatA().append(receivedMsg[0] + " 님이 " + " DB 에서 받아온 reciever  에게"+"==>"+receivedMsg[1] + "\t" + LocalDate.now() + "\t"
								+ formatedNow + System.getProperty("line.separator"));
					}
				} else {
					admin.getListA().setText("admin \n");
					admin.getListA().append(message);
				}
				

				
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}

		}
		System.exit(0);
	}
}
