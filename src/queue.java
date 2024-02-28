import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args){
        Queue queue = new LinkedList(); //Queue는 인터페이스, 다형성을 이용해서 LinkedList를 사용하는 것이 편리

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());//가장 먼저 들어온 요소
        System.out.println(queue);

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll()); //아무것도 없으면 null

    }
}
