package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam12789 {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int start = 1;

        while(!queue.isEmpty()) {
            if(queue.peek() == start) {
                queue.poll();
                start++;
            } else if(!stack.isEmpty() && stack.peek() == start) {
                stack.pop();
                start++;
            } else {
                stack.push(queue.poll());
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() == start) {
                stack.pop();
                start++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");



    }

}
