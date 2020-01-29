package eventListener;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlertDemo extends JFrame {
	
	AlertDemo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan = new JPanel();
		setContentPane(pan);
		
		
		JTextField  textField = new JTextField(15);
		pan.add(textField);
		textField.addKeyListener(new MyKeyClass());
		
		//버튼만들기
		JButton btn = new JButton("확인");
		
		
		setSize(300,200);
		setVisible(true);
	}
	class MyKeyClass extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			JTextField field = (JTextField)e.getSource();
			System.out.println(field.getText());
		}
	}

	public static void main(String[] args) {
		new AlertDemo();

	}

}
