package eventListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.MessageFormat;

import javax.swing.*;

public class MouseListenerAllEx extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la;
	
	MouseListenerAllEx() {
		setTitle("MouseListener와 MouseMOtionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener2());
		contentPane.addMouseMotionListener(new MyMouseListener2());
		
		la = new JLabel("처음");
		contentPane.add(la);
		
		setSize(500,300);
		setVisible(true);
	}
	
	class MyMouseListener2 implements MouseListener, MouseMotionListener {
		static final String FORMOTS = "{0} ({1}, {2})";
		@Override
		public void mouseDragged(MouseEvent e) {
			String eName = "MouseDragged";
			la.setText(MessageFormat.format(FORMOTS, eName, e.getX(), e.getY()));
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved("+e.getX()+","+e.getY()+")");
		}
		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed("+e.getX()+","+e.getY()+")");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseEntered(MouseEvent e) { //호버
			JPanel p = (JPanel)e.getSource();
			p.setBackground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) { //호버아닌 잡혔다 때었을때
			JPanel p = (JPanel)e.getSource();
			p.setBackground(Color.YELLOW);
		}
		@Override
		public void mouseClicked(MouseEvent e) {}
		
	}
	
	public static void main(String[] args) {
		new MouseListenerAllEx();
	}
	
}
