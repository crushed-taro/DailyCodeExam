package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11653 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        bufferedReader.close();

        if(num == 1) return;

        for(int i = 2; i <= num; i++) {
            while(num % i == 0) {
                num /= i;
                stringBuilder.append(i).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }

}
