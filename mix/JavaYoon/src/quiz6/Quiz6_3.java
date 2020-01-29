package quiz6;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Quiz6_3 extends JFrame {

	Quiz6_3() {
		setTitle("BorderLayout Pracice");
		setLayout(new GridLayout(1,10,0,0));

		for (int i = 0; i <= 9; i++) {
			add(new JButton(i+""));
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz6_3();
	}

}
