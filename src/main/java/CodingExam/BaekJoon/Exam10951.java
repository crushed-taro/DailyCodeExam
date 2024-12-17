package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10951 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = 0;
        int B = 0;
        while(sc.hasNextInt()) {
//            System.out.println("sc = " + sc.hasNextInt());
            A = sc.nextInt();
            B = sc.nextInt();
            System.out.println(A + B);
        }
        sc.close();
    }
}
