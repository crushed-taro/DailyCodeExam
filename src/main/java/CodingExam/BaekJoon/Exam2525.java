package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam2525 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int time = sc.nextInt();
//        System.out.println(hour + " " + minute + " " + time);

        minute += hour * 60;

        minute += time;

        hour = minute / 60;
        minute = minute - (hour * 60);

        if(hour > 23)
            hour -= 24;

        System.out.println(hour + " " + minute);

    }
}
