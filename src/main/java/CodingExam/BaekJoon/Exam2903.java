package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2903 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int num = sc.nextInt();

        System.out.println((int)Math.pow(Math.pow(2, num) +1, 2));
    }
}
