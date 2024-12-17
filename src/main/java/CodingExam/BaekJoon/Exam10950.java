package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10950 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int A = 0;
        int B = 0;
        for (int i = 0; i < num; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            System.out.println(A + B);
        }
    }
}
