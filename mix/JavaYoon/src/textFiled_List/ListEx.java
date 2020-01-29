package textFiled_List;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class ListEx extends JFrame {
	Container contentPane;
	String[] fruits = {"banana","apple","banana","apple","banana","banana","apple","banana","apple","banana","banana","apple","banana","apple","banana","banana","apple","banana","apple","banana"};
	ImageIcon[] images = {
		new ImageIcon("images/icon1.png"),
		new ImageIcon("images/icon2.png"),
		new ImageIcon("images/icon3.png"),
		new ImageIcon("images/icon4.png")
	};
	
	ListEx() {
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox strList = new JComboBox(fruits);
		contentPane.add(strList);
		
		
		JList imageList = new JList();
		imageList.setListData(images);
		contentPane.add(imageList);
		
		JList scrollList = new JList(fruits);
		JScrollPane scroll = new JScrollPane(scrollList);
		contentPane.add(scroll);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListEx();
	}
}
