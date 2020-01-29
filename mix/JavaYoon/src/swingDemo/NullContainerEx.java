package swingDemo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {
	NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130,50);// layout null 이면 
		la.setSize(200,20); // 위 글자의 위치잡고 크기잡고?
		add(la);
		
		for (int i = 1; i <= 9; i++) {
			JButton btn = new JButton(i+"");
			btn.setLocation(i*15,i*15);
			btn.setSize(50,20);
			add(btn);
		}
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
//		new NullContainerEx();
		String str = "한글 과 a";
				System.out.println(Arrays.toString(str.getBytes()));
			System.out.println(str.getBytes().length);
	}
}
