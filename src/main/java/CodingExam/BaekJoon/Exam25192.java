package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Exam25192 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> enterMember = new HashSet<>();

        int T = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        for (int i = 0; i < T; i++) {
            String member = bufferedReader.readLine();

            if(member.equals("ENTER")) {
                count += enterMember.size();

                enterMember = new HashSet<>();
            } else {
                enterMember.add(member);
            }
        }

        count += enterMember.size();

        System.out.println(count);

        bufferedReader.close();

    }

}
