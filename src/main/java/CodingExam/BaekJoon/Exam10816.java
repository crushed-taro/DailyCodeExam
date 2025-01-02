package CodingExam.BaekJoon;

import java.io.*;
import java.util.*;

public class Exam10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Map<Integer, Integer> cards = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(stringTokenizer.nextToken());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        int getN = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getN; i++) {

            int num = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(cards.getOrDefault(num, 0)).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
