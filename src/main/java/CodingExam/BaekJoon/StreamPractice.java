package CodingExam.BaekJoon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {

    /*
        컬렉션(List, Set 등)이나 배열에 저장된 데이터들을 가공하고 처리하기 위한 선언형(Declarative) 데이터 처리 도구

        기존의 방식이 데이터를 처리하기 위해 for문과 if문을 붙여가며 "어떻게(How)" 처리할지 지시하는 명령형 방식이었다면,
        스트림은 "무엇(What)"을 처리할지 파이프라인(Pipeline) 형태로 작성하는 방식

        실무에서는 대용량 로그 필터링, 데이터 변환 및 통계(집계) 처리에 필수적으로 사용
     */

    public static void main(String[] args) {

        System.out.println("=== 에러 로그 필터링 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 데이터 변환 및 합산 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 대용량 렌탈 장비 통계 엔진 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        List<String> logs = List.of(
                "INFO: Server started",
                "ERROR: DB timeout",
                "INFO: API called",
                "ERROR: Null pointer"
        );

        List<String> errorLogs = logs.stream()
                .filter(log -> log.contains("ERROR"))
                .collect(Collectors.toList());

        System.out.println("추출된 에러 로그 : " + errorLogs);

        /*
            원본 데이터 훼손 방지 - 스트림은 원본 리스트(logs)의 데이터를 직접 지우거나 바꾸지 않고, 새로운 스트림 파이프를 통해 흘려보내며 복사본을 가공함.
         */
    }

    private static void intermediateTask() {
        List<Integer> pages = List.of(120, 300, 450, 90);

        int totalCost = pages.stream()
                .map(p -> p * 10)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("변환된 과금액 총합 : " + totalCost + "원");

        /*
            지연 연산(Lazy Evaluation) - 스트림의 중간 연산(map, filter)은 당장 실행되지 않고, sum()이나 collect() 같은 최종 연산이 호출될 때 비로소 한 번에 처리됨.
         */
    }

    private static void miniProject() {
        Map<String, Integer> usageMap = Map.of(
                "PRN-A", 150,
                "PRN-B", 350,
                "PRN-C", 500,
                "PRN-D", 90
        );

        System.out.println("전체 장비 사용량 데이터 : " + usageMap);

        List<String> highUsagePrinters = usageMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 200)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        int highUsageTotalSum = usageMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 200)
                .mapToInt(entry -> entry.getValue())
                .sum();

        System.out.println("--- 타겟 장비 분석 리포트 ---");
        System.out.println("200장 이상 사용 장비 목록 : " + highUsagePrinters);
        System.out.println("해당 장비들의 총 사용량 : " + highUsageTotalSum + "장");

    }

}
