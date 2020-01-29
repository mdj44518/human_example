package junit_tutorial;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyJUnitDemo {

	@Test
	public void test() {
		MyDemo d = new MyDemo("ABC");
		
		String result = d.reverse();
		
		assertEquals("CBA", result);
		d.setMsg("123 abc");
		assertEquals("cba 321", d.reverse());
	}

}
