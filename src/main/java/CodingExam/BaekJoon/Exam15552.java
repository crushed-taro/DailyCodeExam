package CodingExam.BaekJoon;

import java.io.*;

public class Exam15552 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기

        int A = 0;
        int B = 0;
        for(int i = 0; i < num; i++) {
            A = Integer.parseInt(br.readLine());
            B = Integer.parseInt(br.readLine());
            bw.write(A + B);
        }
        bw.flush();

        br.close();
        bw.close();

    }
}

