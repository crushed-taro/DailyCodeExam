package CodingExam.BaekJoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuePractice {

    /*
        들어온 순서와 상관없이, 우선순위가 가장 높은 데이터가 먼저 나가는 대기열.

        내부적으로는 힙(Heap)이라는 이진 트리 구조를 사용하여, 데이터를 넣고 뺄 때마다 O(log N)의 매우 빠른 속도로 우선순위를 재정렬합니다.
        실무에서는 스케줄러(알림 발송, 정산 처리)나 A/S 티켓 시스템을 만들 때 사용되는 컬렉션
     */

    public static void main(String[] args) {

        System.out.println("=== 기본 Min-Heap (오름차순) ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== Max-Heap 변경 및 순회의 함정 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== A/S 티켓 스케줄러 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(50);
        pq.offer(10);
        pq.offer(40);
        pq.offer(20);
        pq.offer(30);

        System.out.println("대기열에서 나오는 순서 (작은 수 우선) : ");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll() + " ");
        }
        System.out.println();
    }

    private static void intermediateTask() {
        // 내림차순(Max-Heap)으로 동작하도록 생성자의 역순 Comparator 주입
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(15);
        maxHeap.offer(8);
        maxHeap.offer(20);
        maxHeap.offer(3);

        System.out.println("큐 내부 배열 상태 (완벽한 내림차순이 아닐 수 있음) : " + maxHeap);

        System.out.println("poll() 추출 순서 (완벽한 내림차순) : ");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll() + " ");
        }
        System.out.println();

        /*
            Heap 트리의 함정 : PriorityQueue는 내부적으로 완벽한 정렬을 유지하지 않음. "부모 노드는 자식 노드보다 항상 크다(혹은 작다)"는 규칙만 유지하는 '트리' 형태
            따라서 poll()로 떠낼 때마다 1등을 다시 계산해서 뽑아주는 것이지, 대기열 안에 일렬로 예쁘게 서 있는 것이 아님을 명심해야 함.
         */

    }

    static class Ticket {
        String name;
        int urgency;
        long timestamp;

        public Ticket(String name, int urgency, long timestamp) {
            this.name = name;
            this.urgency = urgency;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return String.format("[%s] 긴급도 : %d, 접수시각 : %d", name, urgency, timestamp);
        }

    }

    private static void miniProject() {
        System.out.println("DeepLine 장애 처리 스케줄러 가동");

        Queue<Ticket> ticketQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.urgency == t2.urgency) {
                return Long.compare(t1.timestamp, t2.timestamp);
            }
            return Integer.compare(t2.urgency, t1.urgency);
        });

        ticketQueue.offer(new Ticket("단순 잉크 부족", 1, 100));
        ticketQueue.offer(new Ticket("메인보드 고장", 5, 200));
        ticketQueue.offer(new Ticket("네트워크 끊김", 5, 150));
        ticketQueue.offer(new Ticket("용지 걸림", 2, 300));

        System.out.println("--- 티켓 처리 순서 ---");
        while (!ticketQueue.isEmpty()) {
            System.out.println("할당됨 : " + ticketQueue.poll());
        }
    }

}
