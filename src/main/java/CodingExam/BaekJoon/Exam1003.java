package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam1003 {

    static Integer[][] dp = new Integer[42][2];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
        dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
        dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
        dp[1][1] = 1;

        int T = sc.nextInt();

        while(T-- > 0) {
            int no = sc.nextInt();
            fibonacci(no);
            System.out.println(dp[no][0] + " " + dp[no][1]);
        }
    }

    static Integer[] fibonacci(int num) {

        if(dp[num][0] == null || dp[num][1] == null) {
            dp[num][0] = fibonacci(num - 1)[0] + fibonacci(num - 2)[0];
            dp[num][1] = fibonacci(num - 1)[1] + fibonacci(num - 2)[1];
        }
        return dp[num];
    }

}
