package CodingExam.BaekJoon;

public class CharacterPractice {

    public static void main(String[] args) {
        System.out.println("=== 문자 종류 판별 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 대소문자 변환 및 수치형 변환 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 장비 원시 데이터 파서 ===");
        miniProject();
        System.out.println();
    }

    private static void beginnerTask() {
        char numChar = '7';
        char upperChar = 'A';
        char spaceChar = ' ';
        char newLineChar = '\n';

        System.out.println("'7'은 숫자입니까? : " + Character.isDigit(numChar));
        System.out.println("'A'은 영문자입니까? : " + Character.isLetter(upperChar));
        System.out.println("'A'은 대문자입니까? : " + Character.isUpperCase(upperChar));

        System.out.println("' '은 공백입니까? : " + Character.isSpaceChar(spaceChar));
        System.out.println("'\\n'은 공백(Whitespace)으로 처리됩니까? : " + Character.isWhitespace(newLineChar));
    }

    private static void intermediateTask() {
        char lower = 'p';
        char upper = Character.toUpperCase(lower);
        System.out.println("'p'의 대문자 변환 : " + upper);

        char numberChar = '5';
        int castedvalue = (int) numberChar;
        int numericValue = Character.getNumericValue(castedvalue);

        System.out.println("'5'를 (int)로 캐스팅한 값(아스키코드) : " + castedvalue);
        System.out.println("'5'를 getNumericValue()로 추출한 값 : " + numericValue);

        Character charObj1 = Character.valueOf('C');
        Character charObj2 = Character.valueOf('F');
        Character charObj3 = Character.valueOf('C');

        System.out.println("charObj1 아스키코드 : " + (int) charObj1);
        System.out.println("charObj2 아스키코드 : " + (int) charObj2);
        System.out.println("charObj1.equals(charObj3) : " + charObj1.equals(charObj3));
        System.out.println("charObj1.compareTo(charObj2) : " + charObj1.compareTo(charObj2));
    }

    private static void miniProject() {
        String rawResponse = " SN: c563fw \n PAGES: 0012054 ";

        StringBuilder serialNumberBuilder = new StringBuilder();
        int totalPageCount = 0;

        boolean isParsingPages = false;

        System.out.println("원본 데이터 : [" + rawResponse + "]");

        char[] chars = rawResponse.toCharArray();

        for (char ch : chars) {
            if (Character.isWhitespace(ch) || ch == ':') continue;

            if (ch == 'P') {
                isParsingPages = true;
                continue;
            }

            if (ch == 'A' || ch == 'G' || ch == 'E' || ch == 'S') {
                if (isParsingPages) continue;
            }

            if (!isParsingPages && Character.isLetterOrDigit(ch)) {
                serialNumberBuilder.append(Character.toUpperCase(ch));
            }

            if (isParsingPages && Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);
                totalPageCount = (totalPageCount * 10) + digit;
            }
        }

        System.out.println("--- 데이터 파싱 완료 ---");
        System.out.println("추출된 규격화 시리얼 번호 : " + serialNumberBuilder.toString());
        System.out.println("추출된 누적 페이지 수 : " + totalPageCount + "장");

        String firstDigitStr = Character.toString(String.valueOf(totalPageCount).charAt(0));
        System.out.println("페이지 수의 첫 번째 숫자 문자는 : " + firstDigitStr);

    }
}
