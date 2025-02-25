package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2447 {

    static char arr[][];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        arr = new char[N][N];

        makeStar(0, 0, N, false);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stringBuilder.append(arr[i][j]);
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder.toString());
    }

    public static void makeStar(int x, int y, int N, boolean blank) {

        if(blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i+=size) {
            for (int j = y; j < y + N; j+=size) {
                count++;

                if(count == 5) {
                    makeStar(i, j, size, true);
                } else {
                    makeStar(i, j, size, false);
                }
            }
        }
    }
}
