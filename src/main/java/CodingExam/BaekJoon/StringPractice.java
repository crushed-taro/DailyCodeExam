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

        System.out.println("=== 문자열 복원 ===");
        advancedTask();
        System.out.println();
    }

    private static void beginnerTask() {
        String filePath = "/var/log/app.tenant_error.log";

        /**
         * 문자열의 전체 길이(문자의 개수)를 int형으로 반환한다. 배열의 length 속성과 달리 괄호가 있는 메서드임에 주의해야 한다.
         */
        int length = filePath.length();

        /**
         * 문자열에서 지정된 인덱스 위치에 있는 단일 문자(char)를 반환한다. 인덱스는 0부터 시작한다.
         */
        char firstChar = filePath.charAt(0);
        System.out.println("문자열 길이 : " + length + ", 첫 번째 문자 : " + firstChar);

        int lastSlashIndex = filePath.lastIndexOf("/");

        /**
         * 지정된 시작 인덱스부터 문자열의 끝까지 잘라내어 새로운 문자열을 반환한다.
         * substring(beginIndex, endIndex) 형태로 쓰면 endIndex 직전까지 잘라낸다.
         */
        String fileName = filePath.substring(lastSlashIndex + 1);
        System.out.println("추출된 파일명 : " + fileName);

        String url = "https://api.SaaS-platform.com";

        /**
         * 문자열이 특정 문자열(접두사/접미사)로 시작하는지 혹은 끝나는지 여부를 boolean으로 반환한다.
         * URL 프로토콜이나 파일 확장자 검사 시 자주 사용된다.
         */
        boolean isSecure = url.startsWith("https://");
        boolean isDotCom = url.endsWith(".com");
        System.out.println("HTTPS 여부 : " + isSecure + ", .com 종료 여부 : " + isDotCom);

        /**
         * 문자열 내부에 지정된 문자열이 포함되어 있는지 여부를 찾아 boolean으로 반환한다.
         */
        boolean hasTenant = url.contains("tenant");

        /**
         * indexOf는 문자열의 앞에서부터, lastIndexOf는 뒤에서부터 탐색하여 지정된 문자열이 처음 발견되는 시작 인덱스(int)를 반환한다.
         * 만약 찾지 못하면 예외를 던지지 않고 -1을 반환한다.
         */
        int tenantPos = url.indexOf("tenant");
        System.out.println("contains 결과 : " + hasTenant + ", indexOf 결과 : " + tenantPos);
    }

    private static void intermediateTask() {
        String userInput = "   eXiT   ";

        /**
         * 문자열의 맨 앞과 맨 뒤에 있는 공백(whitespace, 줄바꿈, 탭 포함)을 모두 제거한 새로운 문자열을 반환한다.
         * 문자열 중간에 있는 공백은 건드리지 않는다.
         */
        String cleanInput = userInput.trim();

        /**
         * equals는 대소문자를 완벽히 구분하여 비교하고,
         * equalsIgnoreCase는 대소문자 차이를 무시하고 알파벳 내용이 같은지만 비교하여 boolean을 반환한다.
         */
        boolean isExit = cleanInput.equalsIgnoreCase("EXIT");
        System.out.println("명령어 일치 여부 : " + isExit);

        String text = "서비스의 IP 주소는 192.168.0.1 입니다.";

        /**
         * 지정된 문자열(target)을 찾아 모두 새로운 문자열로 바꾼다.
         * 정규표현식을 인식하지 않고 적힌 문자 그대로(Literal)만 찾아 변경한다.
         */
        String literalReplace = text.replace("[0-9]", "X");

        /**
         * 정규표형식(Regex) 패턴을 인식하여, 패턴에 일치하는 모든 문자열을 새로운 문자열로 바꾼다.
         * 비밀번호 마스킹 등 복잡한 치환에 필수적
         */
        String regexReplace = text.replaceAll("[0-9]", "X");
        System.out.println("replace 결과 : " + literalReplace);
        System.out.println("replaceAll 결과 : " + regexReplace);

        String csvData = "Samsung,SL-C563FW,Printer,12000";

        /**
         * 전달된 정규표현식 구분자를 기준으로 문자열을 여러 조각으로 쪼개어 문자열 배열(String[])로 반환한다.
         */
        String[] tokens = csvData.split(",");
        System.out.println("분리된 데이터 : " + Arrays.toString(tokens));

        /**
         * split의 반대 역할을 한다. 배열이나 리스트 등의 여러 문자열 사이에 지정한 구문자(delimiter)를 끼워 넣어 하나의 문자열로 결합한다.
         */
        String joinedData = String.join("-", tokens);
        System.out.println("재결합된 데이터 : " + joinedData);

        int pageCount = 350;

        /**
         * 숫자(int, double 등)나 불리언 객체 등을 문자열(String) 타입으로 변환한다.
         * 파라미터가 null일 경우 "null"이라는 문자열을 안전하게 반환한다.
         */
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

        /**
         * 문자열의 모든 영문자를 대문자 혹은 소문자로 변환한 새로운 문자열을 반환한다.
         * toLowerCase()
         */
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

        /**
         * C언어의 printf와 유사하게 동작한다. %s(문자열), %d(정수) 등의 포맷 명시자가 포함된 틀(format)을 먼저 적고, 뒤에 올 변수들을 순서대로 매핑하여 조립된 완성 문자열을 반환한다.
         */
        String finalLogFormat = String.format("[%s] %s -> %s", logParts[1].toUpperCase(), logParts[0], logParts[3]);

        System.out.println("--- 마스킹 및 포맷팅 완료된 로그 ---");
        System.out.println(finalLogFormat);

        if (finalLogFormat.endsWith("}")) {
            System.out.println("[검증] 로그 데이터가 닫는 중괄호로 안전하게 끝납니다.");
        }

    }

    private static void advancedTask() {
        System.out.println("버퍼 데이터를 문자열로 복원합니다.");

        char[] dataBuffer = {'E', 'R', 'R', 'O', 'R', ':', '4', '0', '4', '\u0000'};

        /**
         * 문자 배열(char[])의 특정 부분(offset 인덱스부터 count 개수만큼)만 추출하여 새로운 문자열 객체로 조립해 반환한다.
         * 파일 입출력이나 네트워크 통신 시 버퍼(Buffer) 데이터를 문자열로 변환할 때 사용된다.
         */
        String fullString = String.copyValueOf(dataBuffer);
        System.out.println("전체 버퍼 변환 : [" + fullString + "]");

        int startIndex = 6;
        int readCount = 3;
        String errorCode = String.copyValueOf(dataBuffer, startIndex, readCount);

        System.out.println("추출된 에러 코드 : " + errorCode);

        String usingValueOf = String.valueOf(dataBuffer, startIndex, readCount);
        System.out.println("valueOf 결과와 동일한가? : " + errorCode.equals(usingValueOf));
    }

}
