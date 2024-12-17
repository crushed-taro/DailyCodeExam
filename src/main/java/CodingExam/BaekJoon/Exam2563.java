package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2563 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[][] arrNum = new int[100][100];

        for(int i = 0; i < num; i++) {
            int firNum = sc.nextInt(); // X
            int secNum = sc.nextInt(); // Y

            for(int j = secNum; j < secNum + 10; j++) {
                for(int k = firNum; k < firNum + 10; k++) {
                    arrNum[j][k] = 1;
                }
            }
        }

        int total = 0;

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {

                total += arrNum[i][j];
//                System.out.print(arrNum[i][j]);
            }
        }
        System.out.println(total);
    }
}
