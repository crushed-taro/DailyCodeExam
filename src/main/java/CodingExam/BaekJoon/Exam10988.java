package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10988 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuffer stringBuffer = new StringBuffer(sc.nextLine());

        String originString = stringBuffer.toString();
        String reverseString = stringBuffer.reverse().toString();

        int result = originString.equals(reverseString)? 1 : 0;

        System.out.println(result);


    }
}
