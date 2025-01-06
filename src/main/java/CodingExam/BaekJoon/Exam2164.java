package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Exam2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        for (int i = 1; i < N; i++) {
            queue.poll();

            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());

    }

}
