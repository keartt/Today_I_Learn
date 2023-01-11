package designPattern.strategyP;

public class Chicken implements Serve{
	@Override
	public void serving() {
		System.out.println("치킨 나왔습니다.");
	}

}
