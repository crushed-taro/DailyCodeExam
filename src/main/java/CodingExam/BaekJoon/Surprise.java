package CodingExam.BaekJoon;

import java.util.Scanner;

public class Surprise
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        name += "??!";

        System.out.println(name);
    }
}
