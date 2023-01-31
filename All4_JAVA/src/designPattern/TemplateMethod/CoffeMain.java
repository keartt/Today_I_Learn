package designPattern.TemplateMethod;

public class CoffeMain {
	public static void main(String[] args) {
		IceAmericano aa = new IceAmericano();
		IceLatte al = new IceLatte();
		
		aa.makeCoffee();
		System.out.println("---");
		al.makeCoffee();
	}

}
