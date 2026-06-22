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

        /**
         * addFirst(E e), addLast(E, e)
         *
         * 리스트의 맨 앞(Head)이나 맨 뒤(Tail)에 데이터를 추가.
         *
         * 내부적으로 기존 데이터를 이동시킬 필요 없이, 새로운 노드(Node)를 만들고 앞뒤 연결선(Pointer)만 이어주면 되기 때문에
         * 데이터 크기와 상관없이 항상 초고속(O(1))으로 동작.
         * addLast는 일반 add와 동일하게 동작.
         */
        list.addFirst("테넌트A");
        list.addFirst("테넌트B");
        System.out.println("addFirst 2회 후 : " + list);

        list.addLast("테넌트C");
        System.out.println("addLast 후 : " + list);

        /**
         * getFirst(), getLast()
         * 리스트의 맨 앞이나 맨 뒤에 있는 데이터를 삭제하지 않고 읽어오기만 함.
         * 만약 리스트가 비어있다면 NoSuchElementException 예외를 발생.
         */
        String first = list.getFirst();
        String last = list.getLast();
        System.out.println();

        /**
         * removeFirst(), removeLast()
         *
         * 리스트의 맨 앞이나 맨 뒤에 있는 데이터를 리스트에서 삭제하면서 동시에 그 값을 반환(추출)함.
         * 큐(Queue)나 스택(Stack)을 구현할 때, 혹은 LRU 캐시에서 '가장 오래된 데이터'를 쫓아낼 때 사용.
         */
        String popped = list.removeFirst();
        System.out.println("뽑아낸 데이터 : " + popped);
        System.out.println("최종 데이터 : " + list);
    }

    private static void intermediateTask() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        int loopCount = 100000;

        long startTime1 = System.currentTimeMillis();

        /**
         * add(int index, E element)
         *
         * 인덱스를 지정하여 특정 위치에 데이터를 '끼워 넣는'메서드.
         *
         * ArrayList의 경우 - 인덱스가 0에 데이터를 넣으면, 기존에 있던 10만 개의 데이터가 모두 뒤로 한 칸씩 이사를 감.
         *                  시간 복잡도 O(N)
         *                  이 때문에 반복 작업 시 속도가 기하급수적으로 느려짐.
         *
         * LinkedList의 경우 - 인덱스 0에 데이터를 넣으면, 단순히 맨 앞에 상자(Node)를 하나 던져놓고 다음 상자와 선표시(포인터 연결)만 새로 쓱 그려주면 끝.
         *                   시간 복잡도 O(1)
         *                   맨 앞이나 중간에 데이터 삽입/삭제가 잦은 비즈니스 로직에서는 반드시 LinkedList를 써야 함.
         */
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
        /**
         * removeIf(Predicate<? super E> filter)
         *
         * 자바 8부터 도입된 강력한 메서드로, 전달된 조건(람다식)을 만족하는 모든 요소를 안전하게 찾아 삭제.
         *
         * 기존의 for 문 안에서 remove()를 호출하면 리스트 사이즈가 꼬이면서 예외(ConcurrentModificationException)가 발생하지만,
         * removeIf는 내부적으로 안전한 반복자(Iterator)를 사용하여 버그 없이 중복 데이터를 제거.
         */
        recentList.removeIf(id -> recentList.equals(tenantId));

        recentList.addFirst(tenantId);

        /**
         * 현재 리스트에 들어있는 노드(요소)의 총개수를 반환.
         * LRU 캐시 등에서 "최대 N 개까지만 유지한다"는 비즈니스 룰을 적용할 때 방어 로직 'if(size > 5)'으로 필수 사용됨.
         */
        if (recentList.size() > 5) {
            recentList.removeLast();
        }

    }
}
