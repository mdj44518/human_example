package quiz4_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

class asdfa {

   public static void main(String[] args) {
      Vector<Word> v = new Vector<Word>();
      v.add(new Word("love", "사랑"));
      v.add(new Word("animal", "동물"));
      v.add(new Word("bear", "곰"));
      v.add(new Word("painting", "그림"));
      v.add(new Word("eye", "눈"));
      v.add(new Word("picture", "사진"));
      v.add(new Word("society", "사회"));
      v.add(new Word("human", "인간"));
      v.add(new Word("emotion", "감정"));
      v.add(new Word("honey", "꿀"));
       v.add(new Word("dall", "인형"));
       v.add(new Word("fault", "오류"));
       v.add(new Word("example", "보기"));
       v.add(new Word("statue", "조각상"));
      
      System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
      System.out.println("현재 "+ v.size() + "개의 단어가 들어 있습니다.");

      Iterator<Word> it = v.iterator();
      
      Word quiz = v.get((int)(Math.random() * v.size() ));
      System.out.println( quiz.eng+ "? ");
      String[] word = new String[4];
      word[0] = quiz.kor;
      System.out.println("정답~~" + word[0]);
      
      // 랜덤 3개 배열에 집어넣기
      for(int i = 1; i<4; i++) {
         word[i] = v.get((int)(Math.random() * v.size() )).kor;
         for(int j = 0; j < i; j++) {
            if(word[i] == word[j] || word[0] == word[i])
               i--;
         }
      }
      
      System.out.println(Arrays.toString(word));
      Arrays.sort(word);
      for(int i = 0; i < 4; i++) {
         int idx = (int) (Math.random() *4);
         System.out.print(idx);
         System.out.println("(" + i + ")" + word[i] + " ");
      }
      int idx = 1;
      while(!(idx == 4)){
         String n = v.get((int)(Math.random() * v.size() )).kor;
         System.out.print("(" + idx + ")" + n + " ");
         idx++;
      }
      
      Scanner scan = new Scanner(System.in);
      System.out.print(":> ");
      int result = scan.nextInt();
      
   }

}