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

        /**
         * 자바에서 소스 코드에 적힌 모든 정수 숫자는 기본적으로 int 타입으로 인식.
         * 2147483648처럼 int의 최댓값(약 21억)을 넘는 숫자를 그냥 적으면 컴파일 에러가 발생.
         * 반드시 숫자 끝에 대문자 L(또는 소문자 l, 가독성을 위해 대문자 권장)을 붙여 자바 컴파일러에게
         * "이 숫자는 처음부터 64비트 long타입" 선언해줘야 함.
         */
        long correctLong = 2147483648L;
        System.out.println("int 초과 숫자 : " + correctLong);

        String timestampStr = "1717500000000";

        /**
         * 문자열을 순수한 기본형 long 타입으로 변환하여 반환.
         * DB의 PK값이나 밀리초 단위의 타임스탬프를 파싱할 때 가장 많이 사용.
         */
        long primitiveTime = Long.parseLong(timestampStr);
        Long objectTime = Long.valueOf(timestampStr);

        System.out.println("기본형 파싱 : " + primitiveTime);
        System.out.println("객체형 파싱 : " + objectTime);

        /**
         * Long 객체 안에 포장되어 있는 기본형 long 값을 밖으로 꺼내어 반환. (Unboxing)
         */
        long unboxed = objectTime.longValue();
    }

    private static void intermediateTask() {

        /**
         * Integer와 완벽히 동일하게, 메모리 절약을 위해 -128부터 127까지의 Long 객체는 미리 만들어두고 재사용.
         * 100L은 == 비교 시 true가 나오지만, 범위를 벗어난 1000L은 서로 다른 객체이므로 false가 나옴.
         * 값 비교는 무조건 equals()를 사용.
         */
        Long a = 100L;
        Long b = 100L;
        Long c = 1000L;
        Long d = 1000L;
        System.out.println("100L == 100L : " + (a == b));
        System.out.println("1000L == 1000L : " + (c == d));
        System.out.println("1000L.equals(1000L) : " + (c.equals(d)));

        String hugeHash = "18446744073709551615";

        /**
         * 일반적은 long은 맨 앞 1비트를 부호(+, -)에 사용하여 최대 약 992경까지 표현.
         * 이 메서드를 사용하면 부호 비트까지 온전히 숫자로 사용하여 음수 없이 0부터 1,844경까지의 엄청나게 큰 양수로 문자열을 파싱.
         * 분산 시스템의 해시값, 암호화 키, 네트워크 패킷의 체크섬 등을 읽을 때 필수.
         */
        long unsignedHash = Long.parseUnsignedLong(hugeHash);

        System.out.println("일반 출력 (오버플로우로 음수 표현됨) : " + unsignedHash);

        /**
         * parseUnsignedLong으로 읽어 들인 엄청나게 큰 숫자를 그냥 출력하면, 자바는 기본적으로 부호 있는 정수로 해석해 버리기 때문에 맨 앞 비트가 1인 것을 보고
         * 엉뚱한 '음수'로 출력.
         * 이 메서드를 거쳐야만 원래 의도했던 거대한 양수 형태의 문자열로 안전하게 변환되어 출력.
         */
        System.out.println("Unsigned 출력 (정상) : " + Long.toUnsignedString(unsignedHash));
    }

    private static void miniProject() {
        String logData = "TX_889922,1717500000000,18000000000000000000";
        System.out.println("수신된 로그 파싱 시작");

        String[] tokens = logData.split(",");
        String txId = tokens[0];

        long logTimestamp = Long.parseLong(tokens[1]);

        long checksum = Long.parseUnsignedLong(tokens[2]);

        /**
         * 현태 시스템의 시간을 1970년 1월 1일 00:00:00(UTC)부터 현재까지 몇 밀리초(ms)가 흘렀는지 계산하여 long 타입으로 반환.
         * 자바에서 타임스탬프를 다루는 가장 기본적인 형태.
         */
        long currentTime = System.currentTimeMillis();

        /**
         * 두 long 값을 안전하게 비교.
         * x가 크면 양수(1), 같으면 0, 작으면 음수(-1)를 반환.
         *
         * x - y 방식의 단순 뺄셈 비교는 오버플로우를 발생시켜 치명적인 버그를 낼 수 있으므로,
         * 타임스탬프의 전/후 관계를 따질 때 반드시 이 메서드를 사용.
         */
        int timeCompareResult = Long.compare(logTimestamp, currentTime);

        String timeStatus = (timeCompareResult <= 0) ? "정상(과거/현재)" : "오류(미래의 시간)";

        System.out.println("--- 로그 분석 결과 ---");
        System.out.println("트랜잭션 ID : " + txId);
        System.out.println("발생 타임스탬프 : " + logTimestamp + " (" + timeStatus + ")");
        System.out.println("보안 체크섬 : " + Long.toUnsignedString(checksum));
    }

}
