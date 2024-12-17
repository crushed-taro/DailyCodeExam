package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam27866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();
        int num = sc.nextInt();

        System.out.println(input[num - 1]);
    }
}
