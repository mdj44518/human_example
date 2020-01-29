package eventListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEvent extends JFrame {

	MouseEvent() {
		setTitle("버튼에 Mouse 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("Mouse Event 테스트 버튼");
		btn.setBackground(Color.yellow);
		MyMouseListener mListenet = new MyMouseListener();
		btn.addMouseListener(mListenet);
		
		add(btn);
		
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEvent();
	}

}

class MyMouseListener implements MouseListener {

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.red);
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.yellow);
	}
	
}
