package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10807 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] inputNum = new int[num];
        for(int i = 0; i < num; i++) {
            inputNum[i] = sc.nextInt();
        }

        int findNum = sc.nextInt();
        int find = 0;
        for(int i = 0; i < num; i++) {
            if(findNum == inputNum[i]){
                find++;
            }
        }

        System.out.println(find);
    }
}
