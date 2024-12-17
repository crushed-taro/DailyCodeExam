package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10813 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nRoom = new int[N];
        int M = sc.nextInt();

        for(int i = 0; i < nRoom.length; i++) {
            nRoom[i] = i + 1;
        }

        while (M-- > 0) {

            int I = sc.nextInt();
            int J = sc.nextInt();
            int temp;

            temp = nRoom[I - 1];
            nRoom[I - 1] = nRoom[J - 1];
            nRoom[J - 1] = temp;

        }
        for(int i : nRoom) {
            System.out.print(i + " ");
        }
    }
}
