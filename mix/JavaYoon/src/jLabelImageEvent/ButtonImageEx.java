package jLabelImageEvent;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonImageEx extends JFrame {
	
	ButtonImageEx() {
		setTitle("버튼 피드백이미지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("call", new ImageIcon("images/normalIcon.gif"));
		btn.setPressedIcon(new ImageIcon("images/pressedIcon.gif"));
		btn.setRolloverIcon(new ImageIcon("images/rolloverIcon.gif"));
		add(btn);
		
		
		
		setSize(300, 200);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ButtonImageEx();
	}

}
