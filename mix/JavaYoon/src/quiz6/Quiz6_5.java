package quiz6;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiz6_5 extends JFrame {
	
	Quiz6_5() {
		Random r = new Random();
		setTitle("Quiz6_5");
		setLayout(new GridLayout(4,4));
		
		for (int i = 0; i <= 15; i++) {
			JLabel label = new JLabel(i+"");
			label.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			label.setOpaque(true);
			add(label);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz6_5();
	}
}
