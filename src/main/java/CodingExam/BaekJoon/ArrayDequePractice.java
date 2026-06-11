package CodingExam.BaekJoon;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequePractice {

    /*
        내부적으로 가변 크기의 순환 배열(Circular Array)을 사용하는 Deque 구현체

        'LinkedList'처럼 매번 새로운 '노드(Node) 객체'를 메모리에 할당하지 않고 통짜 배열 안에서 포인터(Head, Tail) 이동만으로
        양 끝단 데이터를 제어하기 때문에, 자바 컬렉션 중에서 메모리 오버헤드가 가장 적고 큐/스택 연산 속도가 압도적으로 빠름.
        고성능 비동기 버퍼나 무거운 자원 관리를 할 때 사용.
     */

    public static void main(String[] args) {

        System.out.println("=== 큐와 스택 기능 및 메서드 매핑 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 중복 요소 저격 삭제 및 역순 순회 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 고성능 실시간 패킷 순환 버퍼 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Queue(FIFO) 구조 테스트 (offerLast -> pollFirst)
        deque.offer("Data-1");
        deque.offer("Data-2");
        System.out.println("큐 인입 완료 : " + deque);
        System.out.println("큐 poll 결과 (Data-1 예상) : " + deque.poll());

        deque.clear();

        // Stack(LIFO) 구조 테스트 (push -> pop)
        deque.push("Data-A");
        deque.push("Data-B");
        System.out.println("스택 push 결과 : " + deque);
        System.out.println("스택 pop 결과 (Data-B 예상) : " + deque.pop());

        /*
            1. deque.push(e)은 내부적으로 -> deque.addFirst(e)와 일치
            2. deque.pop()은 내부적으로 -> deque.removeFirst()와 일치
            3. deque.offerLast(e)은 내부적으로 -> deque.addLast(e)와 일치
         */
    }

    private static void intermediateTask() {
        ArrayDeque<String> jobQueue = new ArrayDeque<>();
        jobQueue.offerLast("JOB-A");
        jobQueue.offerLast("JOB-B");
        jobQueue.offerLast("JOB-A");
        jobQueue.offerLast("JOB-C");
        jobQueue.offerLast("JOB-A");

        System.out.println("초기 작업 대기열 : " + jobQueue);

        jobQueue.removeFirstOccurrence("JOB-A");
        System.out.println("첫 번째 JOB-A 저격 제거 후 : " +jobQueue);

        jobQueue.removeLastOccurrence("JOB-A");
        System.out.println("마지막 JOB-A 저격 제거 후 : " +jobQueue);

        System.out.println("최신 등록 작업부터 역순 출력 : ");
        Iterator<String> descIter = jobQueue.descendingIterator();
        while(descIter.hasNext()) {
            System.out.println("[" + descIter.next() + "]");
        }
        System.out.println();

    }

    private static void miniProject() {
        ArrayDeque<String> packetBuffer = new ArrayDeque<>();
        final int MAX_WINDOW_SIZE = 4;

        System.out.println("실시간 패킷 수집 엔진 가동 (최대 버퍼 " + MAX_WINDOW_SIZE + "개)");

        insertPacket(packetBuffer, MAX_WINDOW_SIZE, "PACKET-101");
        insertPacket(packetBuffer, MAX_WINDOW_SIZE, "PACKET-102");
        insertPacket(packetBuffer, MAX_WINDOW_SIZE, "PACKET-103");
        insertPacket(packetBuffer, MAX_WINDOW_SIZE, "PACKET-104");

        System.out.println("-> 버퍼 가득 참 상태 : " + packetBuffer);

        System.out.println("\n>> 신규 패킷 PACKET-105 인입 발생 (슬라이딩 윈도우 작동)");
        insertPacket(packetBuffer, MAX_WINDOW_SIZE, "PACKET-105");

        System.out.println("-> 최신화된 버퍼 상태 (101 제거 확인) : " + packetBuffer);

        insertPacket(packetBuffer, MAX_WINDOW_SIZE, "PACKET-106");
        System.out.println("-> 최종 버퍼 상태 (102 제거 확인) : " + packetBuffer);
    }

    private static void insertPacket(ArrayDeque<String> packetBuffer, int maxWindowSize, String s) {
        if (packetBuffer.size() == maxWindowSize) {
            String evicted = packetBuffer.pollFirst();
            System.out.println("오래된 데이터 밀어냄 기법 적용 -> 삭제된 패킷 : " + evicted);
        }

        packetBuffer.offerLast(s);
    }

}
