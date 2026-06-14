package CodingExam.BaekJoon;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ComparablePractice {

    /*
        커스텀 객체(Class)들을 정렬할 때 "어떤 기준으로 정렬해야 할지"모를 에러 (ClassCastException)을 뱉음

        Comparable은 우리가 만든 객체에 "타고난 기본 정렬 기준(Natural Ordering)"을 부여해 주는 인터페이스.
     */

    public static void main(String[] args) {

        System.out.println("=== 단일 조건 기본 정렬 ===");
        beginnerTask();
        System.out.println();
        System.out.println("=== 다중 조건 정렬 및 안전한 비교 ===");
        intermediateTask();
        System.out.println();
        System.out.println("=== SaaS 요금제 자동 정렬 ===");
        miniProject();
        System.out.println();

    }

    static class Employee implements Comparable<Employee> {
        String name;
        int empId;

        public Employee(String name, int empId) {
            this.name = name;
            this.empId = empId;
        }


        @Override
        public int compareTo(Employee o) {
            // 내 사번이 작으면 음수, 같으면 0, 크면 양수 반환
            return Integer.compare(this.empId, o.empId);
        }

        /*
            음수 리턴 - 내(this)가 비교 대상(o)보다 작다. -> 내 자리가 앞쪽으로 간다.
            양수 리턴 - 내(this)가 비교 대상(o)보다 크다. -> 내 자리가 뒤쪽으로 간다.
            0 리턴 - 둘이 같다.
         */

        @Override
        public String toString() {
            return String.format("%s(%d)", name, empId);
        }
    }

    private static void beginnerTask() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("박대리", 300));
        employees.add(new Employee("김부장", 100));
        employees.add(new Employee("최사원", 500));

        Collections.sort(employees);

        System.out.println("사번 오름차순 정렬 결과 : " + employees);
    }

    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if (this.score != o.score) {
                return Integer.compare(o.score, this.score);
            }

            /*
                단순 뺄셈의 위험성(Overflow) - 만약 내 점수가 '20억'이고 대상 점수가 '-15억'이라면,
                '20억 - (-15억)'은 '35억'이 되어 int의 최댓값(약 21억)을 초과, 오버플로우가 발생해
                엉뚱한 음수가 되어버림.
                따라서 대소 비교는 반드시 'Integer.compare' 계열을 써야 안전.
             */

            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return String.format("[%s : %d점]", name, score);
        }
    }

    private static void intermediateTask() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("이학생", 80));
        students.add(new Student("김학생", 90));
        students.add(new Student("박학생", 80));

        Collections.sort(students);
        System.out.println("점수 내림차순, 이름 오름차순 정렬 결과 : ");
        System.out.println(students);
    }

    static class Plan implements Comparable<Plan> {
        String planName;
        int price;
        int storageGB;

        public Plan(String planName, int price, int storageGB) {
            this.planName = planName;
            this.price = price;
            this.storageGB = storageGB;
        }

        @Override
        public int compareTo(Plan o) {
            // 오름차순
            if (this.price != o.price) {
                return Integer.compare(this.price, o.price);
            }

            // 내림차순
            if (this.storageGB != o.storageGB) {
                return Integer.compare(o.storageGB, this.storageGB);
            }

            return this.planName.compareTo(o.planName);
        }

        @Override
        public String toString() {
            return String.format("%s [요금 : %d, 용량 : %dGB]", planName, price, storageGB);
        }
    }

    private static void miniProject() {
        PriorityQueue<Plan> plans = new PriorityQueue<>();

        plans.offer(new Plan("Basic", 10000, 50));
        plans.offer(new Plan("Premium", 30000, 500));
        plans.offer(new Plan("Standard-B", 20000, 100));
        plans.offer(new Plan("Standard-A", 20000, 200));
        plans.offer(new Plan("Standard-C", 20000, 100));

        System.out.println("SaaS 요금제 추천 순서 (우선순위 큐 추출)");
        int rank = 1;
        while (!plans.isEmpty()) {
            System.out.println(rank++ + " 위 : " + plans.poll());
        }
    }

}
