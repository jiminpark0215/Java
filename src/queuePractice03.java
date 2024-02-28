import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

//20240222
/*
요세프스 순열 문제
N과 K가 주어졌을 때 (N,K) 요세프스 순열을 구하시오.
N과 K는 N >= K를 만족하는 양의 정수이다.
1부터 N번 까지 N명이 순서대로 원을 이루어 모여있다.
이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
모든 사람이 제외될 때까지 반복하며 이 때, 제외되는 순서가 요세푸스 순열이다.
*/
public class queuePractice03 {
    public static ArrayList getJosephusPermutation(int N, int K){
        Queue queue = new LinkedList();
        ArrayList result = new ArrayList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));

        int cnt = 0;
        while (!queue.isEmpty()){
            int data = (int)queue.remove();
            cnt += 1;

            if(cnt % K == 0){
                result.add(data);
            }else {
                queue.add(data);
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(getJosephusPermutation(5, 2));
        System.out.println(getJosephusPermutation(7, 3));

    }
}
