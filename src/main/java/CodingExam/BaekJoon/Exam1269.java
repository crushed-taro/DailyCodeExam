package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exam1269 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Set<Integer> setN = new HashSet<>();
        Set<Integer> setM = new HashSet<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            setN.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            setM.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Set<Integer> copy = new HashSet<>(setN);

        setN.removeAll(setM);
        setM.removeAll(copy);
        setN.addAll(setM);

        System.out.print(setN.size());
        bufferedReader.close();
    }

}
