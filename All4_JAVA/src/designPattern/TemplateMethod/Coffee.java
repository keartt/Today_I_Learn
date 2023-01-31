package designPattern.TemplateMethod;

//https://www.crocus.co.kr/1531
public abstract class Coffee {
	final void makeCoffee() {
		putEspresso();
		putIce();
		putExtra();
	}

	private void putEspresso() {
		System.out.println("에스프레소 넣기");
	}

	private void putIce() {
		System.out.println("얼음 넣기");
	}

	abstract void putExtra();

}
