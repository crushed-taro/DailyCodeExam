package CodingExam.BaekJoon;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exam10101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] angle = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        int total = Arrays.stream(angle).sum();
//        System.out.println("total = " + total);

        String return_result;

        if(total != 180) {
            return_result = "Error";
        } else {
            if(angle[0] == angle[1] && angle[0] == angle[2]) {
                return_result = "Equilateral";
            } else if(angle[0] == angle[1] || angle[0] == angle[2] || angle[1] == angle[2]) {
                return_result = "Isosceles";
            } else {
                return_result = "Scalene";
            }
        }

        System.out.println(return_result);
    }

}
