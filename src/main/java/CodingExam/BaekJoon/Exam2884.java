package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        minute += hour * 60;
//        System.out.println(hour + " " + minute);

        minute -= 45;
//        System.out.println(hour + " " + minute);
        if(minute < 0)
        {
            minute += 24 * 60;
        }

        hour = minute / 60;
        minute =minute - (hour * 60);

        System.out.println(hour + " " + minute);
    }
}
