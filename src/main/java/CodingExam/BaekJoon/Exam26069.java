package CodingExam.BaekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exam26069 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer;
        String userA, userB;

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ChongChong");

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            userA = stringTokenizer.nextToken();
            userB = stringTokenizer.nextToken();

            if(hashSet.contains(userA) || hashSet.contains(userB)) {
                hashSet.add(userA);
                hashSet.add(userB);
            }
        }

        bufferedReader.close();

        bufferedWriter.write(hashSet.size() + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
