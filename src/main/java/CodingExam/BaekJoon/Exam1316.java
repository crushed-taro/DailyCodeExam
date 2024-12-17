package CodingExam.BaekJoon;

import java.io.*;

public class Exam1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //단어의 개수 N
        int count = N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            /*이 문제를 풀려면 이전에 나온 문자와 지금의 문자가 같은지 다른지를 비교해야 할 필요가 있다.
             * 이전에 나온 문자를 prev로, 지금의 문자를 now로 선언한다.*/

            int prev = 0;

            int[] alphabet = new int[26];

            for (int j = 0; j < str.length(); j++) {
                int now = str.charAt(j); //문자열에서 j번째 문자를 now로 초기화

                if (prev != now) {
                    if (alphabet[now - 97] == 0) {
                        alphabet[now - 97]++;
                        prev = now;
                    } else {
                        count--;
                        break;
                    }
                }
            }
        }

        System.out.println(count);

    }

}