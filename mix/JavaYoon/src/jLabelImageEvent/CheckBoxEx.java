package jLabelImageEvent;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {

	CheckBoxEx() {
		setTitle("하하 타이틀");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		JCheckBox box1 = new JCheckBox("사과");
		JCheckBox box2 = new JCheckBox("배", true);
		JCheckBox box3 = new JCheckBox("체리", new ImageIcon("images/cherry.jpg"));
		box3.setBorderPainted(true);
		box3.setSelectedIcon(new ImageIcon(ButtonImageEx.class.getResource("../testImg/selectedCherry.jpg")));
		
		add(box1);
		add(box2);
		add(box3);
		
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxEx();
	}

}
