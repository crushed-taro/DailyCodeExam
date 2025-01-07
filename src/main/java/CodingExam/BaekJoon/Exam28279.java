package CodingExam.BaekJoon;

import java.io.*;
import java.util.*;

public class Exam28279 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int input = Integer.parseInt(stringTokenizer.nextToken());

            switch (input) {
                case 1:
                    deque.offerFirst(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case 2:
                    deque.offerLast(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case 3:
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(deque.pollFirst() + "\n");
                    }
                    break;
                case 4:
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(deque.pollLast() + "\n");
                    }
                    break;
                case 5:
                    stringBuilder.append(deque.size() + "\n");
                    break;
                case 6:
                    if(deque.isEmpty()) {
                        stringBuilder.append("1" + "\n");
                    } else {
                        stringBuilder.append("0" + "\n");
                    }
                    break;
                case 7:
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(deque.peekFirst() + "\n");
                    }
                    break;
                case 8:
                    if(deque.isEmpty()) {
                        stringBuilder.append("-1" + "\n");
                    } else {
                        stringBuilder.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();

    }

}
