package CodingExam.BaekJoon;

import java.awt.event.InputEvent;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        StringTokenizer str;

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(bufferedReader.readLine());

            String input = str.nextToken();

            switch (input) {
                case "push":
                    queue.offer(Integer.parseInt(str.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(queue.poll() + "\n");
                    }
                    break;
                case "size":
                    stringBuilder.append(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        stringBuilder.append("1" + "\n");
                    } else {
                        stringBuilder.append("0" + "\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(queue.getLast() + "\n");
                    }
                    break;
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
