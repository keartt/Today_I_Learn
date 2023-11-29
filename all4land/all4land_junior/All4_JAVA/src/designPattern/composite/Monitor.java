package designPattern.composite;

public class Monitor  {
	private int price;
	private int power;

	public Monitor(int power, int price) {
		this.power = power;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
}
