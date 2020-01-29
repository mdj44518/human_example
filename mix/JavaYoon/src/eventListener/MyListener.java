package eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MyListener implements ActionListener { //1. ActionListener 인터페이스를 상속받아서 actionPerformed를 구현
	JButton btn; // 이벤트 대상
	JLabel label;// 이벤트 결과가 반영될 대상
	public MyListener(/*JButton btn, */JLabel label) {
//		this.btn=btn;
		this.label=label;
	}
	@Override
	public void actionPerformed(ActionEvent e) {  //2. actionPerformed메소드 구현한다. ActionEvent e변수는 사용자의
		// TODO Auto-generated method stub        // 여러 행위적인 것을 의미(click,drag,doubleClick 등)
		btn=(JButton) e.getSource(); //3. 이벤트 객체를 찾아서 버튼에 적용시킨다.
		label.setText("이벤트 발생확인!");  // 4. 이벤트 발생 후 처리되는 작업을 작성
	}

}

