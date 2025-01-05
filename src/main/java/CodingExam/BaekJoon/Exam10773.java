package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(bufferedReader.readLine());

            if(K == 0) {
                stack.pop();
            } else {
                stack.push(K);
            }
        }


        System.out.println(stack.stream().mapToInt(Integer::intValue).sum());


    }

}
