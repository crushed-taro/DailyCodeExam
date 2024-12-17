package CodingExam.BaekJoon;

import java.util.Scanner;

public class Excam10871 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int underNum = sc.nextInt();

        int[] inputNum = new int[num];
        for(int i = 0; i < num; i++) {
            inputNum[i] = sc.nextInt();

            if(underNum > inputNum[i]){
                System.out.println(inputNum[i]);
            }
        }

    }
}
