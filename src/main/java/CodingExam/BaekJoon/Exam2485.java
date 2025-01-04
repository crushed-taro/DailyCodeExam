package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2485 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] gaps = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gaps[i] = arr[i + 1] - arr[i];
        }

        int gcd = gaps[0];
        for (int i = 1; i < gaps.length; i++) {
            gcd = Euclidean(gcd, gaps[i]);
        }

        int result = 0;
        for (int gap : gaps) {
            result += (gap / gcd) - 1;
        }

        System.out.println(result);

    }

    // 참고 : https://namu.wiki/w/유클리드%20호제법
    public static int Euclidean(int a, int b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }

}
