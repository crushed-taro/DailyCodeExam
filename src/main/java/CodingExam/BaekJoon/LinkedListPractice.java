package CodingExam.BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListPractice {

    // '노드(Node)'라는 상자에 담아 서로의 주소(앞, 뒤)를 가리키는 선(Pointer)으로 연결한 양방향 연결 리스트(Doubly Linked List)
    // 메시지 큐(Message Queue)를 구현하거나 최근 검색어(LRU Cache)처럼 데이터의 맨 앞이나 맨 뒤에서 잦은 추가/삭제가 일어날 때 사용

    public static void main(String[] args) {

        System.out.println("=== 양 끝단(Deque) 제어 기초 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== ArrayList vs LinkedList 성능 측정 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 최근 조회 테넌트 목록 (LRU) ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("테넌트A");
        list.addFirst("테넌트B");
        System.out.println("addFirst 2회 후 : " + list);

        list.addLast("테넌트C");
        System.out.println("addLast 후 : " + list);

        String first = list.getFirst();
        String last = list.getLast();
        System.out.println();

        String popped = list.removeFirst();
        System.out.println("뽑아낸 데이터 : " + popped);
        System.out.println("최종 데이터 : " + list);
    }

    private static void intermediateTask() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        int loopCount = 100000;

        long startTime1 = System.currentTimeMillis();

        for (int i = 0; i < loopCount; i++) {
            arrayList.add(0, "Data");
        }
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < loopCount; i++) {
            linkedList.add(0, "Data");
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("데이터 " + loopCount + "건을 맨 앞에 삽입하는 데 걸린 시간");
        System.out.println("ArrayList 소요 시간 : " + (endTime1 - startTime1) + " ms");
        System.out.println("linkedList 소요 시간 : " + (endTime2 - startTime2) + " ms");

        /*
            속도 차이가 나는 이유
            메모리 구조의 한계 :
                - ArrayList는 맨 앞에 데이터를 넣으면 기존 데이터가 모두 뒤로 이동해야 함(시간 복잡도 O(N))
                - LinkedList는 새로운 노드를 만들고 앞뒤 연결선(Pointer)만 바꿔주면 끝남(시간 복잡도 O(1));
         */
    }

    private static void miniProject() {
        LinkedList<String> recentTenants = new LinkedList<>();
        System.out.println("최근 조회 테넌트 관리기 시작");

        viewTenant(recentTenants, "T-001");
        viewTenant(recentTenants, "T-002");
        viewTenant(recentTenants, "T-003");
        viewTenant(recentTenants, "T-004");
        viewTenant(recentTenants, "T-005");
        System.out.println("5개 조회 후 : " + recentTenants);

        System.out.println("\n>> 새로운 테넌트 T-006 조회 발생");
        viewTenant(recentTenants, "T-006");
        System.out.println("최신 상태 : " + recentTenants);

        System.out.println("\n>> 기존 테넌트 T-003 재조회 발생");
        viewTenant(recentTenants, "T-003");
        System.out.println("최신 상태 : " + recentTenants);
    }

    private static void viewTenant(LinkedList<String> recentList, String tenantId) {
        recentList.removeIf(id -> recentList.equals(tenantId));

        recentList.addFirst(tenantId);

        if (recentList.size() > 5) {
            recentList.removeLast();
        }

    }
}
