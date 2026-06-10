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

        int primitivePort = Integer.parseInt(portStr);
        Integer objectPort = Integer.valueOf(portStr);
        System.out.println("기본형 포트 : " + primitivePort);
        System.out.println("객체형 포트 : " + objectPort);

        int unboxedPort = objectPort.intValue();

        int permissionMask = 255;
        System.out.println("255의 2진수 : " + Integer.toBinaryString(permissionMask));
        System.out.println("255의 16진수 : " + Integer.toHexString(permissionMask));

        int hexPared = Integer.parseInt("1A", 16);
        int binaryParsed = Integer.parseInt("1011", 2);
        System.out.println("1A(16진수) -> 10진수 : " + hexPared);
        System.out.println("1011(2진수) -> 10진수 : " + binaryParsed);

    }

    private static void intermediateTask() {
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

        int val1 = 45;
        int val2 = 80;
        System.out.println("최대값 : " + Integer.max(val1, val2));
        System.out.println("최솟값 : " + Integer.min(val1, val2));
        System.out.println("합계 : " + Integer.sum(val1, val2));

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

        int subnetMask = 0xFFFFFF00;
        int networkPrefix = Integer.bitCount(subnetMask);

        System.out.println("\n서브넷 마스크 (16진수) : " + Integer.toHexString(subnetMask).toUpperCase());
        System.out.println("네트워크 대역(CIDR) : /" + networkPrefix);
    }

}
