package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Exam2580 {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            for (int j = 0; j < 9; j++) {

                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

            }

        }

        sudoku(0, 0);

    }

    public static void sudoku(int row, int col) {

        if(col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if(row == 9) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {
                    stringBuilder.append(arr[i][j]).append(' ');
                }
                stringBuilder.append("\n");
            }

            System.out.println(stringBuilder);

            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);

    }
    public static boolean possibility(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }


}
