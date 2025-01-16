package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11729 {

    static StringBuilder stringBuilder = new StringBuilder();
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(stringBuilder.toString());

    }

    public static void hanoi(int n, int from, int mid, int to) {
        count++;

        if(n == 1) {
            stringBuilder.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, mid);
        stringBuilder.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, mid, from, to);
    }

}
