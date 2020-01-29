package step09.exercise;

import java.util.Arrays;

/*
 * 정수를 저장하는 클라스
 * 배열처럼 처음 객체를 생성할때 사이즈를 정하지 않아도 되고,
 * 이후에 사이즈가 부족하면 자동으로 사이즈가 증가되어 계속적으로
 * 정수를 저장할 수 있는 구조체
 * 
 */
public class IntBox {

	// 속성
	private final static int INITIAL_SIZE = 3;
	private final static int INCREASE_SIZE = 10;
	private Integer[] storage;
	private int nextIndex;
	
	public IntBox() {
		storage = new Integer[INITIAL_SIZE];
		
		System.out.println(Arrays.toString(storage));
		nextIndex = 0;
	}
	
	// 정수를 저장(삽입)
	public void add(int val) {
		storage[nextIndex] = val;
		nextIndex++;

		Integer[] newStorage;
		if (nextIndex == storage.length) { // 배열이 꽉 찼을때,
			newStorage = new Integer[storage.length + INCREASE_SIZE];
			System.arraycopy(storage, 0, newStorage, 0, storage.length);
			
			storage = newStorage;
		}
	}
	
	public int size() {
		return nextIndex;
	}
	
	// 해당 인덱스에 저장된 값을 얻아가는
	public Integer get(int index) {
		if (index < nextIndex) {
			return storage[index];
		} else {
			return null;
		}	
	}
	
	// 입력받은 정수값을 삭제하는 기능
	// 인덱스가 낮은 곳에 저장되어있는 val값을 삭제
	// 삭제 후, 인덱스 조정
	// 삭제가 성공하면 true
	public boolean remove(int val) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i] == val) {
				System.arraycopy(storage, i+1, storage, i, 
						storage.length - i - 1);
				nextIndex--;
				return true;
			}
		}
		
		return false;
	}
	
	// 입력받은 정수값을 입력받은 index에서 끝까지 중에서
	// 찾아 해당 인덱스를 리턴
	public int search(int val, int index) {
		for (int i = index; i < storage.length; i++) {
			if (storage[i] == val) {
				return i;
			}
		}
		
		return -1;
	}
}


