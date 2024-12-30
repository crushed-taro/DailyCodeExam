package CodingExam.BaekJoon;

import java.io.*;
import java.util.*;

public class Exam1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordSet.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2);
        });

        for (String word : wordList) {
            bufferedWriter.write(word + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
