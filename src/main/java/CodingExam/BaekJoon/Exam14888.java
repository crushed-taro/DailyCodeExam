package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam14888 {

    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        number = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void dfs(int num, int index) {

        if (index == N) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;

                switch (i) {

                    case 0:
                        dfs(num + number[index], index + 1);
                        break;
                    case 1:
                        dfs(num - number[index], index + 1);
                        break;
                    case 2:
                        dfs(num * number[index], index + 1);
                        break;
                    case 3:
                        dfs(num / number[index], index + 1);
                        break;

                }
                operator[i]++;
            }
        }

    }


}
