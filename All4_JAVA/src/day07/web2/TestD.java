package day07.web2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.Color;

public class TestD {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestD window = new TestD();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 572, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 306, 345, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(379, 14, 160, 286);
		frame.getContentPane().add(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 10, 355, 286);
		frame.getContentPane().add(textArea);
	}
}
