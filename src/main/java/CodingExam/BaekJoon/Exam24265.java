package CodingExam.BaekJoon;

import java.io.*;

public class Exam24265 {
    public static void main(String[] args) throws IOException {

        // O(n^2)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        bw.write(n*(n-1)/2 + "\n" + 2);
        bw.flush();
        bw.close();
    }
}