package CodingExam.BaekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exam10815 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Set<Integer> cards = new HashSet<>();
        for(int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(stringTokenizer.nextToken()));
        }


        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < M; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if(cards.contains(number)) {
                bufferedWriter.write("1 ");
            } else {
                bufferedWriter.write("0 ");
            }
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
