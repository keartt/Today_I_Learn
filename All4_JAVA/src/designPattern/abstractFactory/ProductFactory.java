package designPattern.abstractFactory;

public class ProductFactory {
	public static Product getProduct(ProductAbstractFactory product) {
		return product.createProduct();
	}

	public static void main(String[] args) {
		Product com = ProductFactory.getProduct(new ComputerFactory("com1", 2000));
		Product tk = ProductFactory.getProduct(new TicketFactory("공연", 100000));
		System.out.println(com.toString());
		System.out.println(tk.toString());
	}
}
