package designPattern;

public class Singleton {
	
	private static Singleton st = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getSingleton() {
		return st;
	}
	
}

class SingletonCall {
	public static void main(String[] args) {
		//  기본 생성자가 private 이므로 getSingleton 메소드를 통해서만 호출 가능
		Singleton singleton = Singleton.getSingleton();
	}
}
