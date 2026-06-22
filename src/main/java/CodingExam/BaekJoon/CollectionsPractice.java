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

        /**
         * Collections.sort(List<T> list)
         *
         * 전달된 리스트의 요소들을 오름차순(작은 것부터 큰 순서)으로 정렬.
         * Arrays.sort()와 마찬가지로 원본 리스트 자체의 요소 순서를 직접 변경(In-place)함.
         */
        Collections.sort(tenants);
        System.out.println("정렬 후 : " + tenants);

        /**
         * Collections.reverse(List<T> list)
         *
         * 현재 리스트 요소들의 배치 순서를 완전히 거꾸로 뒤집음. (내림차순 정렬이 아님)
         * 단순히 현재 줄 서 있는 순서의 앞뒤를 뒤집을 뿐이므로, 완벽한 내림차순을 원한다면 sort로 오름차순 정렬을 한 뒤 reverse를 하거나.
         * Collections.sort(list, Collections.reverseOrder())를 사용.
         */
        Collections.reverse(tenants);
        System.out.println("역순 뒤집기 후 : " + tenants);

        Collections.sort(tenants);

        /**
         * binarySearch(List<?> list, Object key)
         *
         * 이진 탐색(Binary Search) 알고리즘을 사용하여 리스트 내에서 특정 값(key)의 인덱스를 찾아 반환.
         * 절대 규칙 - 탐색 전 반드시 리스트가 오름차순으로 정렬(sort)되어 있어야 정상적인 결과값을 얻을 수 있음.
         */
        int index = Collections.binarySearch(tenants, "테넌트B");
        System.out.println("정렬 상태에서 '테넌트B'의 인덱스 위치 : " + index);

        /**
         * shuffle(List<?> list)
         *
         * 리스트 내부의 요소들을 무작위(Random)로 섞음.
         * 통계 샘플링 데이터를 셔플하거나, 게임 로직에서 카드 덱을 섞을 때 주로 사용.
         */
        Collections.shuffle(tenants);
        System.out.println("무작위 섞기 후 : " + tenants);
    }

    private static void intermediateTask() {
        List<Integer> scores = new ArrayList<>(Arrays.asList(10, 50, 30, 50, 20, 50));

        /**
         * 컬렉션 내부에 있는 요소 중 최솟값과 최댓값을 반환.
         * 내부적으로 전체 요소를 순회하며 비교하므로, 컬렉션이 정렬되어 있지 않은 상태에서도 정확한 값을 찾아냄.
         */
        int minVal = Collections.min(scores);
        int maxVal = Collections.max(scores);
        System.out.println("최솟값 : " + minVal + ", 최댓값 : " + maxVal);

        /**
         * 컬렉션 내에 특정 객체(o)가 몇 번 포함되어 있는지(등장 빈도수)를 카운트하여 int로 반환.
         * equals() 메서드를 기준으로 동일성을 판단.
         */
        int count = Collections.frequency(scores, 50);
        System.out.println("50의 등장 빈도 횟수 : " + count);

        /**
         * 리스트 내에 존재하는 모든 oldVal을 찾아서 newVal로 일괄 치환(Replace).
         * 데이터 마이그레이션이나 일괄 업데이트 로직으로 유용.
         */
        Collections.replaceAll(scores, 50, 90);
        System.out.println("90으로 치환 후 : " + scores);

        /**
         * unmodifiableList(List<? extends T> list)
         *
         * 전달된 리스트를 랩핑하여 읽기 전용(Read-Only) 뷰(View)를 반환.
         * 반환된 리스트에 add(), remove(), set() 등의 수정 연산을 시도하면 즉각적으로 UnsupportedOperationException 런타임 에러가 발생.
         * 메서드의 반환값으로 리스트를 넘겨줄 때, 호출한 쪽에서 원본 데이터를 임의로 조작하여 발생하는 사이드 이펙트(Side Effect)를 원천 차단 할 수 있음.
         */
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
        /**
         * ArrayList는 기본적으로 스레드 안전(Thread-Safe)하지 않기 때문에, 여러 스레드가 동시에 add()를 호출하면 데이터가 유실되거나 꼬이는 경합 조건(Race Condition)이 발생.
         * 이 메서드는 리스트의 모든 데이터 접근 로직에 synchronized 잠금(Lock) 처리를 추가한 새로운 래퍼 리스트를 반환하여, 멀티스레드 환경에서도 안전하게 데이터를 보호해 줌.
         * StringBuffer가 동기화로 보호받는 것과 동일한 원리.
         */
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

        // 불변 보호막 : 외부 레이어나 타사 API로 데이터를 넘겨줄 떄, 원본 리스트의 무결성을 지키기 위해 사용.
        List<Integer> finalResultData = Collections.unmodifiableList(transactions);

        System.out.println("--- 테넌트 결제 메트릭 리포트 ---");
        System.out.println("최고 매출 단건 : " + highest);
        System.out.println("최저 매출 단건 : " + lowest);
        System.out.println(targetFrequency + "원 결제 건수 : " + targetFrequency + "회");
        System.out.println("보안 검증용 캡슐화 완료 데이터 : " + finalResultData.size());
    }

}
