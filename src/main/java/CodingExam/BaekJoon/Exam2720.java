package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2720 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        int[] tmp = new int[4];

        for(int i = 0; i < num; i++) {
            int change = sc.nextInt();
            tmp[0] = change / 25;
            change = change % 25;

            System.out.print(tmp[0] + " ");

            tmp[1] = change / 10;
            change = change % 10;

            System.out.print(tmp[1] + " ");

            tmp[2] = change / 5;
            change = change % 5;

            System.out.print(tmp[2] + " ");

            tmp[3] = change / 1;
            change = change % 1;

            System.out.println(tmp[3]);
        }
    }
}
