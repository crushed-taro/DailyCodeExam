package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam19532 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());
        int f = Integer.parseInt(stringTokenizer.nextToken());

        int result1 = 0;
        int result2 = 0;

        boolean found = false;

        for (int x = -999; x <= 999; x++) {
            for(int y = -999; y <= 999; y++) {
                result1 = (a * x) + (b * y);
                result2 = (d * x) + (e * y);

                if(c == result1 && f == result2) {
                    System.out.print(x + " " + y);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

    }

}
