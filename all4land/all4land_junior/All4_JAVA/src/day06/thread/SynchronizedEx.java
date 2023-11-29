package day06.thread;

class ATM implements Runnable {
	private long depositMoney = 10000;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				
					// 1번 방법
				try { //try는 예외를 감지하는
					notifyAll();//시작을 뜻함					//먼저 부모가 들어옴
					Thread.sleep(10);   				//1초 마다
					if (getDepositMoney()<=0)
						break;
					withDraw(1000);
					wait();		//wait()를 사용에 안에 시간만큼 대기 상태로 만든다.
				}catch (InterruptedException e) { //catch는 예외를 처리하는
					e.printStackTrace();
					
					// 2번 방법
				}
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException ie) {
//					ie.printStackTrace();
//
//				}
//				
//				if (getDepositMoney() <= 0) {
//					break;
//				}
//				withDraw(1000);
//				
//				///	정지 대기
//				notify();
//				try {
//					wait();	// wait 는 try catch 와 함꼐
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				///
			}
		}
	}

	public void withDraw(int howMuch) {
		if (getDepositMoney() > 0) {
			depositMoney -= howMuch;
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.printf("money : %d %n", getDepositMoney());
		} else {
			System.out.println(Thread.currentThread().getName() + " ,");
			System.out.println("out.");
		}
	}

	public long getDepositMoney() {
		return depositMoney;
	}
	
}

public class SynchronizedEx {
	public static void main(String[] args) {
		ATM atm = new ATM();

		Thread mother = new Thread(atm, " mother ");
		Thread son = new Thread(atm, " son ");

		mother.start();
		son.start();
	}
}
