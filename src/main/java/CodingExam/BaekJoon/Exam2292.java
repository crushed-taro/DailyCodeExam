package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2292 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int N = Integer.parseInt(br.readLine());

            int count = 1;
            int range = 2;

            if(N == 1) {
                System.out.println(count);
            } else {
                while(range <= N) {
                    range = range + (6 * count);
                    count++;
                }
                System.out.println(count);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
