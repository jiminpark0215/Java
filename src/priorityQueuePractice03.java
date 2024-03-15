// 비선형 자료구조 - 우선순위 큐
// Practice 1
// 자바 기본 PriorityQueue (인터페이스 상속 구현 없는 버전)

import java.util.PriorityQueue;

class Person3 {
    String name;
    int age;

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class priorityQueuePractice03 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person3> pq = new PriorityQueue<>();

    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        PriorityQueue<Person3> pq3 = new PriorityQueue<>((Person3 p1, Person3 p2) -> p1.age >= p2.age ? 1 : -1); //오름차순
//        PriorityQueue<Person3> pq3 = new PriorityQueue<>((Person3 p1, Person3 p2) -> p1.age >= p2.age ? -1 : 1); //내림차순

        for (int i = 0; i < name.length ; i++) {
            pq3.offer(new Person3(name[i], age[i]));
        }

        while (!pq3.isEmpty()){
            Person3 p = pq3.poll();
            System.out.println(p.name + " " + p.age);
        }
    }
}