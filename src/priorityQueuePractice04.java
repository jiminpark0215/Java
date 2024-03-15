// 비선형 자료구조 - 우선순위 큐
// Practice 2
// 문자열 사전식 오름차순

import java.util.PriorityQueue;

class Person4 {
    String name;
    int age;

    public Person4(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class priorityQueuePractice04 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person4> pq = new PriorityQueue<>((Person4 p1, Person4 p2) -> p1.name.compareTo(p2.name)); //문자열 오름차순
//        PriorityQueue<Person4> pq = new PriorityQueue<>((Person4 p1, Person4 p2) -> p2.name.compareTo(p1.name)); //문자열 내림차순

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person4(name[i], age[i]));
        }
        while (!pq.isEmpty()){
            Person4 p = pq.poll();
            System.out.println(p.name + " " + p.age);
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

    }
}