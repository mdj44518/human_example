package step14;

public class Student implements Comparable  {
	private String name;
	private int age;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// 내가 크면 양수를
	// 같으면 0
	// 작으면 음수를 리턴
	/*
	@Override
	public int compareTo(Object o) {
		// 입력되는 객체가 Student 타입인가?
		if (o instanceof Student) {
//			if (this.age > ((Student)o).age) {
//				return 1;
//			} else if (this.age == ((Student)o).age) {
//				return 0;
//			} else {
//				return -1;
//			}
			return this.age - ((Student)o).age;
		} else {
			return -1;
		}
	}
	*/
	
	/*
	 * string의 모든 캐릭터간을 비교
	 * 
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student your = (Student)o;
			
			return name.compareTo(your.name);
			/*
			int yourIdx = 0;
			for (int i = 0; i < this.name.length(); i++) {
				int diff = name.charAt(i) - your.name.charAt(yourIdx);
				yourIdx++;
				
				if (diff != 0) {
					return diff;
				}
				
				if (yourIdx >= your.name.length()) {// 상대방의 이름 길이의 마지막
					return 0;
				} 	
			}
			*/
		} else {
			return -1;
		}
		
		// 상대방의 이름의 길이가 더 길때,
		//return 1;
	}
}
