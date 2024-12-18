package CodingExam.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Exam3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer;

        int[] x_input = new int[3];
        int[] y_input = new int[3];

        for(int i = 0; i < 3; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            x_input[i] = Integer.parseInt(stringTokenizer.nextToken());
            y_input[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        bufferedReader.close();

        int x = 0;
        int y = 0;

        if(x_input[0] == x_input[1]) {
            x = x_input[2];
        } else {
            x = (x_input[0] == x_input[2]) ? (x_input[1]) : (x_input[0]);
        }

        if(y_input[0] == y_input[1]) {
            y = y_input[2];
        } else {
            y = (y_input[0] == y_input[2]) ? (y_input[1]) : (y_input[0]);
        }

        bufferedWriter.write(x + " " + y);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
