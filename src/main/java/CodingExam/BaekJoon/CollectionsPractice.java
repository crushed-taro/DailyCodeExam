package CodingExam.BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsPractice {

    /*
        자바의 컬렉션 프레임워크(List, Set, Map)를 가공하고 보호하능 만능 도구 상자
        이 클래스는 인스턴스를 생성하지 않고 모든 메서드를 정적(static) 메서드로 호출하여 사용.
     */

    public static void main(String[] args) {

        System.out.println("=== 순서 제어 및 탐색 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 통계, 치환 및 컬렉션 보호 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 트랜잭션 메트릭 수집기 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        List<String> tenants = new ArrayList<>(Arrays.asList("테넌트E","테넌트A","테넌트D","테넌트B","테넌트C"));
        System.out.println("원본 리스트 : " + tenants);

        Collections.sort(tenants);
        System.out.println("정렬 후 : " + tenants);

        Collections.reverse(tenants);
        System.out.println("역순 뒤집기 후 : " + tenants);

        Collections.sort(tenants);
        int index = Collections.binarySearch(tenants, "테넌트B");
        System.out.println("정렬 상태에서 '테넌트B'의 인덱스 위치 : " + index);

        Collections.shuffle(tenants);
        System.out.println("무작위 섞기 후 : " + tenants);
    }

    private static void intermediateTask() {
        List<Integer> scores = new ArrayList<>(Arrays.asList(10, 50, 30, 50, 20, 50));

        int minVal = Collections.min(scores);
        int maxVal = Collections.max(scores);
        System.out.println("최솟값 : " + minVal + ", 최댓값 : " + maxVal);

        int count = Collections.frequency(scores, 50);
        System.out.println("50의 등장 빈도 횟수 : " + count);

        Collections.replaceAll(scores, 50, 90);
        System.out.println("90으로 치환 후 : " + scores);

        List<Integer> readOnlyScores = Collections.unmodifiableList(scores);
        System.out.println("읽기 전용 리스트 생성 완료");

        try {
            readOnlyScores.add(100);
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException 보호막 작동 : 읽기 전용 리스트는 수정할 수 없습니다.");
        } catch (Exception e) {
            System.out.println("Exception");
        }

        // 멀티스레드 안전 리스트 생성 예시
        List<Integer> syncedList = Collections.synchronizedList(scores);

    }

    private static void miniProject() {
        List<Integer> transactions = new ArrayList<>(Arrays.asList(32000, 15000, 50000, 99000, 50000, 12000, 50000));

        System.out.println("데이터 수집 엔진 가동");

        int highest = Collections.max(transactions);
        int lowest = Collections.min(transactions);

        int targetAmount = 50000;
        int targetFrequency = Collections.frequency(transactions, targetAmount);

        Collections.shuffle(transactions);
        System.out.println("샘플링 데이터 셔플 완료 : " + transactions);

        List<Integer> finalResultData = Collections.unmodifiableList(transactions);

        System.out.println("--- 테넌트 결제 메트릭 리포트 ---");
        System.out.println("최고 매출 단건 : " + highest);
        System.out.println("최저 매출 단건 : " + lowest);
        System.out.println(targetFrequency + "원 결제 건수 : " + targetFrequency + "회");
        System.out.println("보안 검증용 캡슐화 완료 데이터 : " + finalResultData.size());
    }

}
