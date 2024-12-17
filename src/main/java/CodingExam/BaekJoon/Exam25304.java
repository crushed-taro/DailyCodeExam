package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam25304 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt(); // 총 값
        int total = sc.nextInt(); // 총 개수

        int[] arrValue = new int[total];
        int[] arrTotal = new int[total];
        for (int i = 0; i < total; i++) {
            arrValue[i] = sc.nextInt();
            arrTotal[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < total; i++) {
            sum += arrValue[i] * arrTotal[i];
        }

        System.out.println("sum = " + sum);
        if(value == sum)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
