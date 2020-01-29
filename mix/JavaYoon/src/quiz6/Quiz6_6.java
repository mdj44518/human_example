package quiz6;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiz6_6 extends JFrame {
	
	Quiz6_6() {
		Random r = new Random();
		setTitle("Quiz6_6");
		setLayout(null);
		
		for (int i = 0; i < 20; i++) {
			JLabel label = new JLabel();
			label.setBackground(Color.BLUE);
			label.setOpaque(true);
			label.setSize(10, 10);
			label.setLocation(r.nextInt(201)+50, r.nextInt(201)+50);
			add(label);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz6_6();
	}
}
