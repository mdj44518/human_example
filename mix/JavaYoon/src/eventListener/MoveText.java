package eventListener;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoveText extends JFrame {
	MoveText() {
		setTitle("마우스클릭에 움직이는 문자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Container con = getContentPane();
		
		JPanel pan = new JPanel();
		setContentPane(pan);
		pan.setLayout(null);
		
		JLabel label = new JLabel("움직인다");
		label.setSize(100, 40);
		pan.add(label);
		
		pan.addMouseListener(new MyMouseClick(label));
		
		
		setSize(600,400);
		setVisible(true);
	}
	
	class MyMouseClick extends MouseAdapter {
		JLabel label;
		MyMouseClick(JLabel label) {
			this.label = label;
		}

		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x,y);
		}
	}
	
	public static void main(String[] args) {
		new MoveText();
	}
}


