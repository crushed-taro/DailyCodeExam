package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam25314 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String longPlus = "";
        for(int i = 0; i < num; i += 4) {
            longPlus += "long ";
        }

        longPlus += "int";

        System.out.println(longPlus);

    }
}
