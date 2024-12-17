package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam9086 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        String[] input = new String[testCase];
        sc.nextLine();

        for(int i = 0; i < testCase; i++) {
            input[i] = sc.nextLine();
        }

        for(int i = 0; i < testCase; i++) {
            System.out.print(input[i].charAt(0));
            System.out.print(input[i].charAt(input[i].length() - 1));
            System.out.println();
        }
    }
}
