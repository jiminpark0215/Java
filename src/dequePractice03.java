//20240223 데이터 재정렬

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class dequePractice03 {
    public static void reorderData(int[] arr){
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x -> deque.addLast(x)); //배열에 모두 집어넣음
        System.out.println(deque);

        while (!deque.isEmpty()){
            result.add(deque.removeFirst());

            if(!deque.isEmpty()){
                result.add(deque.removeLast());
            }
        }

        System.out.println(" == 정렬 전 == ");

        printData(arr);
        System.out.println(" == 정렬 후 == ");
        printData(result.stream().mapToInt(x->(int)x).toArray()); //각각 데이터들이 정수값의 배열로 바뀜

    }

    public static void printData(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println(arr[arr.length - 1]);
    }


    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);

    }
}
