package jLabelImageEvent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CheckBoxItemEventEx extends JFrame {
	int sum = 0;
	JLabel result;
	
	CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		con.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배");
		JCheckBox cherry = new JCheckBox("체리");
		apple.setBorderPainted(true);
		pear.setBorderPainted(true);
		cherry.setBorderPainted(true);
		
		MyItemListener Itemlistener = new MyItemListener();
		apple.addItemListener(Itemlistener);
		pear.addItemListener(Itemlistener);
		cherry.addItemListener(Itemlistener);
		
		con.add(apple);
		con.add(pear);
		con.add(cherry);
		
		result = new JLabel("현재 0 원 입니다.");
		con.add(result);
		
		setSize(250,200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox choice = (JCheckBox)e.getItem();
			int PorM = choice.isSelected() ? 1 : -1;
			
			if (choice.getText().equals("사과")) {
				sum = sum + PorM*100;
			} else if (choice.getText().equals("배")) {
				sum = sum + PorM*500;
			} else {
				sum = sum + PorM*20000;
			}
			
			result.setText("현재 "+ sum +" 원 입니다.");
		}
		
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}

}
