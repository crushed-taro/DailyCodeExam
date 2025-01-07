package CodingExam.BaekJoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exam2346 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int move = sc.nextInt();
            deque.offer(new int[] { i, move });
        }

        StringBuilder result = new StringBuilder();

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            result.append(current[0]).append(" ");
            int steps = current[1];

            if (deque.isEmpty()) {
                break;
            }

            if (steps > 0) {
                for (int i = 0; i < steps - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(steps); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(result.toString().trim());
    }

}
