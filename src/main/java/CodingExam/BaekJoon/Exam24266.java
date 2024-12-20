package CodingExam.BaekJoon;

import java.io.*;

public class Exam24266 {

    public static void main(String[] args) throws IOException {

        // O(n^3)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        br.close();

        bw.write(n*n*n + "\n" + 3);
        bw.flush();
        bw.close();
    }

}
