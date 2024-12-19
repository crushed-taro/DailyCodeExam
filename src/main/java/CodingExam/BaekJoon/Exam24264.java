package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam24264 {

    public static void main(String[] args) throws IOException {

        // O(n^2)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine());
        bufferedReader.close();

        System.out.println(n * n);
        System.out.println(2);

    }
}
