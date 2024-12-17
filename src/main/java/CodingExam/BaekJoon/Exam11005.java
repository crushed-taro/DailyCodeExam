package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam11005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        int tmp = 0;

        String result = "";

        while(n > 0) {

            tmp = n % b;

            if(tmp >= 10) {
                result += (char) (tmp + 55);
            } else {
                result += tmp;
            }
            n = n / b;
        }
        for(int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }
}
