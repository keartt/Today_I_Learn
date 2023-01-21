package Chat03;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import Chat03.db.DBRun;

public class MultiClientThread extends Thread {

	// 참조 변수 선언
	private MultiClient mc;
	private String message;
	String[] receivedMsg;

	// 생성자
	public MultiClientThread(MultiClient mc) {
		this.mc = mc;
	}

	// run() 오버라이드
	public void run() {

		boolean isStop = false;

		// 무한 루프
		while (!isStop) {

			// 메시지 받아서 split
			try {
				message = (String) mc.getOis().readObject();
				receivedMsg = message.split("#");
				// 시간
				String formatedNow = LocalTime.now().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초"));

				
				// 처음 입
				if (!message.contains("#")) {
					mc.getList().setText("");
					mc.getList().append(message);
					

				} else {
					// 종료
					if (receivedMsg[1].equals("exit")) {
						// 퇴장 메시지 출력 및 시간 출력
						if (receivedMsg[0].equals(mc.getName())) {
							mc.exit();
						} else {
							mc.getChat().append(receivedMsg[0] + "님이 종료 하셨습니다." + "\t" + LocalDate.now() + "\t"
									+ formatedNow + System.getProperty("line.separator"));
							mc.getTextField().setCaretPosition(mc.getTextField().getDocument().getLength());
						}
					}
					// clear 입력 시 본인 채팅창의 메시지 모두 삭제
					else if (receivedMsg[1].equals("clear")) {
						if (receivedMsg[0].equals(mc.getName())) {
							mc.getChat().setText("");
						}

					}
					// 강퇴기능 kick#아이디
					else if (receivedMsg[1].equals("kick")) {
						if (receivedMsg[2].equals(mc.getName())) {
							mc.exit();
						} else {
							mc.getChat().append(receivedMsg[2] + "님이" + receivedMsg[0] +" 님에 의해 강퇴되었습니다." + "\t" + LocalDate.now() + "\t"
									+ formatedNow + System.getProperty("line.separator"));
							mc.getTextField().setCaretPosition(mc.getTextField().getDocument().getLength());
						}
					}
					
					// 비속어 처리 + 시간 출력
					else if (receivedMsg[1].equals("시발") || receivedMsg[1].equals("바보")) {
						mc.getChat().append(receivedMsg[0] + " : **" + "\t" + "욕설을 하지 마세요!!" + "\t" + LocalDate.now()
								+ "\t" + formatedNow + System.getProperty("line.separator"));
						mc.getChat().setCaretPosition(mc.getTextField().getDocument().getLength());
					}
					// 입장메시지
					else if (receivedMsg[1].equals("in")) {
						mc.getChat().append(receivedMsg[0] + " : 님 입장!" + "\t" + LocalDate.now() + "\t"
								+ formatedNow + System.getProperty("line.separator"));
						mc.getChat().setCaretPosition(mc.getTextField().getDocument().getLength());
					}
					// 귓말
					else if (receivedMsg[1].equals("귓말")) {
						if (receivedMsg[2].equals(mc.getName())) {
							mc.getChat().append("-->"+receivedMsg[0] + " 님의 귓말  :" + receivedMsg[3]+ "\t" + LocalDate.now() + "\t"
									+ formatedNow + System.getProperty("line.separator"));
							mc.getTextField().setCaretPosition(mc.getTextField().getDocument().getLength());
						} else {
							mc.getChat().setCaretPosition(mc.getTextField().getDocument().getLength());
						}
					}
					
					
					// 메시지 + 시간 출력
					else {
						mc.getChat().append(receivedMsg[0] + " : " + receivedMsg[1] + "\t" + LocalDate.now() + "\t"
								+ formatedNow + System.getProperty("line.separator"));
						mc.getChat().setCaretPosition(mc.getTextField().getDocument().getLength());
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}

		}
		System.exit(0);
	}
}