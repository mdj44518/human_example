package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Employee;
import model.EmployeeComparator;
import model.Engineer;
import model.EngineerGrade;
import model.TempEmployee;

public class EmployeeTest {

	Employee[] e;
	Scanner scan;
	
	@Before
	public void setup() {
		System.out.println("setup() was called...");
		File file = new File("input.txt");
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e = new Employee[5];
		int idx = 0;
		while (true) {
			String line = scan.nextLine();
			if (line.length() == 0) {
				break;
			}
			String[] tokens = line.split(",");
			//System.out.println(Arrays.toString(tokens));
			e[idx] = makeEmployee(tokens);
			idx++;
		}
	}
	
	@After
	public void tearDown() {
		scan.close();
		System.out.println("tearDown() was called...");
	}
	
	// Employee객체를 배열에 담아 Arrays.sort()를 통해 정렬
	@Test
	public void testEmployeeArraySort() {
		System.out.println(Arrays.toString(e));
		Employee[] answer = new Employee[5];
		answer[0] = e[4];
		answer[1] = e[0];
		answer[2] = e[1];
		answer[3] = e[2];
		answer[4] = e[3];
		
		Arrays.sort(e);
		
		assertArrayEquals(answer, e);
	}
	
	@Test
	public void testEmployeeArraySortComparator() {
		Employee[] answer = new Employee[5];
		answer[0] = e[0];
		answer[1] = e[2];
		answer[2] = e[4];
		answer[3] = e[1];
		answer[4] = e[3];
		
		Arrays.sort(e, new EmployeeComparator());
		
		assertArrayEquals(answer, e);
	}
	
	@Test
	public void testEmployeeAnnualSalary() {
		long sal = (long)((e[0].getSalary() * 12) * (1 + 0.03));
		assertEquals(sal, e[0].getAnualSalary());
		assertEquals(10_000_000, e[1].getAnualSalary());
	}
	
	public Employee makeEmployee(String[] tokens) {
		Employee result = null;
		if (tokens[4].equalsIgnoreCase("eng") ) {
			result = new Engineer(tokens[0], tokens[2]);
			result.setAge(Integer.parseInt(tokens[1]));
			result.setSalary(Long.parseLong(tokens[3]));
			((Engineer)result).setSkill(tokens[5]);
			((Engineer)result).setGrade(EngineerGrade.valueOf(tokens[6].toUpperCase()));
		} else {
			result = new TempEmployee(tokens[0], tokens[2]);
			result.setAge(Integer.parseInt(tokens[1]));
			result.setSalary(Long.parseLong(tokens[3]));
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				cal.setTime(sdf.parse(tokens[5]));
				((TempEmployee)result).setFireDate(cal);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((TempEmployee)result).setDeptName(tokens[6]);
		}
		return result;
	}

}
