package quiz6;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Quiz6_2 extends JFrame {

	Quiz6_2() {
		setTitle("BorderLayout Pracice");
		setLayout(new BorderLayout(5, 7));
		add(new JButton("North"), BorderLayout.NORTH);
		add(new JButton("West"), BorderLayout.WEST);
		add(new JButton("Center"), BorderLayout.CENTER);
		add(new JButton("East"), BorderLayout.EAST);
		add(new JButton("South"), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz6_2();
	}

}
