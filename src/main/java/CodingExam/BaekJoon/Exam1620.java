package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(stringTokenizer.nextToken()) + 1;
        int N = Integer.parseInt(stringTokenizer.nextToken());

        String[] arr = new String[M];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i < M; i++) {
            arr[i] = bufferedReader.readLine();
            map.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {
            String str = bufferedReader.readLine();

            if(str.matches("[+-]?\\d+")) {
                System.out.println(arr[Integer.parseInt(str)]);
            } else {
                System.out.println(map.get(str));
            }
        }
    }

}
