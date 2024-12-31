package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exam14425 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> setArr = new HashSet<>();

        for (int i = 0; i < N; i++) {
            setArr.add(bufferedReader.readLine());
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            if(setArr.contains(bufferedReader.readLine())) {
                count++;
            }
        }

        bufferedReader.close();

        System.out.println(count);
    }

}
