package designPattern.strategyP;

public class Restaurant {
	private Serve serve;
	
	public void setServe(Serve serve) {
		this.serve=serve;
	}
	public void serving() {
		if (serve == null) {
			System.out.println("주문 하세요");
		} else {
			// 위임
			serve.serving();
		}
	}
}
