package CodingExam.BaekJoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exam24511 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 4
        String[] flags = br.readLine().split(" "); // 0 1 1 0
        String[] nums = br.readLine().split(" "); // 1 2 3 4
        int M = Integer.parseInt(br.readLine()); // 3
        String[] C = br.readLine().split(" "); // 2 4 7

        Deque<Integer> qs = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            if(flags[i].equals("0")){
                qs.addLast(Integer.parseInt(nums[i]));
            }
        }


        for(int i=0; i<M; i++){
            int c = Integer.parseInt(C[i]);

            qs.addFirst(c);
            sb.append(qs.pollLast()).append(" ");
        }


        System.out.println(sb);
        br.close();


    }

}
