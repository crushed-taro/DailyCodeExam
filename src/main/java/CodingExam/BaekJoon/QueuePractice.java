package CodingExam.BaekJoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {

    /*
        Queue - 먼저 들어온 데이터가 먼저 나간다(First-In, First-Out, FIFO)
     */

    public static void main(String[] args) {

        System.out.println("=== 일반 Queue (FIFO) ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== PriorityQueue (우선순위) ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        Queue<String> queue = new LinkedList<>();

        /**
         * offer(E e)
         * 전달된 데이터를 큐의 맨 뒤(Tail)에 줄 세움. - 삽입
         * 성공하면 true를 반환하며, 만약 큐의 용량이 꽉 차서 삽입에 실패하면 에러를 던지지 않고 안전하게 false를 반환.
         * 에러를 발생시키는 add(E e) 메서드보다 시스템 안정성 면에서 훨씬 권장.
         */
        queue.offer("Doc-1");
        queue.offer("Doc-2");
        queue.offer("Doc-3");

        System.out.println("다음 처리 대기 : " + queue);

        /**
         * isEmpty()
         *
         * 큐에 대기 중인 데이터가 없는지 확인하여 boolean을 반환.
         * 작성된 while (!queue.isEmpty()) 패턴은 큐에 데이터가 남아있는 동안 계속해서 poll()을 수행하며 작업을 처리하는 서버 백엔드의 가장 기본적인 메시지 소비(Consumer) 패턴.
         */
        while (!queue.isEmpty()) {
            /**
             * poll()
             * 큐의 맨 앞(Head)에 있는 가장 오래된 데이터를 대기열에서 삭제하면서 동시에 반환(추출)함.
             * 만약 큐가 텅 비어있다면 에러를 던지지 않고 null을 반환.
             * 마찬가지로 에러를 던지는 remove() 메서드보다 안전.
             */
            System.out.println("처리 완료 : " + queue.poll());
        }

        /**
         * peek()
         * 현재 큐의 맨 앞에 누가 서 있는지 데이터만 살짝 확인하고,
         * 큐에서 삭제하지는 않음. - 다음 처리 대상 검사 시 사용.
         */
    }

    private static void miniProject() {
        // 우선순위가 높은 순으로 처리 (낮은 숫자 또는 사전순이 우선)
        /**
         * new PriorityQueue<>()
         *
         * 데이터가 들어온 순서(시간)를 완전히 무시하고, 객체가 가진 고유한 우선순위에 따라 정렬(오름차순)하여 줄을 세우는 특별한 큐
         * 기본 생성자를 사용하면 문자열은 '사전순(알파벳순)'으로 오름차순 정렬됨.
         * 알파벳 N(Normal)이 V(VIP)보다 사전에 먼저 나오기 때문에, 결과적으로 "Normal-A" -> "Normal-B" -> "VIP-1" 순서로 빠져나오게 됨.
         * 만약 "VIP-1"을 무조건 맨 먼저 꺼내고 싶다면(새치기), 앞서 Comparable/Comparator 파트에서 배운 것처럼 PriorityQueue 생성자에 특정 문자열이나 긴급도 숫자를 우선하는 커스텀 정렬 기준(Comparator)을 주입해 주어야 함.
         */
        Queue<String> vipQueue = new PriorityQueue<>();

        vipQueue.offer("Normal-A");
        vipQueue.offer("VIP-1");
        vipQueue.offer("Normal-B");

        System.out.println("대기열에서 나오는 순서 : ");
        while (!vipQueue.isEmpty()) {
            System.out.println(vipQueue.poll());
        }
    }

}
