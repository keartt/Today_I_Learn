package designPattern.strategyP;

public class Pizza implements Serve {

	@Override
	public void serving() {
		System.out.println("피자 나왔습니다.");
	}

}
