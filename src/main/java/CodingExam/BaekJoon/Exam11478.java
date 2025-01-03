package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exam11478 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 1; i < str.length() + 1; i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                set.add(str.substring(j,j+i));
            }
        }
        System.out.println(set.size());

    }

}
