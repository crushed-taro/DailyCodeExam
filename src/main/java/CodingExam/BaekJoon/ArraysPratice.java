package CodingExam.BaekJoon;

import java.util.Arrays;
import java.util.List;

public class ArraysPratice {

    // 정렬, 탐색, 복사, 변환 등 유틸리티(정적 메서드)를 제공

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

        /**
         * 자바에서 배열을 그냥 출력하면 알 수 없는 메모리 주소(해시코드)가 나옴.
         * 이 메서드는 배열 내부의 요소들을 [50, 10, 40] 형태의 사람이 읽을 수 있는 문자열로 변환하여 반환.
         */
        System.out.println("일반 객체 출력 : " + numbers);
        System.out.println("Arrays.toString : " + Arrays.toString(numbers));

        /**
         * 전달된 배열의 요소들을 오름차순(작은 것부터 큰 순서)으로 정렬.
         * 새로운 배열을 반환하는 것이 아니라, 전달된 원본 배열 자체의 순서를 직접 바꿈. (In-place 방식)
         */
        Arrays.sort(numbers);
        System.out.println("정렬 후 : " + Arrays.toString(numbers));

        /**
         * 배열 안에서 특정 값을 찾아 그 위치(인덱스)를 반환.
         * 내부적으로 이진 탐색(반씩 쪼개가며 찾는 방식)을 사용하여 속도가 엄청나게 빠름.
         * 이 메서드를 쓰려면 반드시 배열이 먼저 sort()로 오름차순 정렬되어 있어야 함.
         * 정렬되지 않은 배열에 쓰면 엉뚱한 음수가 반환됨.
         */
        int index = Arrays.binarySearch(numbers, 40);
        System.out.println("숫자 40의 인덱스 : " + index);
    }

    private static void intermediateTask() {
        int[] buffer = new int[5];

        /**
         * 배열의 모든 칸을 지정한 값으로 일괄 초기화함.
         * 알고리즘 문제에서 방문 여부를 모두 false로 바꾸거나, 초기 점수를 -1로 세팅할 때 for문 대신 한 줄로 끝낼 수 있음.
         */
        Arrays.fill(buffer, -1);
        System.out.println("fill 초기화 : " + Arrays.toString(buffer));

        /**
         * 원본 배열의 데이터를 그대로 복사하여 새로운 배열을 만들어 반환.
         * 만약 '새로운 길이'가 원본보다 크다면, 남는 빈칸은 데이터 타입의 기본값(int는 0, boolean은 false, 객체는 null)으로 채워짐.
         * 배열의 크기를 늘릴 때 사용.
         */
        buffer[0] = 99;
        int[] expanded = Arrays.copyOf(buffer, 10);
        System.out.println("길이 확장 : " + Arrays.toString(expanded));

        /**
         * 원본 배열의 특정 구간만 잘라내어 새로운 배열로 만듦.
         * String.substring과 마찬가지로 '시작 인덱스'는 포함(Inclusive)하고, '끝 인덱스'는 제외(Exclusive)함.
         */
        int[] subArray = Arrays.copyOfRange(expanded, 1, 4);
        System.out.println("부분 추출 : " + Arrays.toString(subArray));

        String[][] matrix1 = {{"A", "B"},{"C", "D"}};
        String[][] matrix2 = {{"A", "B"},{"C", "D"}};

        System.out.println("1차원 toString : " + Arrays.toString(matrix1));

        /**
         * deepToString, deepEquals
         *
         * 2차원 이상의 배열(int[][] 등)은 배열 안에 '배열의 메모리 주소'가 들어있는 구조.
         * 따라서 다차원 배열에 일반 toString()이나 equals()를 쓰면 껍데기 주소값만 다루게 됨.
         * deep~이 붙은 메서드들은 배열 안의 배열까지 끝까지 파고들어가서 실제 가장 안쪽에 있는 데이터 값을 기준으로 문자열을 만들거나 일치 여부를 비교.
         */
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

        /**
         * 배열을 자바 컬렉션 프레임워크인 List 타입으로 반환해 줌.
         * 하지만 이 리스트는 진짜 ArrayList가 아니라, 원본 배열과 한 몸처럼 연결된 고정 크기(Fixed-size)의 가짜 리스트.
         * 데이터의 값을 바꿀 수(Set)는 있지만, .add()나 .remove()를 호출해 크기를 변경하려고 하면 UnsupportedOperationException에러가 발생.
         * 완벽한 ArrayList를 만들려면 new ArrayList<>(Arrays.asList(...)) 처럼 한 번 더 감싸주어야 함.
         */
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
        /**
         * 일반 배열을 Java 8의 Stream API 파이프라인으로 변환.
         * 변환된 스트림을 통해 filter, map, forEach 등의 강력한 함수형 프로그래밍 기법을 배열에도 적용할 수 있게 해줌.
         * 아래 작성된 람다식이 스트림의 최종 연산 중 하나.
         */
        Arrays.stream(accessLogs).forEach(log -> {
            System.out.println("[" + log + "]");
        });
        System.out.println();
    }

}
