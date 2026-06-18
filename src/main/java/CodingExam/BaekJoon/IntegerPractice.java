package CodingExam.BaekJoon;

public class IntegerPractice {

    public static void main(String[] args) {
        System.out.println("=== 변환 및 진수 처리 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 객체 비교와 캐싱, 유틸리티 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 인프라 환경 설정 파서 ===");
        miniProject();
        System.out.println();
        System.out.println("=== 비트 단위 옵션 활성화 개수 파악 ===");
        advancedTask();
        System.out.println();
    }

    private static void beginnerTask() {
        String portStr = "8080";

        /**
         * 전달된 문자열을 순수한 기본형 정수(int)로 변환하여 반환.
         * 문자열에 숫자 외의 문자가 섞여 있거나 빈 문자열일 경우 'NumberFormatException' 에러가 발생.
         */
        int primitivePort = Integer.parseInt(portStr);

        /**
         * parseInt와 역할은 같으나 반환 타입이 기본형 int가 아닌 Integer 래퍼(Wrapper) 객체.
         */
        Integer objectPort = Integer.valueOf(portStr);
        System.out.println("기본형 포트 : " + primitivePort);
        System.out.println("객체형 포트 : " + objectPort);

        /**
         * Integer 객체 안에 포장되어 있는 기본형 int 값을 밖으로 꺼내어 반환. (Unboxing)
         */
        int unboxedPort = objectPort.intValue();

        /**
         * 기본 10진수 정수를 각각 2진수(Binary)와 16진수(Hex) 형태의 문자열(String)로 변환하여 반환.
         * 인프라 설정, 네트워크 패킷, 색상 코드 등을 다룰 때 유용.
         */
        int permissionMask = 255;
        System.out.println("255의 2진수 : " + Integer.toBinaryString(permissionMask));
        System.out.println("255의 16진수 : " + Integer.toHexString(permissionMask));

        /**
         * 두 번째 파라미터인 radix(진법)을 기준으로 문자열을 해석하여 10진수 int로 변환.
         * 예를 들어 "1A"를 16진수(16)로 읽거나, "1011"을 2진수(2)로 읽어 일반적인 10진수 값으로 돌려줌.
         */
        int hexPared = Integer.parseInt("1A", 16);
        int binaryParsed = Integer.parseInt("1011", 2);
        System.out.println("1A(16진수) -> 10진수 : " + hexPared);
        System.out.println("1011(2진수) -> 10진수 : " + binaryParsed);

    }

    private static void intermediateTask() {

        /**
         * 자바는 메모리 절약을 위해 -128부터 127까지의 정수 객체는 미리 만들어 두고 재사용(Caching)함.
         * 따라서 100을 두 번 만들면 같은 메모리 주소를 가리키므로 '==' 연산 결과가 true.
         *
         * 하지만 200처럼 캐시 범위를 벗어난 값은 매번 new Integer()로 새로운 객체를 힙 메모리에 찍어내므로
         * 메모리 주소가 달라 '==' 연산 시 false가 나옴.
         * 결론적으로 객체 래퍼 타입의 값 비교는 무조건 equals()를 사용해야 안전.
         */
        Integer a = 100;
        Integer b = 100;
        System.out.println("a == b : " + (a == b));
        System.out.println("a == b : " + (a.equals(b)));

        Integer c = 200;
        Integer d = 200;
        System.out.println("c == d : " + (c == d));
        System.out.println("c == d : " + (c.equals(d)));
        /*
        Integer는 객체라서 ==는 값 비교가 아니라 참조 주소 비교

        200은 기본 캐시 범위를 벗어남

        그래서 각각 새로운 Integer 객체가 만들어짐.

        따라서 Integer, String 같은 객체 타입에서 '값'을 비교할 때는 보통 equals()를 사용.
         */

        /**
         * 두 정수 중 큰 값, 작은 값, 혹은 두 수의 합을 반환.
         * 내부적으로는 Math.max()등과 완전히 똑같이 동작하지만, Java 8의 스트림이나 람다식(메서드 참조, Integer::sum 등)에서 직관적이고 깔끔하게 쓰기 위해 추가된 유틸리티 메서드
         */
        int val1 = 45;
        int val2 = 80;
        System.out.println("최대값 : " + Integer.max(val1, val2));
        System.out.println("최솟값 : " + Integer.min(val1, val2));
        System.out.println("합계 : " + Integer.sum(val1, val2));

        /**
         * int 자료형이 담을 수 있는 최댓값인 2147483647을 의미
         * 여기에 1을 더하면 최솟값(-2147483648)으로 뒤집혀 버리는 오버플로우(Overflow) 현상이 발생하므로, 돈이나 큰 조회수를 다룰 때는 long타입을 서야 함을 주의.
         */
        int maxInt = Integer.MAX_VALUE;
        System.out.println("int 최대값 : " + maxInt);
        System.out.println("int 최대값 + 1 (OverFlow) : " + (maxInt + 1));
    }

    private static void miniProject() {
        String rawPort = "5672";
        String rawMemoryHex = "400";
        String rawPermissionBin = "1101";

        System.out.println("--- 설정 파일을 시작합니다. ---");

        int port = Integer.parseInt(rawPort);
        int memoryLimit = Integer.parseInt(rawMemoryHex, 16);
        int permissions = Integer.parseInt(rawPermissionBin, 2);

        boolean isPortValid = (port >= 0) && (port <= 65535);

        if (!isPortValid) {
            System.out.println("포트 번호가 유효하지 않습니다. : " + port);
        }

        int minRequiredMemory = 512;
        boolean isMemoryEnough = (Integer.max(memoryLimit, minRequiredMemory) == memoryLimit);

        System.out.println("--- 적용된 인프라 설정 ---");
        System.out.println("통신 포트 : " + port + " (Valid : " + isPortValid + ")");
        System.out.println("메모리 한도 : " + memoryLimit + "MB (요구사항 충족 : " + isMemoryEnough + ")");
        System.out.println("권한 플래스(10진수) : " + permissions);

        String verifyBin = Integer.toBinaryString(permissions);
        System.out.println("권한 플래그 원본 역검증 일치 여부 : " + verifyBin.equals(rawPermissionBin));

    }

    private static void advancedTask() {
        int permissions = Integer.parseInt("1101", 2);
        int activeRoles = Integer.bitCount(permissions);

        System.out.println("권한 플래그 원본 (2진수) : " + Integer.toBinaryString(permissions));
        System.out.println("현재 부여된 총 권한의 개수 : " + activeRoles + "개");

        /**
         * 주어진 정수를 2진수로 변했을 때, 숫자 1이 몇 개 존재하는지(켜져 있는 비트의 수)를 세어서 반환.
         * 권한 부여 개수 확인. IP 서브넷 마스크의 네트워크 대역 길이를 구할 때 복잡한 반복문 없이 한 줄로 계산해주는 메서드
         */
        int subnetMask = 0xFFFFFF00;
        int networkPrefix = Integer.bitCount(subnetMask);

        System.out.println("\n서브넷 마스크 (16진수) : " + Integer.toHexString(subnetMask).toUpperCase());
        System.out.println("네트워크 대역(CIDR) : /" + networkPrefix);
    }

}
