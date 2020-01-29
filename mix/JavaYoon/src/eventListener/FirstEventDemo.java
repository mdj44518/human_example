package eventListener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FirstEventDemo extends JFrame {
	
	FirstEventDemo() {
		setTitle("이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		
//		JButton btn = new JButton("Action");
//		MyActionListener listener = new MyActionListener();
//		btn.addActionListener(listener);
		
		
		JButton btn = new JButton("Action");
		btn.addActionListener((e)->{
			if (btn.getText().equals("Action")) {
				btn.setText("액션");
			} else {
				btn.setText("Action");
			}
		});
		
		add(btn);
		setSize(300, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FirstEventDemo();
	}
}

//class MyActionListener implements ActionListener {
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton b = (JButton)e.getSource();
//		if (b.getText().equals("Action")) {
//			b.setText("액션");
//		} else {
//			b.setText("Action");
//		}
//		
//	}
//	
//}
