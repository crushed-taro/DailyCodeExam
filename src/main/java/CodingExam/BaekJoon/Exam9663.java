package CodingExam.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Exam9663 {

    public static int N;
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N];

        dfs(0);
        System.out.println(count);

        bufferedReader.close();
    }

    public static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {

            arr[depth] = i;
            if (possible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) {

            if (arr[i] == arr[col]) {
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }

}
