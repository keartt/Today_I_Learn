package day07.awt;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class TextFieldEX {
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		Panel p = new Panel();
		
		TextField f1 = new TextField("id : ", 3);
		TextField f2 = new TextField("pw : ", 4);
		
		f1.selectAll();
		f2.selectAll();
		
		// char = ' '
		f2.setEchoChar('*');
		
		p.add(f1);
		p.add(f2);
		
		f.add(p);
		
		f.setSize(300,300);
		f.setVisible(true);
		
	}
}
