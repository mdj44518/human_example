package swingDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutEx2 extends JFrame {
	
	BorderLayoutEx2() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,2));
		
		panel1.add(new JButton("North-1"));
		panel1.add(new JButton("North-2"));
		JPanel panel1_1 = new JPanel();
		panel1_1.setLayout(null);
		JLabel btn_null = new JLabel("1");
//		btn_null 위치 좌표넣기?
		btn_null.setBackground(Color.GREEN);
		btn_null.setOpaque(true);
//		btn_null.setLocation(200, 0);
		
		panel1_1.add(btn_null);
		panel1.add(panel1_1);
		con.add(panel1, BorderLayout.NORTH);
		
		
		JPanel j2 = new JPanel();
		j2.setLayout(null);
		j2.setSize(1500, 300);
		j2.add(new JButton("South"));
		con.add(j2, BorderLayout.SOUTH);
		
		
		JPanel j5 = new JPanel();
		j5.add(new JButton("Center"));
		j5.setBackground(Color.red);
		con.add(j5, BorderLayout.CENTER);
		
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutEx2();

	}

}
