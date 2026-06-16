package CodingExam.BaekJoon;

public class StringBuilderPractice {

    public static void main(String[] args) {
        System.out.println("=== 문자열 조립과 내부 공간 === ");
        beginnerTask();
        System.out.println();
        System.out.println("=== 문자열 자유자재로 편집하기 === ");
        intermediateTask();
        System.out.println();
        System.out.println("=== 동적 SQL 쿼리 빌더 === ");
        miniProject();
    }

    private static void beginnerTask() {
        StringBuilder stringBuilder = new StringBuilder();

        /**
         * 현재 버퍼 안에 실제로 조립되어 들어있는 문자열의 길이(문자 개수)를 반환한다.
         */
        System.out.println("초기 길이 : " + stringBuilder.length());

        /**
         * 현재 버퍼가 메모리상에 확보하고 있는 전체 공간(용량)을 반환한다.
         * 기본적으로 빈 생성자 호출 시 16의 공간을 가지며, 글자가 계속 추가되어 용량을 초과하면 자바가 알아서 내부적으로 기존 용량의 2배 + 2만큼 공간을 늘려준다.
         */
        System.out.println("초기 용량 : " + stringBuilder.capacity());

        String userName = "Admin";
        int pageCount = 2500;
        boolean isConnected = true;

        /**
         * 문자열의 맨 뒤에 데이터를 이어 붙인다. 내부 배열의 빈칸에 문자를 순서대로 채워 넣기만 하므로 처리 속도가 매우 빠르다.
         * 반환값으로 자기 자신(this)을 돌려주기 때문에 .append().append() 형태의 메서드 체이닝(Method Chaining)이 가능하다.
         */
        stringBuilder.append(userName)
                .append(pageCount)
                .append(isConnected);

        System.out.println("추가 후 길이 : " + stringBuilder.length());
        System.out.println("추가 후 용량 : " + stringBuilder.capacity());

        /**
         * 버퍼 안에서 조립하고 수정했던 문자열 조각들을 최종적으로 굳혀서, 일반적인 불면(Immutable) 객체인 String 타입으로 변환하여 반환한다.
         */
        System.out.println("최종 결과 : " + stringBuilder.toString());
    }

    private static void intermediateTask() {
        StringBuilder stringBuilder = new StringBuilder("프린터 관리 시스템");

        /**
         * 지정된 인덱스(offset) 위치에 데이터를 끼워 넣는다.
         * 해당 위치부터 뒤에 있던 기존 문자열들은 공간이 확보되며 자연스럽게 뒤로 밀려난다.
         */
        stringBuilder.insert(0, "[B2B SaaS] ");
        System.out.println("insert 후 : " + stringBuilder.toString());

        /**
         * start 인덱스부터 end 직전(end - 1) 인덱스까지의 문자열 구간을 삭제한다.
         * 뒤에 남은 문자열은 자동으로 앞으로 당겨진다.
         */
        stringBuilder.delete(stringBuilder.indexOf("관리 "), stringBuilder.indexOf("관리 ") + "관리 ".length());
        System.out.println("delete 후 : " + stringBuilder.toString());

        /**
         * start 인덱스부터 end 직전까지의 구간을 완전히 도려내고, 그 자리에 새로운 문자열(str)을 덮어씌운다.
         * String 클래스의 replace가 '단어'를 찾아 바꾼다면, StringBuilder의 replace는 '인덱스 구간'을 지정해서 바꾼다는 결정적인 차이가 있다.
         */
        stringBuilder.replace(stringBuilder.indexOf("시스템"), stringBuilder.indexOf("시스템") + "시스템".length(), "플랫폼");
        System.out.println("replace 후 : " + stringBuilder.toString());

        /**
         * 현재 버퍼 안에 있는 전체 문자열의 순서를 완전히 거꾸로 뒤집는다.
         * (알고리즘 문제에서 문자열을 뒤집거나 팰린드롬을 검사할 때 매우 유용하다.)
         * 팰린드롬(Palindrome) - '회문', 앞으로 읽으나 뒤로 읽으나 똑같은 단어, 문장, 숫자 또는 문자열
         */
        stringBuilder.reverse();
        System.out.println("revers 후 : " + stringBuilder.toString());
    }

    private static void miniProject() {
        String tenantId = "T-9901";
        String manufacturer = "Samsung";
        boolean hasError = true;

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM printer_devices WHERE 1=1");

        if (tenantId != null && !tenantId.isEmpty()) {
            queryBuilder.append(" AND tenant_id = '").append(tenantId).append("' ");
        }

        if (manufacturer != null && manufacturer.isEmpty()) {
            queryBuilder.append(" AND manufacturer = '").append(manufacturer).append("' ");
        }

        if (hasError) {
            queryBuilder.append(" AND error_status = '").append(true).append("' ");
        }

        queryBuilder.append(" AND ");

        if (queryBuilder.toString().endsWith(" AND ")) {
            queryBuilder.delete(queryBuilder.length() - " AND ".length(), queryBuilder.length());
        }

        System.out.println("완성된 동적 쿼리");
        System.out.println(queryBuilder.toString());

        /**
         * 버퍼의 논리적 문자열 길이를 강제로 조정한다.
         * setLength(0) - 길이를 0으로 맞추면 내부 문자열이 모두 없는 것으로 처리된다.
         *                반복문 안에서 쿼리나 문자열을 계속 새로 만들어야 할 때,
         *                매번 new StringBuilder()로 객체를 새로 생성하지 않고 기존 객체를 0으로 초기화하여 재사용함으로써 메모리를 극적으로 절약할 수 있다.
         */
        queryBuilder.setLength(0);

        queryBuilder.append("SELECT COUNT(*) FROM printer_devices");

        System.out.println("재사용 쿼리 : " + queryBuilder.toString());
    }

}
