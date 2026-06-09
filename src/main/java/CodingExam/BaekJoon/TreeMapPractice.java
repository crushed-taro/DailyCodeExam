package CodingExam.BaekJoon;

import java.util.*;

public class TreeMapPractice {

    /*
        TreeMap은 'Key(키)'를 기준으로 데이터를 자동으로 오름차순 정렬해 주는 Map 컬렉션

        데이터를 넣을 때마다 내부적으로 이진 탐색 트리(Red-Black Tree) 구조를 따라 자기 자리를 찾아가므로 'O(log N)의 속도를 가짐.
        "구매 금액별 할인율 등급", "시간대별 트래픽 로그", "날짜별 스케줄 관리" 등 특정 '기준값(Key)'에 따라 범위 탐색이 필요할 때 사용됨.
     */

    public static void main(String[] args) {

        System.out.println("=== Key 기준 자동 정렬 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 구간 검색 네비게이션 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 렌탈 과금 구간 매칭 시스템 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        TreeMap<Integer, String> empMap = new TreeMap<>();
        empMap.put(500, "최사원");
        empMap.put(100, "김부장");
        empMap.put(400, "박대리");
        empMap.put(200, "이과장");

        System.out.println("사번 기준 자동 정 : " + empMap);

        System.out.println("가장 낮은 사번 : " + empMap.firstKey());
        System.out.println("가장 높은 사번 : " + empMap.lastKey());

        Map.Entry<Integer, String> firstEmp = empMap.firstEntry();
        Map.Entry<Integer, String> lastEmp = empMap.lastEntry();

        System.out.println("첫 번째 데이터 : " + firstEmp.getKey() + "번 " + firstEmp.getValue());
        System.out.println("마지막 데이터 : " + lastEmp.getKey() + "번 " + lastEmp.getValue());

        /*
            자동 정렬의 기준 - TreeMap은 오직 Key만을 기준으로 정렬, Value의 크기나 알파벳 순서는 정렬에 아무런 영향을 주지 않음.
            Entity 객체 - firstKey()는 키만 가져오지만, firstEntry()는 키와 값이 묶인 상자(Map.Entry)를 통째로 가져오므로 값을 다룰 때 훨씬 효과적.
         */
    }

    private static void intermediateTask() {
        TreeMap<Integer, String> gradeMap = new TreeMap<>();

        gradeMap.put(90, "A");
        gradeMap.put(80, "B");
        gradeMap.put(70, "C");
        gradeMap.put(60, "D");

        System.out.println("성적 기준표 : " + gradeMap);

        int score1 = 85;
        Map.Entry<Integer, String> result1 = gradeMap.floorEntry(score1);
        System.out.println(score1 + "점의 등급" + result1.getValue() + " (적용 기준 : " + result1.getKey() + "점)");

        int score2 = 70;
        Map.Entry<Integer, String> lowerRes = gradeMap.lowerEntry(score2);
        Map.Entry<Integer, String> floorRes = gradeMap.floorEntry(score2);
        System.out.println(score2 + "점 기준 lower (무조건 미만) : " + lowerRes);
        System.out.println(score2 + "점 기준 floor (이하 포함) : " + floorRes);

        int minRequirement = 75;
        Map.Entry<Integer, String> ceilingRes = gradeMap.ceilingEntry(minRequirement);
        System.out.println(minRequirement + "점 이상 요구 시 가장 가까운 기준 : " + ceilingRes);

        /*
            floor(내림) - 주어진 키값과 같거나 작은 것 중 최대값.
            ceiling(올림) - 주어진 키값과 같거나 큰 것 중 최솟값.
         */
    }

    private static void miniProject() {
        TreeMap<Integer, Integer> pricingTiers = new TreeMap<>();
        pricingTiers.put(0, 15);
        pricingTiers.put(1000, 12);
        pricingTiers.put(5000, 18);
        pricingTiers.put(10000, 5);

        System.out.println("렌탈 장비 단가 테이블 로드 완료");

        int totalUsage = 6500;

        Map.Entry<Integer, Integer> appliedTier = pricingTiers.floorEntry(totalUsage);

        int unitPrice = appliedTier.getValue();
        int totalCost = totalUsage * unitPrice;

        System.out.println("--- 테넌트 과금 리포트 ---");
        System.out.println("누적 사용량 : " + totalUsage + "장");
        System.out.println("적용 단가 구간 : " + appliedTier.getKey() + "장");
        System.out.println("장당 청구 단가 : " + unitPrice + "원");
        System.out.println("최종 청구 금액 : " + totalCost + "원");

        SortedMap<Integer, Integer> promoTiers = pricingTiers.subMap(1000, 10000);
        System.out.println("타겟 프로모션 대상 요금제 구간 : " + promoTiers);
    }

}
