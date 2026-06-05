package CodingExam.BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPractice {

    // 데이터가 추가될 때마다 알아서 내부 배열 크기를 늘려주는 동적 배열(Dinamic Array)

    public static void main(String[] args) {
        System.out.println("=== 동적 배열 기초 CRUD ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 탐색, 병합 및 조건부 삭제 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== DeepLine 장비 세션 관리기 ===");
        miniProject();
        System.out.println();
    }

    private static void beginnerTask() {
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println("초기 비어있는지 확인 : " + fruits.isEmpty());

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("데이터 추가 후 사이즈 : " + fruits.size());
        System.out.println("현재 상태 : " + fruits);

        fruits.add(1, "Mango");
        System.out.println("Mango 끼워넣기 후 : " + fruits);

        fruits.set(2, "Kiwi");
        System.out.println("Kiwi로 교체 후 : " + fruits);

        fruits.remove(0);
        fruits.remove("Cherry");
        System.out.println("삭제 완료 후 최종 상태 : " + fruits);
    }

    private static void intermediateTask() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        boolean hasB = list.contains("B");
        int indexOfC = list.indexOf("C");
        System.out.println("B 포함 여부 : " + hasB + ", C의 위치 : " + indexOfC);

        // 배열 기반 고정 크기 리스트, 간단히 읽거나 값만 바꿀 때
        List<String> newList = Arrays.asList("X", "Y", "Z");
        list.addAll(newList);
        System.out.println("병합 후 리스트 : " + list);

        list.removeIf(item -> item.equals("A") || item.equals("X"));
        System.out.println("A, X 삭제 후 : " + list);

        list.clear();
        System.out.println("clear 후 사이즈 : " + list.size());
    }

    private static void miniProject() {
        ArrayList<String> activePrinters = new ArrayList<>();

        System.out.println("DeepLine 장비 모니터링 서버 구동 중");

        List<String> savedPrinters = Arrays.asList("SL-C563FW", "HP-ColorLaser", "Brother-HL");
        activePrinters.addAll(savedPrinters);
        System.out.println("초기 로드 완료 : " + activePrinters);

        activePrinters.add("Epson-EcoTank");
        System.out.println("신규 장비 연결 : " + activePrinters);

        activePrinters.add(0, "TEST-Printer");
        System.out.println("테스트 장비 삽입 : " + activePrinters);

        System.out.println(">> 네트워크 점검 : Brother 장비 연결 끊김 감지");
        activePrinters.removeIf(printer -> printer.contains("Brother"));

        String targetModel = "SL-C563FW";
        boolean isTargetActive = activePrinters.contains(targetModel);

        System.out.println("--- 최종 세션 모니터링 상태 ---");
        System.out.println("현재 활성화된 장비 수 : " + activePrinters.size());
        System.out.println("전체 장비 목록 : " + activePrinters);

        if (isTargetActive) System.out.println("정상 핵심 모델(" + targetModel + ")이 안정적으로 통신 중입니다.");
        else System.out.println("경고 핵심 모델 연결 유실");

    }
}
