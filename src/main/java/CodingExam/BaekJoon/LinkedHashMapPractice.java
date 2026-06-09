package CodingExam.BaekJoon;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapPractice {

    /*
        HashMap의 'O(1)' 효과를 그대로 유지하면서, 데이터가 입력된 '순서'까지 기억하는 컬렉션

        실무에서는 '접근 순서(Access Order)' 모드를 활용하여, 브라우저의 '최근 방문 기록'이나 서버의 'LRU(Least Recently Used) 캐시'로 사용됨.
     */

    public static void main(String[] args) {

        System.out.println("=== 입력 순서 보장 (Insertion Order) ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 접근 순서 모드 (Access Order) ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== 자동 정리되는 LRU 캐시 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {
        Map<String, String> orderMap = new LinkedHashMap<>();

        orderMap.put("Tenant-C", "활성");
        orderMap.put("Tenant-A", "중지");
        orderMap.put("Tenant-B", "활성");

        System.out.println("초기 입력 순서 : " + orderMap.keySet());

        orderMap.put("Tenant-A", "영구정지");

        System.out.println("A 업데이트 후 순서 (변화 없어야 함) : " + orderMap.keySet());
        System.out.println("A의 값 : " + orderMap.get("Tenant-A"));
    }

    private static void intermediateTask() {
        // 초기용량 16, 로드팩터 0.75f, accessOrder = true 로 맵 생성
        Map<String, String> accessMap = new LinkedHashMap<>(16, 0.75f, true);

        accessMap.put("Doc-1", "계약서");
        accessMap.put("Doc-2", "청구서");
        accessMap.put("Doc-3", "영수증");

        System.out.println("초기 상태 (1, 2, 3) : " + accessMap.keySet());

        String readDoc = accessMap.get("Doc-1");
        System.out.println("Doc-1 조회 완료 : " + readDoc);

        System.out.println("조회 후 상태 (1, 2, 3) : " + accessMap.keySet());
        /*
            accessOrder = true, 이 옵션을 켜면 put뿐만 아니라 get을 할 때마다 내부의 연결선(포인터)이 자동으로 재배치됨.
            한 번이라도 조회된 데이터를 꼬리(Tail)로 이동함.
         */
    }

    private static void miniProject() {
        final int MAX_CACHE_SIZE = 3;

        /*
            서버 메모리 절약을 위해 "최근에 열람한 문서 최대 3개까지만 메모리(캐시)에 유지하고,
            가장 오래 안 본 문서는 자동으로 삭제"하는 LRU(Least Recently Used) 캐시 시스템 구축
         */

        Map<String, String> lruCache = new LinkedHashMap<>(MAX_CACHE_SIZE, 0.75f, true) {
            /*
                removeEldestEntry 메서드를 오버라이드(Override)하여 맵의 size()가 최대 허용치를 넘으면 true를 반환하도록 작성
                아래와 같이 작성시 제일 오래된 데이터를 삭제함.
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };

        System.out.println("최근 열람 캐시 메모리 가동 (최대 3개 유지)");

        lruCache.put("Doc-A", "내용A");
        lruCache.put("Doc-B", "내용B");
        lruCache.put("Doc-C", "내용C");
        lruCache.put("Doc-D", "내용D");

        System.out.println("4개 입력 후 캐시 상태 (A가 삭제되어야 함) : " + lruCache.keySet());

        System.out.println("\n>> 사용자가 Doc-B를 다시 열람합니다.");
        lruCache.get("Doc-B");
        System.out.println("B 열람 후 캐시 상태 (B가 맨 뒤로 이동) : " + lruCache.keySet());

        System.out.println("\n>> 새로운 문서 Doc-E를 열람합니다.");
        lruCache.put("Doc-E", "내용E");

        System.out.println("최종 캐시 상태 (C 삭제됨, B 유지됨) : " + lruCache.keySet());

    }

}
