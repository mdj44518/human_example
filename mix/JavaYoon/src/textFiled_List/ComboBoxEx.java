package textFiled_List;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ComboBoxEx extends JFrame {
	Container contentPane;
	JLabel image;
	String[] fruits = {
						"apple",
						"banana",
						"kiwi",
						"mango"
						};
	ImageIcon[] images = {
		new ImageIcon("images/apple.jpg"),
		new ImageIcon("images/banana.jpg"),
		new ImageIcon("images/kiwi.jpg"),
		new ImageIcon("images/mango.jpg")
	};
	
	ComboBoxEx() {
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox mainBox = new JComboBox(fruits);
		mainBox.addItemListener(new ItemListenerM());// 두번이 실행되고 같은거 선택시에는 발생x
//		mainBox.addActionListener(new ItemListenerM());//뭔가 선택하면 무조건 발동
		contentPane.add(mainBox);
		
		//image add
		image = new JLabel(new ImageIcon("images/apple.jpg"));
		
		contentPane.add(image);
		
		setSize(200,300);
		setVisible(true);
	}
	
	class ItemListenerM implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) { // 두번이 실행되고 같은거 선택시에는 발생x
			JComboBox choice = (JComboBox)e.getSource();
			image.setIcon(images[choice.getSelectedIndex()]);
		}
		
	}
//	class ItemListenerM implements ActionListener {//뭔가 선택하면 무조건 발동
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JComboBox choice = (JComboBox)e.getSource();
//			
//		}
//		
//	}
	
	public static void main(String[] args) {
		new ComboBoxEx();
	}
}
