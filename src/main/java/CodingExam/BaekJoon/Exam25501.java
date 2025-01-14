package CodingExam.BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Exam25501 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();

            bufferedWriter.write(isPalindrome(str) + " " + count + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static int count = 0;

    public static int recursion(String str, int l, int r) {
        count += 1;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l + 1, r - 1);
    }

    public static int isPalindrome(String str) {
        count = 0;
        return recursion(str, 0, str.length() - 1);
    }
}
