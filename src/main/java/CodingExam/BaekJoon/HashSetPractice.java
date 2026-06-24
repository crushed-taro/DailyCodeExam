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

        /**
         * add(E e)
         *
         * 전달된 데이터를 집합에 추가.
         * 내부적으로 기존 데이터와 동일한 값(equals() 및 hashCode() 결과가 같은 객체)이 이미 존재한다면 추가를 무시하고 false를 반환하며, 성공적으로 새데이터가 추가되면 true를 반환.
         * 데이터베이스의 UNIQUE 제약조건이나 DISTINCT와 같은 역할을 함.
         */
        skills.add("Spring");
        skills.add("React");
        skills.add("Linux");
        skills.add("Python");

        System.out.println("초기 상태 : " + skills);

        // 데이터가 없어서 성공적으로 추가되면 'true'를 반환하고, 이미 똑같은 데이터가 있어서 추가에 실패하면 에러대신 'false'를 반환함.
        boolean isAdded = skills.add("Linux");
        System.out.println("'Linux' 중복 추가 성공 여부 : " + isAdded);
        System.out.println("중복 추가 시도 후 상태 : " + skills);

        /**
         * 전달된 데이터가 집합에 존재하는지 확인하여 boolean을 반환.
         * ArrayList는 데이터를 찾기 위해 0번 인덱스부터 끝까지 일일이 뒤져야 하지만(시간 복잡도 O(N)), HashSet은 '해시 알고리즘'을 통해 데이터가 들어있는 메모리 위치를 단번에 찾아냄.
         * ㅏ라서 데이터가 100만 개라도 검색 속도가 거의 즉시(O(1)) 완료되는 압도적인 성능을 자랑함.
         */
        boolean hasSpring = skills.contains("Spring");
        System.out.println("'Spring' 포함 여부 : " + hasSpring);

        /**
         * 현재 집합에 저장된 고유한 데이터의 총개수를 반환.
         * 중복 데이터는 애초에 들어가지 못하므로, 순수한 유니크 데이터의 개수만 측정.
         */
        System.out.println("최종 사이즈 : " + skills.size());
    }

    private static void intermediateTask() {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        Set<Integer> union = new HashSet<>(setA);
        /**
         * addAll(Collections<? extends E> c) : 합집합 (Union)
         *
         * 파라미터로 받은 컬렉션의 모든 데이터를 현재 집합에 쏟아 넣음.
         * 이때 중복되는 데이터는 알아서 한 번만 들어가므로, '관리자 권한'과 '일반 유저 권한'을 병합하여 최족 권한 그룹을 만들 때 매우 유용.
         */
        union.addAll(setB);
        System.out.println("합집합 : " + union);

        Set<Integer> intersection = new HashSet<>(setA);
        /**
         * retainAll(Collection<?> c) : 교집합 (Intersection)
         *
         * 파라미터로 받은 컬렉션과 현재 집합에 공통으로 존재하는 데이터만 남기고 나머지는 모두 삭제.
         * 두 그룹이 공통으로 가진 권한이나, 교집합 데이터를 추출할 때 사용.
         */
        intersection.retainAll(setB);
        System.out.println("교집합 : " + intersection);

        Set<Integer> difference = new HashSet<>(setA);
        /**
         * removeAll(Collections<?> c) : 차집합 (Difference)
         *
         * 현재 집합에서, 파라미터로 받은 컬렉션에 포함된 데이터들을 찾아 모조리 제거.
         * 예 - 전체 권한 집합.removeAll(금지된 권한 집합)을 수행하면 안전한 권한만 남길 수 있음.
         */
        difference.removeAll(setB);
        System.out.println("차집합 (A - B) : " + difference);

        System.out.println("교집합 요소 순회 출력 : ");
        /**
         * iterator() / hasNext() / next()
         *
         * HashSet은 주머니처럼 데이터를 무작위로 담아두기 때문에 인덱스(순서)가 없음.
         * 따라서 list.get(0)같은 메서드를 쓸 수 없음.
         *
         * 대신 iterator()를 호출해 순회용 반복자(Iterator) 객체를 꺼낸 뒤, hasNext()로 "다음에 꺼낼 데이터가 남아있니?"라고 묻고, next()로 "그 데이터 하나 꺼내줘"라고 지시하며 모든 데이터를 순회.
         *
         * 참고 - 최근에 자바 개발에서는 내부적으로 이 Iterator를 사용하는 향상된 for문(for (String perm : permissions))이나 Stream API를 더 많이 사용.
         */
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
