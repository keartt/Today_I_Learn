package designPattern.factoryMethod;

public class RobotFactory {

	public Robot getRobot(String robotType) {
		if (robotType == null) {
			return null;
		}else if (robotType.equalsIgnoreCase("Super")){
			return new SuperRobot();
		}else if (robotType.equalsIgnoreCase("Power")){
			return new PowerRobot();
		}
		return null;
		
	}

}
