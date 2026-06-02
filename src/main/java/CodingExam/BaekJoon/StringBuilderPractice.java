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
        System.out.println("초기 길이 : " + stringBuilder.length());
        System.out.println("초기 용량 : " + stringBuilder.capacity());

        String userName = "Admin";
        int pageCount = 2500;
        boolean isConnected = true;

        stringBuilder.append(userName)
                .append(pageCount)
                .append(isConnected);

        System.out.println("추가 후 길이 : " + stringBuilder.length());
        System.out.println("추가 후 용량 : " + stringBuilder.capacity());
        System.out.println("최종 결과 : " + stringBuilder.toString());
    }

    private static void intermediateTask() {
        StringBuilder stringBuilder = new StringBuilder("프린터 관리 시스템");

        stringBuilder.insert(0, "[B2B SaaS] ");
        System.out.println("insert 후 : " + stringBuilder.toString());

        //                                          4                              4     + 3
        stringBuilder.delete(stringBuilder.indexOf("관리 "), stringBuilder.indexOf("관리 ") + "관리 ".length());
        System.out.println("delete 후 : " + stringBuilder.toString());

        stringBuilder.replace(stringBuilder.indexOf("시스템"), stringBuilder.indexOf("시스템") + "시스템".length(), "플랫폼");
        System.out.println("replace 후 : " + stringBuilder.toString());

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

        queryBuilder.setLength(0);

        queryBuilder.append("SELECT COUNT(*) FROM printer_devices");

        System.out.println("재사용 쿼리 : " + queryBuilder.toString());
    }

}
