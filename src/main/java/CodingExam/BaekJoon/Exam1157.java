package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arrNum = new int[26];

        char[] input = sc.nextLine().toLowerCase().toCharArray(); //abccd

        for(int i = 0; i < input.length; i++) {
            arrNum[((int) input[i]) - 97]++;
        }

//        for(int i : arrNum) {
//            System.out.print(i);
//        }
//        System.out.println();

        int max = -1;
        char ch = '?';

        for(int i = 0; i < arrNum.length; i++) {
            if(arrNum[i] > max) {
                max = arrNum[i];
                ch = (char) (i + 97);
            } else if (max == arrNum[i]) {
                ch = '?';
            }
        }

        System.out.println(Character.toUpperCase(ch));

    }
}
