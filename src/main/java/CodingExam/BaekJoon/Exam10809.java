package CodingExam.BaekJoon;

import java.util.Scanner;

public class Exam10809 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int[] arrChar = new int[26];

        for(int i = 0; i < 26; i++) {
            arrChar[i] = -1;
        }

        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            if(arrChar[ch - 'a'] == -1){
                arrChar[ch - 'a'] = i;
            }
        }

        for(int i : arrChar) {
            System.out.print(i + " ");
        }
    }
}
