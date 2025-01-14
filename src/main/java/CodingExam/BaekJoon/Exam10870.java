package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam10870 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(fibonacci(N));

    }

    public static long fibonacci(int N) {
        if(N < 2) return N;
        return fibonacci(N - 1) + fibonacci(N - 2);
    }

}
