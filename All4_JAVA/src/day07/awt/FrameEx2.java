package day07.awt;
import java.awt.Frame;

public class FrameEx2 extends Frame {

	public FrameEx2() {
		super("Test");
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FrameEx2 f = new FrameEx2();
	}
}
