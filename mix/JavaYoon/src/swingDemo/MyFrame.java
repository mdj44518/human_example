package swingDemo;

import javax.swing.JFrame;

public class MyFrame {

	public static void main(String[] args) {
//		MyFrame mf = new MyFrame();
		
		JFrame j = new JFrame();
		j.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.setSize(300,300);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.setTitle("첫번째 프레임");
		

	}

}
