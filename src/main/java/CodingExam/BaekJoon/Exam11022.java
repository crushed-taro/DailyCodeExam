package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam11022 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int A = 0;
        int B = 0;
        for(int i = 1; i < num + 1; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            System.out.println("Case #" + i + ": " + A + " + " + B + " = " + (A + B));
        }
    }
}