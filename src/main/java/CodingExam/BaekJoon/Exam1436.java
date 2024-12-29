package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1436 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int count = 1;
        int number = 666;

        while (count != N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                count++;
            }
        }
        System.out.println(number);

    }

}