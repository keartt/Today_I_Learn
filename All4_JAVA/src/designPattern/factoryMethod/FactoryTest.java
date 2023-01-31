package designPattern.factoryMethod;

public class FactoryTest {
	public static void main(String[] args) {
		RobotFactory robotFactory = new RobotFactory();
		
		Robot r1 =robotFactory.getRobot("Super");
		Robot r2 =robotFactory.getRobot("Power");
		
		r1.getName();
		r2.getName();
	}

}
