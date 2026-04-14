package CodingExam.BaekJoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Exam1931 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] time = new int[N][2];

        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt(); //시작
            time[i][1] = in.nextInt(); // 종료
        }

        // 종료 시간이 빠른 순으로 졍렬
        // 종료 시간이 같으면 시작 시간이 빠른 순으로 정렬
        // compare 재정의
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_time = 0;

        for (int i = 0; i < N; i++) {
            if (prev_time <= time[i][0]) {
                prev_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
