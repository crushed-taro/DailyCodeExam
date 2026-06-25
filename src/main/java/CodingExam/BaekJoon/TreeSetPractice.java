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

        /**
         * first() / last()
         *
         * 트리 구조의 맨 왼쪽 끝(최솟값)과 맨 오른쪽 끝(최댓값) 노드의 데이터를 삭제하지 않고 읽어옵니다.
         * 컬렉션이 비어있다면 NoSuchElementException을 발생시킴.
         */
        System.out.println("최솟값(first) : " + numbers.first());
        System.out.println("최댓값(last) : " + numbers.last());

        // 내림차순 뷰 확인
        /**
         * 현재 오름차순으로 정렬된 트리의 뷰(View)를 반대인 내림차순으로 뒤집어서 반환.
         * 핵심 - 데이터를 실제로 다시 정렬하는 것이 아니라, 원본 트리를 거꾸로 순회할 수 있도록 방향만 튼 NavigableSet을 반환하므로 성능 저하가 없음.
         */
        NavigableSet<Integer> descSet = numbers.descendingSet();
        System.out.println("내림차순 정렬 : " + descSet);
    }

    private static void intermediateTask() {
        TreeSet<Integer> scores = new TreeSet<>(Arrays.asList(80, 95, 75, 65, 90));
        System.out.println("현재 점수 목록 : " + scores);

        int target = 80;

        /**
         * lower(E e) - 미만
         * 파라미터 값보다 무조건 작은 데이터 중 가장 큰 값을 반환.
         * 일치하는 값이 없으면 null을 반환
         */
        System.out.println(target + "보다 무조건 작은 값 (lower) : " + scores.lower(target));

        /**
         * floor(E e) - 이하, 바닥
         * 파라미터 값과 같거나 작은 데이터 중 가장 큰 값을 반환.
         * 내 발밑(바닥)에 있거나 딱 내 위치인 데이터를 찾음.
         */
        System.out.println(target + "과 같거나 작은 값 (floor) : " + scores.floor(target));

        /**
         * higher(E e) - 초과
         * 파라미터 값보다 무조건 큰 데이터 중 가장 작은 값을 반환.
         */
        System.out.println(target + "보다 무조건 큰 값 (higher) : " + scores.higher(target));

        /**
         * ceiling(E e) - 이상, 천장
         * 파라미터 값과 같거나 큰 데이터 중 가장 작은 값을 반환.
         * 내 머리 위(천장)에 있거나 딱 내 위치인 데이터를 찾음. (요금제 매칭, 사이즈 업그레이드 등에 쓰임)
         */
        System.out.println(target + "과 같거나 큰 값 (ceiling) : " + scores.ceiling(target));

        /**
         * pollFirst() / pollLast()
         *
         * 최솟값이나 최댓값을 트리의 양 끝에서 삭제하면서 동시에 반환.
         * 일반적인 큐(Queue)의 poll()과 같은 역할을 하며, 정렬된 데이터를 차례대로 소모해야 할 때 유용.
         */
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
        /**
         * subSet(E fromElement, E toElement)
         *
         * 시작 값(fromElement)부터 끝 값(toElement) 사이의 범위에 해당하는 데이터들을 추출하여 반환.
         * 주의 - 기본적으로 시작 값은 포함(Inclusive)하고, 끝 값은 포함하지 않음(Exclusive)
         */
        SortedSet<Integer> workHoursLogs = logTimes.subSet(9, 18);
        System.out.println("업무 시간(9시 ~ 18시 미만) 로그 : " + workHoursLogs);

        /**
         * headSet(E toElement)
         *
         * 트리의 처음(최솟값)부터 특정 값 전(미포함)까지의 머리(Head) 부분 데이터들을 추출.
         */
        SortedSet<Integer> morningLogs = logTimes.headSet(12);
        System.out.println("오전(12시 미만) 로그 : " + morningLogs);

        /**
         * tailSet(E fromElement)
         *
         * 특정 값(포함)부터 트리의 끝(최댓값)까지의 꼬리(Tail) 부분 데이터들을 추출.
         */
        SortedSet<Integer> afternoonLogs = logTimes.tailSet(15);
        System.out.println("15시 이후 로그 : " + afternoonLogs);
    }
}
