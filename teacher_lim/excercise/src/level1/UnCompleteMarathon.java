package level1;

public class UnCompleteMarathon {

	public static void main(String[] args) {
		String[] p = {"0", "1", "1", "2", "2", "3", "4"};
		String[] k = {"0", "1","3", "2", "2", "4", "1"};

		String name = findUnComp(p, k);
		System.out.println("미완주 선수: " + name);
	}
	
	// 완주하지 못한 선수의 이름을 찾는 메소드
	// 입력: 참가자의 이름배열, 완주자의 이름배열
	// 리턴: 완주하지 못한 선수이름
	public static String findUnComp(String[] part, String[] comp) {
		// 새로운 배열 newComp에 입력받은 comp배렬을 카피
		String[] newComp = new String[comp.length];
		System.arraycopy(comp, 0, newComp, 0, comp.length);
		
		boolean isFound = false;
		for (int i = 0; i < part.length; i++) {
			isFound = false;
			for (int j = 0; j < newComp.length; j++) {
				if (part[i].equals(newComp[j])) {
					isFound = true;
					newComp[j] = null;
					break;
				}
			}
			
			if (isFound != true) {
				return part[i];
			}
		}
		// 
		return null;
	}
}






