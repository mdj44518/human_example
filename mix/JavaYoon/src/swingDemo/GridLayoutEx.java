package swingDemo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx extends JFrame {
	
	GridLayoutEx() {
		setTitle("GridLauout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(5,2);
		grid.setVgap(5);
		setLayout(grid);
		add(new JLabel(" 이름"));
		add(new JTextField());
		add(new JLabel(" 학번"));
		add(new JTextField());
		add(new JLabel(" 학과"));
		add(new JTextField());
		add(new JLabel(" 과목"));
		add(new JTextField());
		add(new JButton("입력"));
		add(new JButton("취소"));
		
		
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx();
	}
}
