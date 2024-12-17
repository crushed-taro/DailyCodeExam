package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2941 {

    public static void main(String[] args) {

        String[] arrCroatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        Scanner sc = new Scanner(System.in);

        String good = sc.nextLine();
//        String good = "c=asdz=c=";

        for(String i : arrCroatia) {
            good = good.replace(i, ",");
        }

        System.out.println(good.length());
    }
}
