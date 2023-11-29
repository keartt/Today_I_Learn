package designPattern.composite;

public class Client {
	public static void main(String[] args) {
		// 컴퓨터의 부품으로 Keyboard, Body, Monitor 객체를 생성
		Keyboard keyboard = new Keyboard(5, 2);
		Body body = new Body(100, 70);
		Monitor monitor = new Monitor(20, 30);

		// Computer 객체를 생성하고 부품 객체들을 설정
		Computer computer = new Computer();
		computer.addKeyboard(keyboard);
		computer.addBody(body);
		computer.addMonitor(monitor);

		// 컴퓨터의 가격과 전력 소비량을 구함
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price: " + computerPrice + "만원");
		System.out.println("Computer Power: " + computerPower + "W");
	}
}
