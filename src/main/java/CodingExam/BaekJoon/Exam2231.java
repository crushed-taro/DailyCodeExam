package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Exam2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int num = Integer.parseInt(stringTokenizer.nextToken());

        int result = 0;

        for(int i = 0; i < num; i++) {
            int sum = 0;
            int number = i;

            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == num) {
                result = i;
                break;
            }
        }

        System.out.println(result);


    }

}
