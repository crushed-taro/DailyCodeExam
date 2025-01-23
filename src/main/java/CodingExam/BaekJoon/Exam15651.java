package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam15651 {

    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        dfs(1);

        System.out.println(sb);

    }

    public static void dfs(int h) {
        if(h == M + 1) {
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arrayList.add(i);
            dfs(h + 1);
            arrayList.remove(arrayList.size() - 1);
        }
    }

}
