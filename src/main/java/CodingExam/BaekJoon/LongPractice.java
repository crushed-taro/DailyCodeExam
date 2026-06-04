package CodingExam.BaekJoon;

import java.io.PrintWriter;

public class LongPractice {

    public static void main(String[] args) {
        System.out.println("=== L 접미사와 기본 변환 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 캐싱 및 Unsigned(부호 없는) 처리 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 분산 시스템 로그 분석기 ===");
        miniProject();
        System.out.println();
    }

    private static void beginnerTask() {
        long correctLong = 2147483648L;
        System.out.println("int 초과 숫자 : " + correctLong);

        String timestampStr = "1717500000000";
        long primitiveTime = Long.parseLong(timestampStr);
        Long objectTime = Long.valueOf(timestampStr);

        System.out.println("기본형 파싱 : " + primitiveTime);
        System.out.println("객체형 파싱 : " + objectTime);

        long unboxed = objectTime.longValue();
    }

    private static void intermediateTask() {
        Long a = 100L;
        Long b = 100L;
        Long c = 1000L;
        Long d = 1000L;
        System.out.println("100L == 100L : " + (a == b));
        System.out.println("1000L == 1000L : " + (c == d));
        System.out.println("1000L.equals(1000L) : " + (c.equals(d)));

        String hugeHash = "18446744073709551615";

        long unsignedHash = Long.parseUnsignedLong(hugeHash);

        System.out.println("일반 출력 (오버플로우로 음수 표현됨) : " + unsignedHash);
        System.out.println("Unsigned 출력 (정상) : " + Long.toUnsignedString(unsignedHash));
    }

    private static void miniProject() {
        String logData = "TX_889922,1717500000000,18000000000000000000";
        System.out.println("수신된 로그 파싱 시작");

        String[] tokens = logData.split(",");
        String txId = tokens[0];

        long logTimestamp = Long.parseLong(tokens[1]);

        long checksum = Long.parseUnsignedLong(tokens[2]);

        long currentTime = System.currentTimeMillis();
        int timeCompareResult = Long.compare(logTimestamp, currentTime);

        String timeStatus = (timeCompareResult <= 0) ? "정상(과거/현재)" : "오류(미래의 시간)";

        System.out.println("--- 로그 분석 결과 ---");
        System.out.println("트랜잭션 ID : " + txId);
        System.out.println("발생 타임스탬프 : " + logTimestamp + " (" + timeStatus + ")");
        System.out.println("보안 체크섬 : " + Long.toUnsignedString(checksum));
    }

}
