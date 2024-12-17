package CodingExam.BaekJoon;

import java.util.HashSet;
import java.util.Scanner;

public class Exam3052 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //중복되는 원소를 넣을 경우 하나만 저장한다. 즉, 중복원소를 허용하지 않는다.
        //HashSet 은 순서 개념이 없다. 따라서 Collections.sort() 메소드를 사용할 수 없다. 만약 정렬을 하고 싶다면 리스트로 변환 후 정렬해야한다.
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(int i = 0; i < 10; i++) {
            hashSet.add(sc.nextInt() % 42);
        }
        sc.close();
        System.out.println(hashSet.size());

    }
}
