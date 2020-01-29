package quiz6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Quiz6_4 extends JFrame {

	Quiz6_4() {
		Random r = new Random();
		setTitle("BorderLayout Pracice");
		setLayout(new GridLayout(1,10,0,0));
		
		for (int i = 0; i <= 9; i++) {
			JButton btn = new JButton(i+"");
			btn.setBackground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			add(btn);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz6_4();
	}

}
