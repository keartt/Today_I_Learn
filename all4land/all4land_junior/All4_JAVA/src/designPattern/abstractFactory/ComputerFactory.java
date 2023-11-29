package designPattern.abstractFactory;

public class ComputerFactory implements ProductAbstractFactory{

	private String name;
	private int price;
	
	
	public ComputerFactory(String name, int price) {
		this.name=name;
		this.price=price;
	}
	
	@Override
	public Product createProduct() {
		return new Computer(name, price);
	}

}
