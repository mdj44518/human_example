package eventListener;

import java.awt.Color;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eventListener.KeyEventEx.MyKeyEvent;

public class KeyCodeEx extends JFrame {
	JPanel pan;
	JLabel label;
	KeyCodeEx() {
		setTitle("버튼에 Mouse 이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		pan = new JPanel();
		pan.addKeyListener(new MyKeyEvent());
		setContentPane(pan);
		
		label = new JLabel("F1 누르면 초록");
		pan.add(label);
		setSize(300,200);
		setVisible(true);
		pan.requestFocus();
	}
	
	class MyKeyEvent extends KeyAdapter {
		public void keyPressed(java.awt.event.KeyEvent e) {
			label.setText(e.getKeyText(e.getKeyCode())+" 키 누름.");
			if (e.getKeyText(e.getKeyCode()).equals("F1")) {
				pan.setBackground(Color.GREEN);
			} else if (e.getKeyChar() == '%') {
				pan.setBackground(Color.yellow);
			}
		}
	}
	
	public static void main(String[] args) {
		new KeyCodeEx();
	}
}
