package step10.exercise;

public class MainApp {

	public static void main(String[] args) {
		Student a = new Student("홍길동");
		a.setAge(10);
		Student b = new Student("홍길동");
		b.setAge(10);
		
		if (a.equals(b)) {
			System.out.println("같다");
		}
		
		Student[] s = new Student[4];
		
		s[0] = new LowStudent("홍길동");
		s[0].setAge(10);
		((LowStudent)s[0]).setSubject("국어", "수학");
		s[1] = new LowStudent("이자바");
		s[1].setAge(11);
		((LowStudent)s[1]).setSubject("사회", "역사");
		
		s[2] = new HighStudent("김똑똑");
		s[2].setAge(20);
		((HighStudent)s[2]).setClassNum(5);
		String[] subjects = {"Eng", "Math", "Hist", "Science", "Biology"};
		((HighStudent)s[2]).setSubject(subjects);
		s[3] = new HighStudent("박잘해", 4);
		s[3].setAge(21);
		subjects = new String[] {"EE400", "CS101", "HT100", "EN101"};
		((HighStudent)s[3]).setSubject(subjects);
		
		for (int i = 0; i < s.length; i++) {
			s[i].makeExam();
			String out = String.format("%s[%d]: %5.2f", 
					s[i].getName(), s[i].getAge(), s[i].getAvg());
			System.out.println(out);
		}
		
		System.out.println();
		for (int i = 0; i < s.length; i++) {
			s[i].reportScore();
		}
		
		
	}

}
