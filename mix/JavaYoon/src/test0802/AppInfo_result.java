package test0802;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class AppInfo_result extends JFrame {
	
	public AppInfo_result() {
		setTitle("GridLayout Sample"); // 프레임의 타이틀  달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램 종료
		GridLayout grid = new GridLayout(3, 2); // 4x2 격자의 GridLayout 배치관리자 생성
		grid.setVgap(5); //격자 사이의 수직 간격을 5 픽셀로 설정
		
		Container c = getContentPane();
		c.setLayout(grid); // grid를 컨텐트팬의 배치관리자로 지정
		
		JTextField name = new JTextField();
		JTextField sNum = new JTextField();
		JButton submitButton = new JButton("조회");
		JButton removeButton = new JButton("취소");
		
		ActionListener listener = (e) -> {
			System.out.println(name.getText().equals(""));
			String pickText = ((JButton)(e.getSource())).getText();
			if (pickText.equals("조회")) {  // 조회 버튼 눌렀을시.
				String msg = "";
				if (name.getText().length() == 0) {
					msg = "이름입력바람";
				} else if (sNum.getText().length() == 0) {
					msg =  "학번입력바람";
				} else {
					msg = "조회완료";
				}
				JOptionPane.showMessageDialog(getContentPane(), msg);
			} else {  // 취소버튼 눌렀을시.
				name.setText("");
				sNum.setText("");
			}
		};
		
		submitButton.addActionListener(listener);
		removeButton.addActionListener(listener);
		
		c.add(new JLabel(" 이름"));
		c.add(name);
		c.add(new JLabel(" 학번"));
		c.add(sNum);
		c.add(submitButton);
		c.add(removeButton);
		
		setSize(300, 200);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new AppInfo_result();
	}
}
