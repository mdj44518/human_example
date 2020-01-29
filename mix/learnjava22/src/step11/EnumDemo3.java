package step11;

public class EnumDemo3 {

	public enum Week {
		SUNDAY(0),
		MONDAY(1),
		TUESDAY(2),
		WEDNESDAY(3),
		THURSDAY(4),
		FRIDAY(5),
		SATURDAY(6);
		
		private int value;
		
		private Week(int value) {
			this.value = value;
		}

		public Week nextDay() {
			int target = value == 6 ? 0 : value + 1;
			for (Week w : Week.values()) {	
				if (w.value == target) {
					return w;
				}
			}
			
			return this;
		}
	}
	
	public static void main(String[] args) {
		Week w = Week.valueOf("SATURDAY");
		
		System.out.println(w);
		System.out.println(w.nextDay());
	}

}


