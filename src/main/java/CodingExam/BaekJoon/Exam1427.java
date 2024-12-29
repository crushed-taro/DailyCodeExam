package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Exam1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String N = bufferedReader.readLine();
        bufferedReader.close();

        Integer[] arr = new Integer[N.length()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = N.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (Integer integer : arr) {
            System.out.print(integer);
        }

    }

}
