package CodingExam.BaekJoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam1152 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");

        System.out.println(stringTokenizer.countTokens());

    }
}
