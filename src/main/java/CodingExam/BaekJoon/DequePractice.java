package CodingExam.BaekJoon;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequePractice {

    /*
        Deque(덱, Double-Ended Queue)은 양쪽 끝(앞과 뒤) 어디서든 자유롭게 데이터를 넣고 뺄 수 있는 '양방향 터널'
     */

    public static void main(String[] args) {

        System.out.println("=== 양방향 제어 (First & Last) ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 모던 자바의 Stack 대체 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== Undo & Redo 매니저 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        Deque<String> deque = new ArrayDeque<>();

        deque.offerLast("일반손님1");
        deque.offerLast("일반손님2");
        System.out.println("일반 줄서기 상태 : " + deque);

        deque.offerFirst("VIP손님");
        System.out.println("VIP 새치기 상태 : " + deque);

        System.out.println("맨 앞 손님 : " + deque.peekFirst());
        System.out.println("맨 뒤 손님 : " + deque.peekLast());

        System.out.println("앞에서 나감 : " + deque.pollFirst());
        System.out.println("뒤에서 나감 : " + deque.pollLast());
        System.out.println("최종 남은 손님 : " + deque);

    }

    private static void intermediateTask() {
        Deque<String> stack = new ArrayDeque<>();

        System.out.println("브라우저 방문 기록을 스택에 쌓습니다.");

        stack.push("구글");
        stack.push("네이버");
        stack.push("카카오");

        System.out.println("현재 화면(가장 최근) : " + stack.peek());

        System.out.println("--- 뒤로 가기 시작 ---");
        while(!stack.isEmpty()) {
            System.out.println("뒤로 가기 : " + stack.pop());
        }
    }

    private static void miniProject() {
        Deque<String> history = new ArrayDeque<>();
        Deque<String> redoList = new ArrayDeque<>();

        System.out.println("문서 편집기를 시작합니다.");

        typeText(history, redoList, "문장 1 입력");
        typeText(history, redoList, "문장 2 입력");
        typeText(history, redoList, "문장 3 입력");
        printStatus(history, redoList);

        System.out.println("\n>> [Ctrl + Z] 실행 취소 2번 수행");
        undo(history, redoList);
        undo(history, redoList);
        printStatus(history, redoList);

        System.out.println("\n>> [Ctrl + Y] 다시 실행 1번 수행");
        redo(history, redoList);
        printStatus(history, redoList);

        System.out.println("\n>> 새로운 텍스트 타이핑 발생(이 시점에서 미래의 Redo 기록은 삭제되어야 함.)");
        typeText(history, redoList, "문장 4(새로운 미래) 입력");
        printStatus(history, redoList);

    }

    private static void redo(Deque<String> history, Deque<String> redoList) {
        if(!redoList.isEmpty()) {
            String redone = redoList.pop();
            history.push(redone);
        } else {
            System.out.println("다시 실행할 작업이 없습니다.");
        }
    }

    private static void undo(Deque<String> history, Deque<String> redoList) {
        if(!history.isEmpty()) {
            String undone = history.pop();
            redoList.push(undone);
        } else {
            System.out.println("더 이상 취소할 작업이 없습니다.");
        }
    }

    private static void printStatus(Deque<String> history, Deque<String> redoList) {
        System.out.println("현재 문서(History) [맨앞 = 최신] : " + history);
        System.out.println("다시실행 대기(Redo) [맨앞 = 최신] : " + redoList);
    }

    private static void typeText(Deque<String> history, Deque<String> redoList, String s) {
        history.push(s);
        redoList.clear();
    }


}
