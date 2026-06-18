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

        /**
         * append, reverse, length
         * 전달된 데이터를 내부 버퍼에 추가하거나 뒤집거나 길이를 반환.
         *
         * 차이점 Synchronized 키워드 - StringBuffer의 이 메서드들 앞에는 모두 synchronized라는 동기화 키워드가 붙어 있음.
         *                           어떤 스레드가 append를 실행하는 동안, 객체에 '잠금(Lock)'을 걸어 다른 스레드가 절대 접근하지 못하게 막고 대기시킴.
         *                           이로 인해 데이터 유실은 없지만 잠금을 걸고 푸는 비용 때문에 단일 스레드 환경에서는 StringBuilder보다 속도가 떨어짐.
         */
        stringBuffer.append("SaaS ")
                .append("Platform");

        /**
         * 조림된 내부 버퍼를 불변 객체인 String으로 반환.
         * 이 과정 역시 동기화되어 있어 반환 도중 버퍼가 변경되는 것을 방지.
         */
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

        /**
         * new Thread(() -> { ... })
         * 람다식을 사용하여 새로운 독립적인 작업 흐름(스레드)을 생성합니다.
         * B2B SaaS 환경에서 수많은 테넌트의 요청이 동시에 들어오는 상황(비동기 워커)을 시뮬레이션할 때 자주 사용.
         */
        Thread worker1 = new Thread(() -> writeLog(sharedLogBuffer, "Worker-1", "테넌트 A 인증 처리 완료"));
        Thread worker2 = new Thread(() -> writeLog(sharedLogBuffer, "Worker-2", "테넌트 B 프린터 상태 조회 완료"));
        Thread worker3 = new Thread(() -> writeLog(sharedLogBuffer, "Worker-3", "테넌트 C 결제 연동 실패"));

        /**
         * 생성된 스레드를 운영체제(OS)의 스케줄러에 등록하여 실제로 병렬 실행을 시작.
         */
        worker1.start();
        worker2.start();
        worker3.start();

        /**
         * 메인 스레드(main)가 특정 스레드의 작업이 완전히 끝날 때까지 멈춰서 기다리게(블로킹) 만듦.
         * 이 메서드가 없으면, 10개의 스레드가 A를 다 찍기도 전에 메인 스레드가 'System.out.println(builder.length())'를 먼저 실행해 버려 정확한 결과를 확인할 수 없음.
         */
        worker1.join();
        worker2.join();
        worker3.join();

        System.out.println(sharedLogBuffer.toString());
    }

    private static void writeLog(StringBuffer buffer, String workerName, String message) {
        buffer.append("[" + workerName + "] " + message + " \n");
    }
}
