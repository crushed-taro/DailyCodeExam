package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam14215 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        int[] sort = {A, B, C};

        Arrays.sort(sort);

        if(sort[0] + sort[1] > sort[2]) {
            System.out.println(A + B + C);
        } else {
            System.out.println((sort[0] + sort[1]) * 2 - 1);
        }

        bufferedReader.close();

    }

}
