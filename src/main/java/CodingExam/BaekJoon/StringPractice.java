package CodingExam.BaekJoon;

import java.util.Arrays;

public class StringPractice {

    public static void main(String[] args) {
        System.out.println("=== 탐색 및 추출 ===");
        beginnerTask();
        System.out.println();

        System.out.println("=== 변형, 분리 및 비교 ===");
        intermediateTask();
        System.out.println();

        System.out.println("=== 로그 데이터 마스킹 처리기 ===");
        miniProject();
        System.out.println();
    }

    private static void beginnerTask() {
        String filePath = "/var/log/app.tenant_error.log";

        int length = filePath.length();
        char firstChar = filePath.charAt(0);
        System.out.println("문자열 길이 : " + length + ", 첫 번째 문자 : " + firstChar);

        int lastSlashIndex = filePath.lastIndexOf("/");
        String fileName = filePath.substring(lastSlashIndex + 1);
        System.out.println("추출된 파일명 : " + fileName);

        String url = "https://api.SaaS-platform.com";
        boolean isSecure = url.startsWith("https://");
        boolean isDotCom = url.endsWith(".com");
        System.out.println("HTTPS 여부 : " + isSecure + ", .com 종료 여부 : " + isDotCom);

        boolean hasTenant = url.contains("tenant");
        int tenantPos = url.indexOf("tenant");
        System.out.println("contains 결과 : " + hasTenant + ", indexOf 결과 : " + tenantPos);
    }

    private static void intermediateTask() {
        String userInput = "   eXiT   ";
        String cleanInput = userInput.trim();
        boolean isExit = cleanInput.equalsIgnoreCase("EXIT");
        System.out.println("명령어 일치 여부 : " + isExit);

        String text = "서비스의 IP 주소는 192.168.0.1 입니다.";
        String literalReplace = text.replace("[0-9]", "X");
        String regexReplace = text.replaceAll("[0-9]", "X");
        System.out.println("replace 결과 : " + literalReplace);
        System.out.println("replaceAll 결과 : " + regexReplace);

        String csvData = "Samsung,SL-C563FW,Printer,12000";
        String[] tokens = csvData.split(",");
        System.out.println("분리된 데이터 : " + Arrays.toString(tokens));

        String joinedData = String.join("-", tokens);
        System.out.println("재결합된 데이터 : " + joinedData);

        int pageCount = 350;
        String strCount = String.valueOf(pageCount);
        System.out.println("문자열 변환 검증 : " + strCount.equals("350"));
    }

    private static void miniProject() {
        // timestamp, level, api_path, payload
        String rawLog = "2026-06-01 23:40:00 | info | /api/v1/tenant/setup | {"
                + "tenantId=T1002, "
                + "dbPassword=secretPass123, "
                + "managerEmail=admin@tenant.com} ";

        String trimmedLog = rawLog.trim();

        String[] logParts = trimmedLog.split("\\|");
        // System.out.println(Arrays.toString(logParts));

        for (int i = 0; i < logParts.length; i++) {
            logParts[i] = logParts[i].trim();
        }
        System.out.println(Arrays.toString(logParts));

        String logLevel = logParts[1].toUpperCase();
        if("INFO".equals(logLevel)) {
            System.out.println("[시스템 내부 안내] 일반 정보 로그를 파싱합니다.");
        }

        String payload = logParts[3];
        String maskedPayload = payload;

        if (payload.contains("dbPassword=")) {
            maskedPayload = maskedPayload.replaceAll("dbPassword=[^,}\\s]+", "dbPassword=********");
        }
        logParts[3] = maskedPayload;

        String finalLogFormat = String.format("[%s] %s -> %s", logParts[1].toUpperCase(), logParts[0], logParts[3]);

        System.out.println("--- 마스킹 및 포맷팅 완료된 로그 ---");
        System.out.println(finalLogFormat);

        if (finalLogFormat.endsWith("}")) {
            System.out.println("[검증] 로그 데이터가 닫는 중괄호로 안전하게 끝납니다.");
        }

    }
}
