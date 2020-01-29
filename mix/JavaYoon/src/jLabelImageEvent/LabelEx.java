package jLabelImageEvent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class LabelEx extends JFrame {
	
	LabelEx() {
		setTitle("이미지도 넣어보자~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		FlowLayout layoutF = new FlowLayout();
//		layoutF.setAlignment(FlowLayout.LEFT);
		con.setLayout(layoutF);
		
		JLabel loveText = new JLabel("사랑합니다.");
		con.add(loveText);
		
		ImageIcon image1 = new ImageIcon("images/beauty.jpg");
		JLabel img1 = new JLabel(image1);
		con.add(img1);
		
		ImageIcon image2 = new ImageIcon("images/normalIcon.gif");
		JLabel Text_img = new JLabel("보고싶으면 전화하세요", image2, SwingConstants.CENTER);
		con.add(Text_img);
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}
}
