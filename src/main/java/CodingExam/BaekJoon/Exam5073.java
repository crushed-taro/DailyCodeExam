package CodingExam.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exam5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] inputs = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            int z = Integer.parseInt(inputs[2]);

            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            int[] sides = {x, y, z};
            Arrays.sort(sides);

            if (sides[0] + sides[1] <= sides[2]) {
                System.out.println("Invalid");
            } else if (x == y && y == z) {
                System.out.println("Equilateral");
            } else if (x == y || y == z || z == x) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }

        bufferedReader.close();
    }
}