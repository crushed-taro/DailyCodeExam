package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam3003 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] piece = {1,1,2,2,2,8};

        String[] input = sc.nextLine().split(" ");


        for(int i = 0; i < piece.length; i++) {
            System.out.print(piece[i] - Integer.parseInt(input[i]) + " ");
        }

    }
}
