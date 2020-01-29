package quiz6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quiz6_7 extends JFrame {
	
	Quiz6_7() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		//3개 셋팅.
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		con.add(panel_1, BorderLayout.NORTH);
		con.add(panel_2, BorderLayout.CENTER);
		con.add(panel_3, BorderLayout.SOUTH);
		
		//페널 위아래 색상
		panel_1.setBackground(Color.GRAY);
		panel_3.setBackground(Color.YELLOW);
		
		// 1번 패널
		panel_1.add(new JLabel("수식입력"));
		panel_1.add(new JTextField(25));
		
		
		// 2번 패널 숫자 넣기
		panel_2.setLayout(new GridLayout(4,4,2,2));
		for (int i = 0; i < 10; i++) {
			panel_2.add(new JButton(i+""));
		}
		panel_2.add(new JButton("CE"));
		panel_2.add(new JButton("계산"));
		
		//연산 버튼 4개
		JButton colorBtn_1 = new JButton("+");
		JButton colorBtn_2 = new JButton("-");
		JButton colorBtn_3 = new JButton("x");
		JButton colorBtn_4 = new JButton("/");
		colorBtn_1.setBackground(Color.cyan);
		colorBtn_2.setBackground(Color.cyan);
		colorBtn_3.setBackground(Color.cyan);
		colorBtn_4.setBackground(Color.cyan);
		panel_2.add(colorBtn_1);
		panel_2.add(colorBtn_2);
		panel_2.add(colorBtn_3);
		panel_2.add(colorBtn_4);
		
		// 3번 패널
		FlowLayout layout = new FlowLayout();
		layout.setVgap(2);
		layout.setAlignment(FlowLayout.LEFT);
		panel_3.setLayout(layout);
		panel_3.setSize(300, 300);
		panel_3.add(new JLabel("계산결과"));
		panel_3.add(new JTextField(25));
		
		
		
		setSize(400, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz6_7();
	}
}
