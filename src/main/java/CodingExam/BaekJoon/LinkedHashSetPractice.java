package CodingExam.BaekJoon;

import java.util.*;

public class LinkedHashSetPractice {

    /*
        내부적으로 해시 테이블(Hash Table)과 양방향 연결 리스트(Doubly Linked List)를 동시에 사용하여,
        '중복을 허용하지 않으면서 데이터가 들어온 순서(Insertion Order)를 그대로 유지'

        실무에서 '최근 검색어 목록'을 고유하게 유지하거나, 들어온 순서대로 처리해야하는 '중복 방지 대기열(Queue)'을 구현할 때 사용
     */

    public static void main(String[] args) {

        System.out.println("=== 순서가 보장되는 Set 기초 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== List의 중복을 순서대로 제거하기 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== API 요청 대기열 필터링 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        Set<String> skills = new LinkedHashSet<>();

        skills.add("Spring");
        skills.add("React");
        skills.add("Linux");
        skills.add("Python");

        System.out.println("초기 상태 (넣을 순서 유지됨) : " + skills);

        boolean isAdded = skills.add("React");
        System.out.println("'React' 중복 추가 성공 여부 : " + isAdded);

        System.out.println("중복 추가 시도 후 상태 : " + skills);

        System.out.println("데이터 순회 : ");
        for (String skill : skills) {
            System.out.println("[" + skill + "]");
        }
        System.out.println();
    }

    private static void intermediateTask() {
        List<String> rawList = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "B", "D"));
        System.out.println("정제 전 원본 리스트 : " + rawList);

        Set<String> filterSet = new LinkedHashSet<>(rawList);
        rawList.clear();
        rawList.addAll(filterSet);
        System.out.println("정제 후 결과 리스트 : " + rawList);
    }

    private static void miniProject() {
        System.out.println("프린터 상태 동기화 API 대기열 가동");

        // 순서 보장 + 중복 제거가 필수적인 대기열
        Set<String> syncQueue = new LinkedHashSet<>();

        syncQueue.add("T-001");
        syncQueue.add("T-002");
        System.out.println(">> T-001, T-002 요청 인입");

        boolean duplicateReq = syncQueue.add("T-001");
        if(!duplicateReq) {
            System.out.println("T-001의 중복 요청이 감지되어 무시되었습니다.");
        }

        syncQueue.add("T-003");

        System.out.println("현재 대기열 상태 (요청 순서 유지) : " + syncQueue);
        System.out.println("총 대기 중인 작업 수 : " + syncQueue.size());

        System.out.println("--- 대기열 처리 시작 ---");

        Iterator<String> iterator = syncQueue.iterator();

        while(iterator.hasNext()) {
            String tenantId = iterator.next();
            System.out.println("작업 처리 중... 대상 : " + tenantId);

            // 처리 끝난 요소는 remove()를 호출하여 대기열에서 삭제
            iterator.remove();
        }

        System.out.println("모든 작업 처리 완료. 잔여 대기열 크기 : " + syncQueue.size());
    }
}
