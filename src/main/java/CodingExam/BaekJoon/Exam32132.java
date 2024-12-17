package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam32132 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();

        String tmp = "";

        for(int i = 0; i < num; i++) {
            tmp = input.replace("PS4", "PS");
            tmp = tmp.replace("PS5", "PS");
            input = tmp;
        }
        System.out.println(input);
    }
}
