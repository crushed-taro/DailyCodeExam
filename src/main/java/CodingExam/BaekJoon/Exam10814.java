package CodingExam.BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exam10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int age = Integer.parseInt(input[0].trim());
            String name = input[1].trim();
            members.add(new Member(age, name, i));
        }
        bufferedReader.close();

        members.sort((m1, m2) -> {
            if (m1.age != m2.age) {
                return Integer.compare(m1.age, m2.age);
            }
            return Integer.compare(m1.order, m2.order);
        });

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Member member : members) {
            bufferedWriter.write(member.age + " " + member.name);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class Member {
        int age;
        String name;
        int order;

        Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }

}
