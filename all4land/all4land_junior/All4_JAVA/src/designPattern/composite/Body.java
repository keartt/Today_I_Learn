package designPattern.composite;

public class Body {
	private int price;
	private int power;

	public Body(int power, int price) {
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
