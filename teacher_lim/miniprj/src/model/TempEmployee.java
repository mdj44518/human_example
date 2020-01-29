package model;

import java.util.Calendar;
import java.util.Date;

public class TempEmployee extends Employee{
	private Calendar fireDate;
	private String deptName;
	
	public TempEmployee(String name, String ssn) {
		super(name, ssn);
	}

	@Override
	public long getAnualSalary() {
		int remain = calcRemainingMonth();
		
		if (remain >= 12) {
			return getSalary() * 12;
		} else {
			return remain * getSalary();
		}
	}
	
	// 오늘부터 계약종료일까지의 개월수
	// 2019 4
	// 2020 3 --> 2019 3 + 12
	// 11월
	// 0년
	private int calcRemainingMonth() {
		// 오늘
		Calendar today = Calendar.getInstance();
		int todayYear = today.get(Calendar.YEAR);
		int todayMonth = today.get(Calendar.MONTH);
		
		int fireYear = fireDate.get(Calendar.YEAR);
		int fireMonth = fireDate.get(Calendar.MONTH);
		
		int monthDiff = fireMonth - todayMonth;
		if (monthDiff < 0) {
			fireYear--;
			monthDiff += 12;
		}
		int yearDiff = fireYear - todayYear;
		if (yearDiff < 0) {
			return 0;
		}
		
		return yearDiff * 12 + monthDiff;
	}

	public Calendar getFireDate() {
		return fireDate;
	}

	public void setFireDate(Calendar fireDate) {
		this.fireDate = fireDate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
