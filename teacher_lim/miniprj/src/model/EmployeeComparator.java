package model;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1 instanceof Engineer && o2 instanceof Engineer) {
			Engineer e1 = (Engineer) o1;
			Engineer e2 = (Engineer) o2;
			
			return (int)(1000 * (e1.getGrade().getIncentiveRate() - e2.getGrade().getIncentiveRate()));
		} else if (o1 instanceof Engineer && o2 instanceof TempEmployee) {
			return -1;
		} else if (o1 instanceof TempEmployee && o2 instanceof Engineer) {
			return 1;
		} else if (o1 instanceof TempEmployee && o2 instanceof TempEmployee) {
			TempEmployee e1 = (TempEmployee) o1;
			TempEmployee e2 = (TempEmployee) o2;
			
			if (e1.getFireDate().before(e2.getFireDate())) {
				return -1;
			} else if (e1.getFireDate().equals(e2.getFireDate())) {
				return 0;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
	
}
