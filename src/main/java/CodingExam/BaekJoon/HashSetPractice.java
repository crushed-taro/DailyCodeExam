package CodingExam.BaekJoon;

import java.util.*;

public class HashSetPractice {

    /*
        ArrayList, LinkedList는 데이터가 '들어오는 순서대로' 저장하고 '중복'을 허용하는 리스트
        HashSet은 '순서를 보장하지 않고' 데이터의 '중복을 허용하지 않는' 집합(Set)

        데이터베이에서 DISTINCT 쿼리를 날리듯 중복을 제거할 때, 특정 데이터가 존재하는지 빠르게(O(1)) 찾아야할 때 사용
     */

    public static void main(String[] args) {

        System.out.println("=== 중복 불허와 기본 CRUD ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 집합 연산(합, 교, 차)과 순회 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== DeepLine 권한 그룹 매니저 ===");
        miniProject();
        System.out.println();

    }

    private static void beginnerTask() {

        Set<String> skills = new HashSet<>();

        skills.add("Spring");
        skills.add("React");
        skills.add("Linux");
        skills.add("Python");

        System.out.println("초기 상태 : " + skills);

        // 데이터가 없어서 성공적으로 추가되면 'true'를 반환하고, 이미 똑같은 데이터가 있어서 추가에 실패하면 에러대신 'false'를 반환함.
        boolean isAdded = skills.add("Linux");
        System.out.println("'Linux' 중복 추가 성공 여부 : " + isAdded);
        System.out.println("중복 추가 시도 후 상태 : " + skills);

        boolean hasSpring = skills.contains("Spring");
        System.out.println("'Spring' 포함 여부 : " + hasSpring);
        System.out.println("최종 사이즈 : " + skills.size());
    }

    private static void intermediateTask() {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("합집합 : " + union);

        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("교집합 : " + intersection);

        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("차집합 (A - B) : " + difference);

        System.out.println("교집합 요소 순회 출력 : ");
        Iterator<Integer> iterator = intersection.iterator();
        while(iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num + " ");
        }
        System.out.println();
    }

    private static void miniProject() {
        System.out.println("DeepLine 권한 제어 모듈 작동");

        Set<String> userPermissions = new HashSet<>(Arrays.asList(
                "READ_DOCUMENT", "PRINT_BASIC", "UPDATE_PROFILE"
        ));
        Set<String> adminPermissions = new HashSet<>(Arrays.asList(
                "DELETE_TENANT", "INVITE_USER", "PRINT_BASIC"
        ));

        Set<String> superUserPerms = new HashSet<>(userPermissions);
        superUserPerms.addAll(adminPermissions);

        System.out.println("통합 유저의 최종 권한 (중복 자동 제거됨)");
        System.out.println(superUserPerms);

        Set<String> commonPerms = new HashSet<>(adminPermissions);
        commonPerms.retainAll(userPermissions);

        System.out.println("모든 등급이 공통으로 가진 권한 : " + commonPerms);

        String targetPerm = "DELETE_TENANT";
        if (superUserPerms.contains(targetPerm)) {
            System.out.println("해당 유저는 테넌트 삭제 권한이 없습니다.");
        } else {
            System.out.println("권한이 부족합니다.");
        }
    }

}
