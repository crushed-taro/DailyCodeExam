package CodingExam.BaekJoon;

import java.io.*;
import java.util.*;

public class Exam2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(bufferedReader.readLine());
        }

        bufferedReader.close();

        bufferedWriter.write(findAvg(num) + "\n");
        bufferedWriter.write(fineMiddle(num) + "\n");
        bufferedWriter.write(findFrequency(num) + "\n");
        bufferedWriter.write(findDiffer(num) + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static int findAvg(int[] num) {
        double sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        return (int) Math.round(sum / num.length);
    }

    // 중앙 값
    public static int fineMiddle(int[] num) {
        Arrays.sort(num);
        return num[num.length / 2];
    }

    // 최빈 값
    public static int findFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        if (array.length == 1) return array[0];

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());

        List<Integer> modeList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modeList.add(entry.getKey());
            }
        }

        Collections.sort(modeList);
        return modeList.size() > 1 ? modeList.get(1) : modeList.get(0);
    }

    public static int findDiffer(int[] num) {
        Arrays.sort(num);
        return Math.abs(num[num.length - 1] - num[0]);
    }

}
