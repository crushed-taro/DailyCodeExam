package CodingExam.BaekJoon;

import java.util.Arrays;
import java.util.List;

public class ArraysPratice {

    public static void main(String[] args) {
        System.out.println("=== 배열 출력, 정렬, 탐색 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 복사, 채우기, 다차원 배열 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 테넌트 접속 로그 매니저 ===");
        miniProject();
        System.out.println();
    }

    private static void beginnerTask() {
        int[] numbers = {50, 10, 40, 20, 30};

        System.out.println("일반 객체 출력 : " + numbers);
        System.out.println("Arrays.toString : " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("정렬 후 : " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 40);
        System.out.println("숫자 40의 인덱스 : " + index);
    }

    private static void intermediateTask() {
        int[] buffer = new int[5];

        Arrays.fill(buffer, -1);
        System.out.println("fill 초기화 : " + Arrays.toString(buffer));

        buffer[0] = 99;
        int[] expanded = Arrays.copyOf(buffer, 10);
        System.out.println("길이 확장 : " + Arrays.toString(expanded));

        int[] subArray = Arrays.copyOfRange(expanded, 1, 4);
        System.out.println("부분 추출 : " + Arrays.toString(subArray));

        String[][] matrix1 = {{"A", "B"},{"C", "D"}};
        String[][] matrix2 = {{"A", "B"},{"C", "D"}};

        System.out.println("1차원 toString : " + Arrays.toString(matrix1));
        System.out.println("2차원 deepToString : " + Arrays.deepToString(matrix1));

        System.out.println("일반 equals 결과 : " + Arrays.equals(matrix1, matrix2));
        System.out.println("deepEquals 결과 : " + Arrays.deepEquals(matrix1, matrix2));
    }

    private static void miniProject() {
        String[] accessLogs = {"T105", "T101", "T104", "T102", "T103"};

        String[] backupLogs = Arrays.copyOf(accessLogs, accessLogs.length);

        Arrays.sort(accessLogs);

        System.out.println("--- 로그 처리 결과 ---");
        System.out.println("원본(스냅샷) 배열 : " + Arrays.toString(backupLogs));
        System.out.println("정렬(운영용) 배열 : " + Arrays.toString(accessLogs));

        boolean isModified = !Arrays.equals(backupLogs, accessLogs);
        System.out.println("원본 데이터와 배치가 달라졌습니까? : " + isModified);

        int searchIndex = Arrays.binarySearch(accessLogs, "T104");
        System.out.println("정렬된 데이터에서 T104의 위치 : " + searchIndex);

        // asList로 만든 리스트는 사이즈를 변경(remove, add)할 수 없음.
        List<String> logList = Arrays.asList(accessLogs);
        System.out.println("List로 변환된 데이터 크기 : " + logList.size());

        System.out.println("Stream으로 데이터 순회 : ");
        // stream : T101 → T102 → T103 → T104 → T105
        // .forEach(...) : Stream 안에 있는 데이터를 하나씩 꺼내서 처리
        /*
            log -> { ... } : 람다식, Stream에서 하나씩 꺼낸 값을 log라는 이름으로 받아서, { } 안의 코드를 실행

            // 아래와 동일한 코드
            for (String log : accessLogs) {
                System.out.println("[" + log + "]");
            }
         */
        Arrays.stream(accessLogs).forEach(log -> {
            System.out.println("[" + log + "]");
        });
        System.out.println();
    }

}
