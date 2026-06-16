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

        /**
         * 전달된 문자가 숫자('0' ~ '9')인지 판별하여 boolean을 반환한다.
         */
        System.out.println("'7'은 숫자입니까? : " + Character.isDigit(numChar));

        /**
         * 전달된 문자가 영문자(또는 한글 등 각 언어의 일반 문자)인지 판별한다. 특수문자나 숫자는 false를 반환한다.
         */
        System.out.println("'A'은 영문자입니까? : " + Character.isLetter(upperChar));

        /**
         * 전달된 문자가 대문자인지 소문자인지 판별한다.
         * isUpperCase, isLowerCase
         */
        System.out.println("'A'은 대문자입니까? : " + Character.isUpperCase(upperChar));

        /**
         * isSpaceChar는 키보드의 스페이스바 같은 순수 '공백 문자'만을 주로 판별한다.
         *
         * isWhitespace는 스페이스바뿐만 아니라 탭(\t), 줄바꿈(\n, \r) 등 화면에 보이지 않고 띄어쓰기 역할을 하는 모든 제어 문자를 뭉뚱그려 공백으로 판단한다.
         * 외부 장비의 로그나 원시 데이터를 파싱할 때는 예기치 않은 줄바꿈이 섞여 들어오는 경우가 많으므로 isWhitespace를 사용하는 것이 훨씬 안전하다.
         */
        System.out.println("' '은 공백입니까? : " + Character.isSpaceChar(spaceChar));
        System.out.println("'\\n'은 공백(Whitespace)으로 처리됩니까? : " + Character.isWhitespace(newLineChar));
    }

    private static void intermediateTask() {
        char lower = 'p';

        /**
         * 문자를 대문자나 소문자로 변환하여 반환한다. 이미 대문자이거나 변환할 수 없는 기호일 경우 원본 그대로 반환한다.
         * toUpperCase, toLowerCase
         */
        char upper = Character.toUpperCase(lower);
        System.out.println("'p'의 대문자 변환 : " + upper);

        char numberChar = '5';

        /**
         * (int) '5' - 문자를 int로 강제 형변환하면 컴퓨터가 인식하는 아스키코드(ASCII) 십진수 값이 튀어나온다. (문자 '5'의 아스키코드 값인 53이 나옴)
         * getNumericValue - 문자가 나타내는 실제 수학적 수치를 정수로 뽑아낸다. (우리가 원하는 5가 나옴). 텍스트에서 숫자를 읽어와 실제 계산에 써야 할 때 반드시 사용해야 하는 메서드이다.
         */
        int castedvalue = (int) numberChar;
        int numericValue = Character.getNumericValue(castedvalue);

        System.out.println("'5'를 (int)로 캐스팅한 값(아스키코드) : " + castedvalue);
        System.out.println("'5'를 getNumericValue()로 추출한 값 : " + numericValue);

        /**
         * 기본형 char를 래퍼 클래스인 Character 객체로 변환(Boxing)한다.
         * 내부적으로 자주 쓰이는 문자(아스키코드 0 ~ 127)는 캐싱(Caching)하여 메모리를 아끼는 구조로 되어 있다.
         */
        Character charObj1 = Character.valueOf('C');
        Character charObj2 = Character.valueOf('F');
        Character charObj3 = Character.valueOf('C');

        System.out.println("charObj1 아스키코드 : " + (int) charObj1);
        System.out.println("charObj2 아스키코드 : " + (int) charObj2);
        System.out.println("charObj1.equals(charObj3) : " + charObj1.equals(charObj3));

        /**
         * 두 문자의 아스키코드 값의 차이를 정수(int)로 반환한다.
         * 같으면 0, 내 아스키코드가 더 크면 양수, 작으면 음수가 나온다. 사전순 정렬의 기본 바탕이 된다.
         */
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

            /**
             * 문자이거나 숫자인 경우 true을 반환한다.
             * 특수 기호나 공백, 쉼표 등을 걸러내고 순수하게 의미 있는 영숫자(Alphanumeric) 데이터(예 : 프린터 시리얼 번호, 모델명)만 추출해 낼 때 가장 간편하게 쓰이는 필터링 메서드이다.
             */
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

        /**
         * 단일 문자(char)를 완전한 형태의 문자열(String) 객체로 안전하게 변환하여 반환한다.
         * String.valueOf(char)와 같은 역할을 한다.
         */
        String firstDigitStr = Character.toString(String.valueOf(totalPageCount).charAt(0));
        System.out.println("페이지 수의 첫 번째 숫자 문자는 : " + firstDigitStr);

    }
}
