package CodingExam.BaekJoon;

public class BooleanPractice {

    public static void main(String[] args) {
        System.out.println("=== 변환 및 시스템 속성 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 비교, 해시코드, 논리 연산 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 태넌트 권한 및 설정 관리 ===");
        miniProject();
    }

    private static void beginnerTask() {
        boolean primitiveTrue = Boolean.parseBoolean("True");
        boolean objectNull = Boolean.valueOf("yes");

        System.out.println("primitiveTrue : " + primitiveTrue);
        System.out.println("objectNull : " + objectNull);

        Boolean wrapperObj = Boolean.valueOf(true);
        boolean unboxed = wrapperObj.booleanValue();

        String strFromPrimitive = Boolean.toString(unboxed);
        String strFromObject = wrapperObj.toString();

        System.setProperty("isMultiTenant", "true");
        boolean sysProp = Boolean.getBoolean("isMultiTenant");
        boolean parsedProp = Boolean.parseBoolean("isMultiTenant");

        System.out.println("getBoolean : " + sysProp);
        System.out.println("paredProp : " + parsedProp);
    }

    private static void intermediateTask() {
        @SuppressWarnings("removal")
        Boolean b1 = new Boolean(true);

        Boolean b2 = Boolean.valueOf(true);
        Boolean b3 = Boolean.valueOf(true);

        System.out.println("b1 == b2 : " + (b1 == b2));
        System.out.println("b2 == b3 : " + (b2 == b3));
        System.out.println("b1.equals(b2) : " + b1.equals(b2));

        Boolean objTrue = Boolean.valueOf(true);
        Boolean objFalse = Boolean.valueOf(false);

        System.out.println("objTrue.compareTo(objFalse) : " + objTrue.compareTo(objFalse));
        System.out.println("Boolean.compare(false, true) : " + Boolean.compare(false, true));

        System.out.println("true의 해시코드 (정적) : " + Boolean.hashCode(true));
        System.out.println("false의 해시코드 (인스턴스) : " + objFalse.hashCode());

        boolean isPrinterConnected = true;
        boolean hasNetworkError = false;

        boolean isReady = Boolean.logicalAnd(isPrinterConnected, Boolean.logicalXor(hasNetworkError, true));
        System.out.println("장비 준비 상태 : " + isReady);

    }

    private static void miniProject() {
        System.setProperty("tenant.maintenance", "false");
        boolean isMaintenance = Boolean.getBoolean("tenant.maintenance");

        String inputAdmin = "TRUE";
        String inputPaid = "true";

        boolean isAdmin = Boolean.parseBoolean(inputAdmin);
        Boolean isPaid = Boolean.valueOf(inputPaid);

        boolean hasAccessLevel = Boolean.logicalOr(isAdmin, isPaid.booleanValue());
        boolean isAccessible = Boolean.logicalAnd(hasAccessLevel, Boolean.logicalXor(isMaintenance, true));

        System.out.println("테넌트 접속 로그");
        System.out.println("관리자 여부 : " + Boolean.toString(isAdmin));
        System.out.println("결제 상태 : " + isPaid.toString());
        System.out.println("유지보수 상태 : " + isMaintenance);
        System.out.println("최종 서비스 접근 허용 : " + isAccessible);

        Boolean expectedAccess = Boolean.valueOf(true);
        if (expectedAccess.equals(isAccessible)) {
            System.out.println("[시스템] 권한 부여가 정상적으로 게산되었습니다.");
        }
    }
}
