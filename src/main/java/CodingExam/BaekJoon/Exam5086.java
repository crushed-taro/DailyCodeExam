package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam5086 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firNum = sc.nextInt();
        int secNum = sc.nextInt();
        

        int share = 0;

        String result = "";

        do {

            share = secNum / firNum;

            if((share * firNum) == secNum) {
                result = "factor";
            } else {
                share = firNum / secNum;
                if((share * secNum) == firNum) {
                    result = "multiple";
                } else {
                    result = "neither";
                }
            }
            System.out.println(result);

            firNum = sc.nextInt();
            secNum = sc.nextInt();
        } while(firNum != 0 && secNum != 0);

    }
}
