import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class deque {
    public static void main(String[] args){
        Deque deque = new ArrayDeque();

        //Front 부분
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

        //Rear부분
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

        //Front 부분
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        //Rear부분
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.pollLast());
        System.out.println(deque.removeLast());

    }
}
