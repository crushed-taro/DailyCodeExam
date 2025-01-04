package CodingExam.BaekJoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam28278 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int input = Integer.parseInt(stringTokenizer.nextToken());

            switch (input) {
                case 1:
                    stack.push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case 2:
                    if(stack.isEmpty()) {
                        str.append(-1).append("\n");
                    } else {
                        str.append(stack.pop()).append("\n");
                    }
                    break;
                case 3:
                    str.append(stack.size()).append("\n");
                    break;
                case 4:
                    if(stack.isEmpty()) {
                        str.append(1).append("\n");
                    } else {
                        str.append(0).append("\n");
                    }
                    break;
                case 5:
                    if (stack.isEmpty())
                        str.append(-1).append("\n");
                    else
                        str.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.print(str);
        bufferedReader.close();
    }

}
