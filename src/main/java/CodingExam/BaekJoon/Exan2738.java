package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exan2738 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arrFirNum = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arrFirNum[i][j] = sc.nextInt();
            }
        }

        int[][] arrSecNum = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arrSecNum[i][j] = sc.nextInt();
            }
        }

        int[][] arrThrNum = new int[n][m];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrThrNum[i][j] = arrFirNum[i][j] + arrSecNum[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arrThrNum[i][j] + " ");
            }
            System.out.println();
        }

    }
}
