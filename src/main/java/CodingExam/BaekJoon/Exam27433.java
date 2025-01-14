package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam27433 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(factorial(N));

    }

    public static long factorial(int N) {
        if (N == 0) return 1;
        else return N * factorial(N - 1);
    }

}
