package swingDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridEx extends JFrame {
	
	GridEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setLayout(new GridLayout(3,1));
		
		JPanel j1 = new JPanel();
		j1.setSize(100, 100);
		j1.setBackground(Color.blue);
		j1.add(new JButton("North"));
		add(j1);
		
		
		JPanel j5 = new JPanel();
		j5.setSize(500, 500);
		j5.add(new JButton("Center"));
		j5.setBackground(Color.red);
		add(j5);
		
		JPanel j2 = new JPanel();
		j2.setSize(100, 100);
		j2.add(new JButton("South"));
		add(j2);
		
		
		
		
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridEx();

	}

}
