package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10810 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] num = new int[sc.nextInt()];
        int mum = sc.nextInt();

        for(int i = 0; i < mum; i++) {
            int I = sc.nextInt();
            int J = sc.nextInt();
            int K = sc.nextInt();

            for(int j = I - 1; j < J; j++) {
                num[j] = K;
            }
        }

        for(int i = 0; i < num.length; i++) {
            System.out.println(num[i] + " ");
        }

    }
}