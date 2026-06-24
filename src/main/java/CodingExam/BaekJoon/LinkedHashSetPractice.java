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

        /**
         * add(E e)
         *
         * 데이터를 집합에 추가.
         * HashSet과 동일하게 이미 존재하는 데이터면 false를 반환하고 추가를 무시.
         *
         * 주의점 - 만약 이미 존재하는 데이터(예 : "React")를 다시 add() 하려고 시도할 경우, 데이터가 중복 추가되지 않는 것은 물론이고,
         *        기존 데이터의 줄 서 있는 순서(위치)도 뒤로 갱신되지 않고 원래 자리에 그대로 유지.
         */
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

        /**
         * new LinkedHashSet<>(Collection<? extends E> c) - 컬렉션 주입 생성자
         *
         * 중복이 포함된 List 등의 컬렉션을 파라미터로 받아, 인스턴스 생성과 동시에 중복을 모두 제거.
         *
         * 이때 원본 List에 가장 먼저 등장했던 순서(Insertion Order)를 완벽하게 기억하여 Set을 구성.
         * 알고리즘 문제나 실무에서 "리스트의 원래 순서를 해치지 말고 중복만 제거하라"는 요구사항이 있을 때 단 한 줄로 해결할 수 있는 강력한 무기.
         */
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

        /**
         * 데이터를 순회할 수 있는 반복자(Iterator) 객체를 반환.
         * 무작위로 데이터가 튀어나오는 HashSet과 달리, LinkedHashSet의 Iterator는 반드시 데이터가 add 된 순서대로 요소를 차례대로 꺼내줌.
         */
        Iterator<String> iterator = syncQueue.iterator();

        while(iterator.hasNext()) {
            /**
             * Iterator.next()
             *
             * 대기열에서 다음 순서의 데이터를 하나 꺼내어 반환.
             */
            String tenantId = iterator.next();
            System.out.println("작업 처리 중... 대상 : " + tenantId);

            // 처리 끝난 요소는 remove()를 호출하여 대기열에서 삭제
            /**
             * next()로 방금 꺼내온 데이터를 컬렉션에서 안전하게 삭제.
             * 왜 syncQueue.remove()를 직접쓰지 않는가? - 향상된 for 문 (for (String s : syncQueue))을 돌면서 내부에 컬렉션 자체의 remove()를 호출하면,
             * 순회 도중 내부 배열의 사이즈가 변경되어 자바가 ConcurrentModificationException이라는 치명적인 에러를 발생시킴.
             * 따라서 대기열을 순회하면서 작업을 처리하고 지우거나, 특정 조건의 데이터를 걸러내어 삭제할 때는 반드시 Iterator를 명시적으로 꺼내어 이 메서드를 사용해야 함.
             */
            iterator.remove();
        }

        System.out.println("모든 작업 처리 완료. 잔여 대기열 크기 : " + syncQueue.size());
    }
}
