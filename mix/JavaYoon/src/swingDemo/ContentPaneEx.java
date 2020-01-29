package swingDemo;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {
	ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		FlowLayout t = new FlowLayout();
//		t.setVgap(40);
//		t.setAlignment(FlowLayout.LEFT );
//		getContentPane().setLayout(t);
		getContentPane().add(new JButton("OK"));
		getContentPane().add(new JButton("OK"));
		getContentPane().add(new JButton("OK"));
		getContentPane().add(new JButton("OK"));
		
		setSize(150,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ContentPaneEx();
	}
}
