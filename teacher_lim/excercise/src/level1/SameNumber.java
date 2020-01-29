package level1;

import java.util.Arrays;

public class SameNumber {

	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,0};
		
		int[] b = solution(arr);
		
		System.out.println(Arrays.toString(b));
	}

	public static int[] solution(int[] arr) {
		int[] answer ;
        int count = 1 ;

        // 배열에서 연속되지 않은 정수가 몇개인지?
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]) { 
                count++;
            }
        }
        //System.out.println(count);
        answer = new int[count];

        // 입력받은 배열에서 연속적인 중복 정수는 한번만
        // answer 배열로 복사
        count=1;                                        //�����ִ� ī���� ������ �ٽ� 1�� �ʱ�ȭ�� �ٸ������̸����� �ʱ��ص���
        answer[0] = arr[0];                            //0��°�� ������ �ʾ���
        
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]){
                answer[count] = arr[i];
                count++;
  //              System.out.println(count);
            }
        }

  //      System.out.println(Arrays.toString(answer));
        return answer;

    }
	
	
	
}
