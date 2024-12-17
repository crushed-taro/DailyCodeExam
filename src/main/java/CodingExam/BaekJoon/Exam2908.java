package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2908 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        for(int i = 0; i < input.length; i++) {

            StringBuffer stringBuffer = new StringBuffer(input[i]);
            input[i] = stringBuffer.reverse().toString();
        }

        System.out.println(Math.max(Integer.parseInt(input[0]), Integer.parseInt(input[1])));

    }
}
