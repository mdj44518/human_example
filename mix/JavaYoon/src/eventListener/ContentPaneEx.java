package eventListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ContentPaneEx extends JFrame {
	JButton ok=new JButton("Event Testing!");
	JButton cancel=new JButton("cancel");
	JLabel label=new JLabel();
	ContentPaneEx(){
		setTitle("Button EX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane=getContentPane();
		
		contentPane.setLayout(new FlowLayout());
		contentPane.add(ok);
		contentPane.add(cancel);
		contentPane.add(label);
		
//		MyListener listener=new MyListener(label); //1.이벤트 리스너 객체 생성 -- MyListner 클래스 참조를 위해 소스이동
		ok.addActionListener((e)-> {label.setText("이벤트 발생확인!");}); // 생성된 이벤트 리스너를 이벤트가 적용되게 이벤트 등록한다.(중요)
			
		setSize(350,150);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ContentPaneEx();
	}

}


