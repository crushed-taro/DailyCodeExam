package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam11720 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        String input = sc.nextLine();

        int total = 0;

        for(int i = 0; i < num; i++) {
            total += Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        System.out.println(total);

    }
}
