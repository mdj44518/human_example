package eventListener;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eventListener.KeyCodeEx.MyKeyEvent;

public class WASD_Move extends JFrame {
	JLabel label;
	final int FLYING_UNIT = 10;
	
	WASD_Move() {
		setTitle("상하좌우 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.addKeyListener(new MyKeyEvent());
		setContentPane(pan);
		
		label = new JLabel("HELLO");
		label.setSize(80, 40);
		label.setLocation(50, 50);
		
		pan.add(label);
		
		setSize(600,400);
		setVisible(true);
		pan.requestFocus();
	}
	
	class MyKeyEvent extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println("rkrkrk");
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case 38:
				label.setLocation(label.getX(), label.getY()-FLYING_UNIT);
				break;
			case 40:
				label.setLocation(label.getX(), label.getY()+FLYING_UNIT);
				break;
			case 37:
				label.setLocation(label.getX()-FLYING_UNIT, label.getY());
				break;
			case 39:
				label.setLocation(label.getX()+FLYING_UNIT, label.getY());
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new WASD_Move();
	}
}
