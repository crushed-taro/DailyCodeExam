package CodingExam.BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Exam10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[]arrays = new int[N];

        for(int i = 0; i < N; i++) {
            arrays[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        Arrays.sort(arrays);

        for(int i = 0; i < N; i++) {
            bw.write(arrays[i] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
