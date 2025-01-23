package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] tmp = new int[N + 1];
        tmp[0] = 0;

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            tmp[i] = tmp[i - 1] + Integer.parseInt(st.nextToken());
        }

        int max = tmp[K] - tmp[0];

        for (int i = K; i <= N; i++) {
            max = Math.max(max, tmp[i] - tmp[i - K]);
        }

        System.out.println(max);

    }

}
