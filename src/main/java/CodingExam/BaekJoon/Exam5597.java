package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam5597 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] studentArr = new int[31];

        int studen;
        for(int i = 1; i < studentArr.length - 2; i++) {
            studen = sc.nextInt();
            studentArr[studen] = 1;
        }

        for(int i = 1; i < studentArr.length; i++) {
            if(studentArr[i] != 1) {
                System.out.println(i);
            }
        }
    }
}
