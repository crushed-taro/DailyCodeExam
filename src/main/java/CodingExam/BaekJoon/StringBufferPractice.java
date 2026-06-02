package CodingExam.BaekJoon;

public class StringBufferPractice {

    // StringBuilder : 동기화 처리가 안 되어 있어 속도가 매우 빠르지만, 여러 스레드가 접근하면 데이터가 꼬이거나 유실됨.
    // StringBuffer : 내부에 모든 주요 메서드에 synchronized 키워드가 붙어 있어, '멀티스레드 환경에서도 안전하게 데이터를 보호'하지만 속도는 상대적으로 조금 느림.

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== 기본 API 복습 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== Thread-Safe 동기화 테스트 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 안전한 통합 로그 수집기 ===");
        miniProject();
        System.out.println();
    }

    private static void beginnerTask() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("SaaS ")
                .append("Platform");

        System.out.println("정상 추가 : " + stringBuffer.toString());

        stringBuffer.reverse();
        System.out.println("뒤집기 결과 : " + stringBuffer.toString());
    }

    private static void intermediateTask() throws InterruptedException {
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    try {
                        builder.append("A");
                        buffer.append("A");
                    } catch (Exception e) {

                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("목표 길이 : 10000");
        System.out.println("StringBuilder 실제 길이 : " + builder.length());
        System.out.println("StringBuffer 실제 길이 : " + buffer.length());
    }

    private static void miniProject() throws InterruptedException {
        StringBuffer sharedLogBuffer = new StringBuffer();

        sharedLogBuffer.append("--- 시스템 통합 로그 시작 ---\n");

        Thread worker1 = new Thread(() -> writeLog(sharedLogBuffer, "Worker-1", "테넌트 A 인증 처리 완료"));
        Thread worker2 = new Thread(() -> writeLog(sharedLogBuffer, "Worker-2", "테넌트 B 프린터 상태 조회 완료"));
        Thread worker3 = new Thread(() -> writeLog(sharedLogBuffer, "Worker-3", "테넌트 C 결제 연동 실패"));

        worker1.start();
        worker2.start();
        worker3.start();

        worker1.join();
        worker2.join();
        worker3.join();

        System.out.println(sharedLogBuffer.toString());
    }

    private static void writeLog(StringBuffer buffer, String workerName, String message) {
        buffer.append("[" + workerName + "] " + message + " \n");
    }
}
