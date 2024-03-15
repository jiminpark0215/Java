// 비선형 자료구조 - 우선순위 큐
// Practice 1
// 자바 기본 PriorityQueue

import java.util.PriorityQueue;

class Person2 implements Comparable<Person2> {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person2 o){
        // 1 : 변경 안함. 우선순위가 높지 않음
        // -1 : 변경
        //새롭게 추가하는 데이터가 더 적을 때 변경 (적은 값이 위로 올라감)
        return this.age >= o.age ? 1 : -1;//(오름차순)

        //새롭게 추가하는 데이터가 더 클 때 변경 (큰 값이 위로 올라감)
        //return this.age >= o.age ? -1 : 1; (내림차순)
    }
}

public class priorityQueuePractice02 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person2> pq = new PriorityQueue<>();
        for (int i = 0; i < name.length ; i++) {
            pq.offer(new Person2(name[i], age[i]));
        }

        System.out.println(" === 실제 출력 순서 === ");
        while (!pq.isEmpty()){
            Person2 p = pq.poll();
            System.out.println(p.name + " " + p.age);
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

    }
}