package jSlider;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FirstSileder extends JFrame {
	JSlider[] sl = new JSlider[3];
	JLabel result;
	
	FirstSileder() {
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		for (int i = 0; i < sl.length; i++) {
			
			sl[i] = new JSlider(0,255);
			sl[i].setPaintLabels(true);//숫자
//			sl[i].setPaintTrack(true);//기본 true bar
			sl[i].setPaintTicks(true);//눈금
			sl[i].setMajorTickSpacing(50);//숫자단위
			sl[i].setMinorTickSpacing(10);//눈금단위
			
			add(sl[i]);
			//체인지 이벤트 넣기
			sl[i].addChangeListener(new ChangeListenerEx());
		}
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		//텍스트와 배경색
		result = new JLabel("     SLIDER EXAMPLE     ");
		result.setBackground(Color.YELLOW);
		result.setOpaque(true);
		add(result);
		
		JLabel label = new JLabel("안녕하시오리까오이누니우지우지우지");
		label.setForeground(Color.red);
		add(label);
		
		setSize(300,300);
		setVisible(true);
	}
	
	class ChangeListenerEx implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			result.setBackground(new Color(sl[0].getValue(),sl[1].getValue(),sl[2].getValue()));
			
		}
		
	}
	
	public static void main(String[] args) {
		new FirstSileder();
	}
}
