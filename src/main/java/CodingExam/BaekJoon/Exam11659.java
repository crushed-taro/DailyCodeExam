package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int num[] = new int[N+1];
        int sum[] = new int[N+1];
        tk = new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++){
            num[i] = Integer.parseInt(tk.nextToken());
        }
        sum[0] = 0;
        for(int i=1;i<=N;i++){
            sum[i] = sum[i-1]+num[i];
        }

        for(int i=0;i<M;i++){
            tk = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(tk.nextToken());
            int e = Integer.parseInt(tk.nextToken());
            System.out.println(sum[e]-sum[s-1]);
        }
    }

}
