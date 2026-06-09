package CodingExam.BaekJoon;

import java.util.*;

public class HashMapPractice {

    /*
        Key(키)와 Value(값)가 한 쌍으로 묶여서 저장되는 구조(Key-Value Pair)를 가짐

        내부적으로 해싱(Hashing) 기법을 사용하기 때문에, 수만 개의 데이터가 들어있어도 키값만 알고 있다면 원하는 데이터를 'O(1)'으로 찾아냄
     */

    public static void main(String[] args) {

        System.out.println("=== Key-Value 기초 CRUD ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 데이터 수정 및 순회 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 테넌트별 출력 미터링 시스템 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        Map<String, String> printerStatusMap = new HashMap<>();

        printerStatusMap.put("SL-C563FW", "ONLINE");
        printerStatusMap.put("HP-Laser", "OFFLINE");
        printerStatusMap.put("Brother-HL", "ONLINE");

        System.out.println("HP 장비 등록 여부 : " + printerStatusMap.containsKey("HP-Laser"));
        System.out.println("전체 관리 장비 수 : " + printerStatusMap.size());

        String missingKey = "Epson-Eco";
        String status1 = printerStatusMap.get(missingKey);
        String status2 = printerStatusMap.getOrDefault(missingKey, "UNKNOWN");

        /*
            get()은 존재하지 않는 키를 조회하면 'null'을 반환
            getOrDefault(key, default)는 키가 없을 때 지정한 기본값을 대신 반환
         */
        System.out.println("일반 get 결과 : " + status1);
        System.out.println("getOrDefault 결과 : " + status2);
    }

    private static void intermediateTask() {
        Map<String, String> tenantConfigMap = new HashMap<>();

        tenantConfigMap.put("Tenant-A", "jdbc:postgresql://localhost:5432/db_a");
        tenantConfigMap.put("Tenant-B", "jdbc:postgresql://localhost:5432/db_b");

        tenantConfigMap.putIfAbsent("Tenant-A", "jdbc:postgresql://localhost:5432/db_new_a");
        System.out.println("putIfAbsent 적용 후 Tenant-A : " + tenantConfigMap.get("Tenant-A"));

        tenantConfigMap.replace("Tenant-B", "jdbc:postgresql://localhost:5432/db_b_backup");
        System.out.println("replace 적용 후 Tenant-B: " + tenantConfigMap.get("Tenant-B"));

        Set<String> tenantIds = tenantConfigMap.keySet();
        Collection<String> dbUrls = tenantConfigMap.values();
        System.out.println("전체 테넌트 키 집합 : " + tenantIds);
        System.out.println("전체 테넌트 값 집합 : " + dbUrls);

        System.out.println("--- 테넌트 설정 데이터베이스 리포트 ---");
        for (Map.Entry<String, String> entry : tenantConfigMap.entrySet()) {
            System.out.println("고객사 ID : " + entry.getKey());
        }

        /*
            put()은 키가 없으면 새로 추가하고 있으면 덮어씀.
            putIfAbsent()는 키가 없을 때만 추가.
            replace()는 키가 있을 때만 값을 변경.
         */

        /*
            키와 값을 동시에 순회할 때는 keySet()을 돌려 매번 get(key)을 호출하는 것보다,
            키와 값이 묶여있는 Entry 객체들의 집합인 entrySet()을 순회하는 것이 성능상 훨씬 유리.
         */
    }

    private static void miniProject() {
        Map<String, Integer> billingMetrics = new HashMap<>();

        System.out.println("DeepLine 미터링 엔진 가동");

        recordUsage(billingMetrics, "Tenant-A", 150);
        recordUsage(billingMetrics, "Tenant-B", 300);
        recordUsage(billingMetrics, "Tenant-A", 200);
        recordUsage(billingMetrics, "Tenant-C", 50);

        System.out.println("\n==================================");
        System.out.println("          월간 테넌트 과금 리포트       ");
        System.out.println("==================================");

        for (Map.Entry<String, Integer> entry : billingMetrics.entrySet()) {
            String tenantId = entry.getKey();
            int totalPages = entry.getValue();
            int finalCost = totalPages * 10;

            System.out.println("고객사 : " + tenantId + " | 총 인쇄 : " + totalPages + "장 | 청구금액 : " + finalCost + "원");
        }

        System.out.println("==================================");
    }

    private static void recordUsage(Map<String, Integer> map, String tenantId, int pages) {
        int currentCount = map.getOrDefault(tenantId, 0);
        map.put(tenantId, currentCount + pages);

        System.out.println("[수집] " + tenantId + " 장비 동기화 수신 -> +" + pages + "장 추가 기록");
    }
}
