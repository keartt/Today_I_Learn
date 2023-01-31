package designPattern.strategyP;

public class Main {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		
		restaurant.serving();
		
		restaurant.setServe(new Pizza());
		restaurant.serving();
		
		restaurant.setServe(new Chicken());
		restaurant.serving();
	}

}
