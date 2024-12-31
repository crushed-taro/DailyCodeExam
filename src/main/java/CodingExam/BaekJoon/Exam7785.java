package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exam7785 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer;

        // 역순 정렬을 위해서 사용
        TreeSet<String> workSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String name = stringTokenizer.nextToken();
            String work = stringTokenizer.nextToken();

            if(work.equals("enter")) {
                workSet.add(name);
            } else {
                workSet.remove(name);
            }
        }
        bufferedReader.close();

        for (String s : workSet) {
            System.out.println(s);
        }


    }

}
