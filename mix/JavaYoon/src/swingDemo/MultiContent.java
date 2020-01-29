package swingDemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiContent extends JFrame {
	
	MultiContent() {
		setTitle("여러개의 콘테이너 어떻게?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		JPanel panel=new JPanel();
		con.setLayout(new GridLayout(1,2));
		con.setBackground(Color.blue);
		
		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
//		new MultiContent();
		int i;
		do {
			i = (int)(Math.random()*200)+50;
		} while (i != 249);
		System.out.println(i);
	}

}
