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
        /*
            Boolean.parseBoolean(String s)
            전달된 문자열이 대소문자를 구분하지 않고 "true"와 같으면 기본형 true를 반환하고,
            null이거나 그 외의 모든 문자열을 false를 반환한다.
            예 : "TrUe" -> true, "yes" -> false
         */
        boolean primitiveTrue = Boolean.parseBoolean("True");

        /*
            판별 기준은 parseBoolean과 완전히 동일하지만, 반환 타입이 기본형이 아닌 Boolean 객체이다.
            메모리 절약을 위해 내부적으로 캐싱된 Boolean.TRUE, Boolean.FALSE 상수 객체를 반환한다.
         */
        boolean objectNull = Boolean.valueOf("yes");

        System.out.println("primitiveTrue : " + primitiveTrue);
        System.out.println("objectNull : " + objectNull);

        Boolean wrapperObj = Boolean.valueOf(true);

        /**
         * Boolean 래퍼(Wrapper) 객체 안에 들어있는 기본형 boolean 값을 꺼내어 반환한다. (Unboxing)
         */
        boolean unboxed = wrapperObj.booleanValue();

        /**
         * 전달된 기본형 boolean 값을 "true"또는 "false" 형태의 문자열(String)로 변환하여 반환한다.
         */
        String strFromPrimitive = Boolean.toString(unboxed);
        String strFromObject = wrapperObj.toString();

        System.setProperty("isMultiTenant", "true");

        /**
         * 전달된 문자열 자체를 boolean으로 바꾸는 것이 아니다. 파라미터로 전달된 문자열을 '시스템 속성(System Property)의 이름'으로 간주하여 해당 환경 변수를 찾고,
         * 그 값이 "true"일 때만 true를 반환한다.
         * 인프라나 서버의 설정값을 읽어올 때 사용한다.
         */
        boolean sysProp = Boolean.getBoolean("isMultiTenant");
        boolean parsedProp = Boolean.parseBoolean("isMultiTenant");

        System.out.println("getBoolean : " + sysProp);
        System.out.println("paredProp : " + parsedProp);
    }

    private static void intermediateTask() {

        @SuppressWarnings("removal")
        /**
         * 호출할 때마다 힙 메모리에 새로운 Boolean 객체를 강제로 생성한다. 메모리 낭비가 심하므로 실무에서는 Boolean.valueOf()로 대체해야 한다.
         */
        Boolean b1 = new Boolean(true);

        Boolean b2 = Boolean.valueOf(true);
        Boolean b3 = Boolean.valueOf(true);

        /**
         * 객체 타입(Wrapper)에서 ==는 두 객체가 메모리상 동일한 주소를 가리키고 있는지(동일성)를 비교하고,
         * equals()는 두 객체가 품고있는 실제값이 같은지(동등성)를 비교한다.
         */
        System.out.println("b1 == b2 : " + (b1 == b2));
        System.out.println("b2 == b3 : " + (b2 == b3));
        System.out.println("b1.equals(b2) : " + b1.equals(b2));

        Boolean objTrue = Boolean.valueOf(true);
        Boolean objFalse = Boolean.valueOf(false);

        /**
         * 자신과 대상 객체의 값을 비교한다. 둘이 같으면 0, 자신이 true이고 대상이 false이면 1(양수), 자신이 false이고 대상이 true이면 -1(음수)을 바환한다. (정렬의 기준이 됨)
         */
        System.out.println("objTrue.compareTo(objFalse) : " + objTrue.compareTo(objFalse));
        System.out.println("Boolean.compare(false, true) : " + Boolean.compare(false, true));

        /**
         * true일 경우 1231, false일 경우 1237이라는 자바 표준의 정의된 고정 정수 값을 반환한다.
         */
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

        /**
         * 두 기본형 값에 대해 각각 논리곱(AND, 둘 다 참일 때 참), 논리합(OR, 하나라도 참이면 참), 배타적 논리합(XOR, 서로 값이 다를 때만 참) 연산을 수행한다.
         * &&, ||, ^ 기호를 메서드 형태로 풀어낸 것이다.
         */
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
