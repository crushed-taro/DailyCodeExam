package CodingExam.BaekJoon;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TransferQueue;

public class TreeSetPractice {

    /*
        HashSet : 속도 O(1), 뒤죽박죽 순서
        LinkedHashSet : 들어온 순서 보장
        TreeSet : 들어온 순서와 상관없이 '데이터를 무조건 오름차순으로 자동 정렬(Sorted) 해주는 컬렉션

        내부적으로 이진 탐색 트리(Red-Black Tree)라는 구조를 사용하기 때문에 데이터를 넣을 때마다 알아서 자기 자리를 찾아감

        데이터 추가/삭제 속도는 O(log N)으로 HashSet보다 약간 느리지만,
        "특정 범위 데이터 찾기(예 : 50점 ~ 8점 사이)",
        "나보다 바로 한 단계 큰 값 찾기" 같은 범위 탐색(Range Search)에 있어서는 타의 추종을 불허하는 성능을 자랑.
     */


    public static void main(String[] args) {

        System.out.println("=== 자동 정렬과 양 끝단 추출 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 네비게이션 메서드 비교 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 요금제 매칭 및 기간 필터링 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);

        System.out.println("자동 오름차순 정렬 : " + numbers);

        System.out.println("최솟값(first) : " + numbers.first());
        System.out.println("최댓값(last) : " + numbers.last());

        // 내림차순 뷰 확인
        NavigableSet<Integer> descSet = numbers.descendingSet();
        System.out.println("내림차순 정렬 : " + descSet);
    }

    private static void intermediateTask() {
        TreeSet<Integer> scores = new TreeSet<>(Arrays.asList(80, 95, 75, 65, 90));
        System.out.println("현재 점수 목록 : " + scores);

        int target = 80;

        System.out.println(target + "보다 무조건 작은 값 (lower) : " + scores.lower(target));
        System.out.println(target + "과 같거나 작은 값 (floor) : " + scores.floor(target));

        System.out.println(target + "보다 무조건 큰 값 (higher) : " + scores.higher(target));
        System.out.println(target + "과 같거나 큰 값 (floor) : " + scores.ceiling(target));

        int lowest = scores.pollFirst();
        int highest = scores.pollLast();

        System.out.println("뽑아낸 최저 점수 : " + lowest + ", 최고 점수 : " + highest);
        System.out.println("poll 이후 남은 데이터 : " + scores);
    }

    private static void miniProject() {
        TreeSet<Integer> storagePlans = new TreeSet<>(Arrays.asList(100, 500, 1000, 5000));
        int customerUsage = 350;

        Integer recommendedPlan = storagePlans.ceiling(customerUsage);
        System.out.println("고객 사용량 : " + customerUsage + "GB -> 추천 요즘제 : " + recommendedPlan + "GB 플랜");

        TreeSet<Integer> logTimes = new TreeSet<>(Arrays.asList(2, 5, 9, 13, 15, 20, 22));
        System.out.println("\n전체 로그 발생 시각 : " + logTimes);

        // subSet을 활용한 9시부터 18시 '이전'까지 데이터 추출
        SortedSet<Integer> workHoursLogs = logTimes.subSet(9, 18);
        System.out.println("업무 시간(9시 ~ 18시 미만) 로그 : " + workHoursLogs);

        SortedSet<Integer> morningLogs = logTimes.headSet(12);
        System.out.println("오전(12시 미만) 로그 : " + morningLogs);

        SortedSet<Integer> afternoonLogs = logTimes.tailSet(15);
        System.out.println("15시 이후 로그 : " + afternoonLogs);
    }
}
