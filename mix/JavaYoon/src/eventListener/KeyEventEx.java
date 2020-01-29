package eventListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

import javax.swing.*;

public class KeyEventEx extends JFrame {
	JLabel[] labels;
	
	KeyEventEx() {
		setTitle("버튼에 Mouse 이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel pan = new JPanel();
		setContentPane(pan);
		
		labels = new JLabel[3];
		labels[0] = new JLabel();
		labels[1] = new JLabel();
		labels[2] = new JLabel();
		pan.add(labels[0]);
		pan.add(labels[1]);
		pan.add(labels[2]);
		
		
		pan.addKeyListener(new MyKeyEvent());
		
		setSize(300,200);
		setVisible(true);
		pan.requestFocus();
	}
	
	class MyKeyEvent extends KeyAdapter {
		@Override
		public void keyPressed(java.awt.event.KeyEvent e) {
			labels[0].setText(e.getKeyChar()+"=캐릭터");
			labels[1].setText(e.getKeyCode()+"=코드");
			labels[2].setText(e.getKeyText(e.getKeyCode())+"=키이름");
		}
	}
	
	public static void main(String[] args) {
		new KeyEventEx();
	}
}
