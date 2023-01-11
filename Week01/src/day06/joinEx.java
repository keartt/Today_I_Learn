package day06;

class MyRunnableTwo implements Runnable {
	@Override
	public void run() {
		System.out.println("run");
		first();
	}

	private void first() {
		System.out.println("first");
		second();
	}

	private void second() {
		System.out.println("second");
	}
}

public class joinEx {
	public static void main(String[] args) {
		// 스레드 시작전에 스레드 호출? = main 도 스레드다
		System.out.println(Thread.currentThread().getName() + " start");

		Thread t = new Thread(new MyRunnableTwo());
		t.start();

		// 조인 안하면 메인 먼저 끝나고 스레드 실행됨
		// 스레드는 별도의 프로세스, 메인과 별도
		try {
			t.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
