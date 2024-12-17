package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2566 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arrNum = new int[9][9];

//        System.out.println(arrNum.length);
//        System.out.println(arrNum[0].length);

        for(int i = 0; i < arrNum.length; i++){
            for(int j = 0; j < arrNum[i].length; j++) {
                arrNum[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int row = 0;
        int col = 0;

        for(int i = 0; i < arrNum.length; i++) {
            for (int j = 0; j < arrNum[i].length; j++) {
                if(arrNum[i][j] > max) {
                    max = arrNum[i][j];
                    col = i;
                    row = j;
                }
//                System.out.print(arrNum[i][j] + " ");
            }
//            System.out.println();
        }

        System.out.println(max);
        System.out.println((col + 1) + " " + (row + 1));
    }
}
