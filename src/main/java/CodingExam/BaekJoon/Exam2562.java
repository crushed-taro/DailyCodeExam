package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2562 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 9;

        int[] arrNum = new int[num];
        for(int i = 0; i < num; i++) {
            arrNum[i] = sc.nextInt();
        }

        int max = 0;
        int maxRoom = 0;
        for(int i = 0; i < num; i++) {
            if(max < arrNum[i]) {
                max = arrNum[i];
                maxRoom = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxRoom);
    }
}
