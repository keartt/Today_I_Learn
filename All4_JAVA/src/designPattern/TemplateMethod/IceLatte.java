package designPattern.TemplateMethod;

public class IceLatte extends Coffee {

	@Override
	void putExtra() {
		System.out.println("우유 넣기");
	}

}
