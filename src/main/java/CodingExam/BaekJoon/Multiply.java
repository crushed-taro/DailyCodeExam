package CodingExam.BaekJoon;

import java.util.Scanner;

public class Multiply
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int bfir = (B % 10) * A;
        int bsec = ((B / 10) % 10) * A;
        int bthr = (B / 100) * A;
        System.out.println(bfir);
        System.out.println(bsec);
        System.out.println(bthr);
        System.out.println(A * B);

    }
}
