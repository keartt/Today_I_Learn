package day06.thread;

public class SingleThreadEx2 implements Runnable {
	private int[] temp;
	
	 public SingleThreadEx2() {
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	
	public void run() {
		for (int start : temp) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("쓰레드 이름 : %s",Thread.currentThread().getName() );
			System.out.printf("temp value : %d %n",start);
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new SingleThreadEx2(),"batman");

//		스레드 생성 후 이름 추가하고 싶을 때		
//		Thread t = new Thread(new SingleThreadEx2());
//		t.setName("batman");
		
		t.start();
	}
}


	

		
	


