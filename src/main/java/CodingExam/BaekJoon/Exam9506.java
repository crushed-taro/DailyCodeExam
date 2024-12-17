package CodingExam.BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam9506 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        do {

            for(int i = 1; i < num; i++) {
                if(num % i == 0) {
                    list.add(i);
                }
            }

            int sum = list.stream().mapToInt(Integer::intValue).sum();
//            System.out.println(sum);

            if(num == sum) {
                System.out.print(num + " = 1");
                for (Integer integer : list) {
                    if(integer == 1)
                        continue;
                    System.out.print(" + " + integer);
                }
                System.out.println();
            } else {
                System.out.println(num + " is NOT perfect.");
            }

            num = sc.nextInt();

            list = new ArrayList<>();

        } while(num != -1);
    }
}
