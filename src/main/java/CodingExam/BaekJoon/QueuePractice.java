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

        queue.offer("Doc-1");
        queue.offer("Doc-2");
        queue.offer("Doc-3");

        System.out.println("다음 처리 대기 : " + queue);

        while (!queue.isEmpty()) {
            System.out.println("처리 완료 : " + queue.poll());
        }

    }

    private static void miniProject() {
        // 우선순위가 높은 순으로 처리 (낮은 숫자 또는 사전순이 우선)
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
