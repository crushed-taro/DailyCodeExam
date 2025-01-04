package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1735 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int c1 = Integer.parseInt(stringTokenizer.nextToken());
        int p1 = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int c2 = Integer.parseInt(stringTokenizer.nextToken());
        int p2 = Integer.parseInt(stringTokenizer.nextToken());

        c1 = c1 * p2 + c2 * p1;
        p1 = p1 * p2;
        int gcd = Euclidean(c1, p1);
        System.out.println(c1 / gcd + " " + p1 / gcd);

    }

    // 참고 : https://namu.wiki/w/유클리드%20호제법
    public static int Euclidean(int a, int b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }

}
