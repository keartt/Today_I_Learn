package day06.thread;

public class SingleThreadEx extends Thread {
	private int[] temp;

	public SingleThreadEx( String threadname) {
		super(threadname);
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	public void run() {
		for (int start : temp) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("쓰레드 이름 : %s", currentThread().getName());
			System.out.printf("temp value : %d %n",start);
		}
	}
	public static void main(String[] args) {
		Thread st = new SingleThreadEx("super man");
		st.start();
	}

		
	}


