package junit_tutorial;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testStudentName() {
		Student s = new Student("홍길동");
		
		assertEquals("홍", s.getLastName());
		assertEquals("길동", s.getFirstName());
	}
	
	@Test
	public void testStudentScore() {
		fail("Not yet implemented");
	}

}
