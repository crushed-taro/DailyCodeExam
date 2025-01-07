package CodingExam.BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        boolean isFirst = true;
        while(!queue.isEmpty()) {

            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            if(isFirst) {
                stringBuilder.append("<" + queue.poll());
                isFirst = false;
            } else {
                stringBuilder.append(", " + queue.poll());
            }

        }
        stringBuilder.append(">");

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }

}
