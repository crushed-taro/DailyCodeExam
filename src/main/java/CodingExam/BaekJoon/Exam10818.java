package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10818 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] inputNum = new int[num];
        for(int i = 0; i < num; i++) {
            inputNum[i] = sc.nextInt();
        }

        int min = 1000000;
        int max = -1000000;
        for(int i = 0; i < num; i++) {
            if(min > inputNum[i]) {
                min = inputNum[i];
            }
            if(max < inputNum[i]) {
                max = inputNum[i];
            }
        }

//        for(int i = 0; i < num; i++) {
//        }

        System.out.println(min);
        System.out.println(max);
    }
}
