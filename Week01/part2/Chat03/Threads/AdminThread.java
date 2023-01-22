package Chat03.Threads;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import Chat03.Client.AdminClient;
import Chat03.db.DBRun;
import Chat03.db.LoginLog;
import Chat03.db.Users;

public class AdminThread extends Thread {

	private AdminClient admin;
	private String message;
	String[] receivedMsg;
	ArrayList<Users> info;
	ArrayList<LoginLog> log;

	public AdminThread(AdminClient admin) {
		this.admin = admin;
	}

	public void run() {

		boolean isStop = false;

		// 무한 루프
		while (!isStop) {

			// 메시지 받아서 split
			try {

//------------------로그인기록-uesrA-------------------------------------------------------
				log = DBRun.getLog();
				admin.getLoginA().setText("");
				admin.getLoginA().append("아이디  로그인여부  시간" + System.getProperty("line.separator"));
				admin.getLoginA().append("----".repeat(16) + System.getProperty("line.separator"));
				for (LoginLog l : log) {
					// 타임스탬프 - 포맷지정
					String timeF = new SimpleDateFormat("HH시 mm분 ss초", Locale.KOREA).format(l.getIn_out_time());
					String loginCheck;
					if (l.isLogin()) {
						loginCheck = "<- 로그인";
					} else {
						loginCheck = "->로그아웃";
					}
					admin.getLoginA().append(
							l.getUser_id() + loginCheck + " \t " + timeF + System.getProperty("line.separator"));
				}

//-------------------회원정보-uesrA-------------------------------------------------------
				info = DBRun.getInfo();
				admin.getUserA().setText("");
				admin.getUserA().append("순서\t이름\t이메일\t아이디\t비밀번호\t관리자여부\t" + System.getProperty("line.separator"));
				admin.getUserA().append("----".repeat(40) + System.getProperty("line.separator"));
				for (Users m : info) {
					admin.getUserA().append(m.getId() + "\t" + m.getName() + "\t" + m.getEmail() + "\t" + m.getUser_id()
							+ "\t" + m.getUser_pw() + "\t" + m.isAdmin() + System.getProperty("line.separator"));
				}


//------------------ 접속 정보 및 채팅내용--------------------------------------------------------

				message = (String) admin.getOis().readObject();
				receivedMsg = message.split("#");
				// 시간
				String formatedNow = LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초"));

				//입장, 퇴장 메시지와 유저리스트 추가 내용은  클라이언트 스레드와 동일한 내용 
				if (message.contains("#")) {
					// 퇴장
					if (receivedMsg[1].equals("exit")) {
							admin.getChatA().append("-----" +receivedMsg[0] + " : 님 종료." + "\t"  + "\t"
									+ formatedNow + System.getProperty("line.separator"));
					// 강퇴
					}else if (receivedMsg[1].equals("kick")) {
							admin.getChatA().append(receivedMsg[2] + "님이" + receivedMsg[0] +" 님에 의해 강퇴되었습니다." + "\t"  + "\t"
									+ formatedNow + System.getProperty("line.separator"));
					}// 입장메시지
					else if (receivedMsg[1].equals("in")) {
						admin.getChatA().append("-----" + receivedMsg[0] + " : 님 입장!" + "\t"  + "\t"
								+ formatedNow + System.getProperty("line.separator"));
					}
					
					
					// 귓말과 일반 대화 내용은 - > DB 에 저장되어 있는 내용 출력 
					// 귓말
					else if (receivedMsg[1].equals("귓말")) {
						admin.getChatA().append(  "-----귓말----- " +receivedMsg[0] + " 님이 " +receivedMsg[2] +" 에게 : "+receivedMsg[3] + "\t" + "\t"
								+ formatedNow + System.getProperty("line.separator"));
					}
					// 디폴트 채팅내용
					else {
						admin.getChatA().append(receivedMsg[0] + "\t : " +receivedMsg[1] + "\t" + "\t"
								+ formatedNow + System.getProperty("line.separator"));
					}
				 // 유저리스트에 추가 	
				} else {
					admin.getListA().setText("");
					admin.getListA().append(message);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.exit(0);
	}
}