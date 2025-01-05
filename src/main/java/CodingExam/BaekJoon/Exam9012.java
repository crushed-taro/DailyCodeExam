package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String str = bufferedReader.readLine();
            int length = str.length();

            for (int j = 0; j < length; j++) {
                char ch = str.charAt(j);

                if(ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) {
                        stack.push(ch);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();

        }

    }

}
