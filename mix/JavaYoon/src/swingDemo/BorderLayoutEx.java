package swingDemo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {
	
	BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		add(new JButton("add"), BorderLayout.NORTH);
		add(new JButton("sub"), BorderLayout.SOUTH);
//		add(new JButton("mul"), BorderLayout.EAST);
//		add(new JButton("div"), BorderLayout.WEST);
		add(new JButton("Calculate"), BorderLayout.CENTER);
		
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutEx();

	}

}
