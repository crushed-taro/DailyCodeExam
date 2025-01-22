package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam15650 {

    public static int[] arr;
    public static boolean[] check;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[M];
        check = new boolean[N];
        btm(N, M, 0, 0);
        System.out.println(sb);

    }

    public static void btm(int N, int M, int depth, int start) {
        if (depth == M) {
            for (int k : arr) {
                sb.append(k).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i + 1;
                btm(N, M, depth + 1, i + 1);
                check[i] = false;
            }
        }
    }

}