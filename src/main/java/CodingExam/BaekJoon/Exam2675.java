package CodingExam.BaekJoon;

import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Exam2675 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();

        for(int k = 0; k < caseNum; k++) {
            int num = sc.nextInt();
            String input = sc.next();

            for(int i = 0; i < input.length(); i++) {
                for(int j = 0; j < num; j++) {
                    System.out.print(input.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
