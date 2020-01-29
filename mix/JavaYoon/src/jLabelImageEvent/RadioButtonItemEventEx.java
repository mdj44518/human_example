package jLabelImageEvent;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;

public class RadioButtonItemEventEx extends JFrame {
	JLabel imgLabel;
	
	RadioButtonItemEventEx() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton apple = new JRadioButton("apple");
		JRadioButton pear = new JRadioButton("pear",true);
		JRadioButton cherry = new JRadioButton("cherry");
		group.add(apple);
		group.add(pear);
		group.add(cherry);
		
		MyItemListener listener = new MyItemListener();
		apple.addItemListener(listener);
		pear.addItemListener(listener);
		cherry.addItemListener(listener);
		
		add(apple);
		add(pear);
		add(cherry);
		
		ImageIcon image = new ImageIcon("images/pear.jpg");
		imgLabel = new JLabel(image);
		add(imgLabel);
		
		
		setSize(250,200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			//사과라면
			if (e.getStateChange() == 1) {
				imgLabel.setIcon(new ImageIcon(
												"images/"
												+((AbstractButton)e.getSource()).getText()
												+".jpg"));
//				if (((AbstractButton)e.getSource()).getText().equals("사과")) {
//					imgLabel.setIcon(new ImageIcon("images/apple.jpg"));
//				} else if (((AbstractButton)e.getSource()).getText().equals("배")) {
//					imgLabel.setIcon(new ImageIcon("images/pear.jpg"));
//				} else {
//					imgLabel.setIcon(new ImageIcon("images/cherry.jpg"));
//				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new RadioButtonItemEventEx();
	}
}
