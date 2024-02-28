import java.util.*;
import java.util.stream.IntStream;

//20240222 카드 섞기
/*
1부터 N까지 번호로 구성된 N장의 카드가 있다.
1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드가 순서대로 쌓여있다.
아래의 동작을 카드 한 장만 남을 때가지 반복했을 때 가장 마지막 남는 카드 번호를 출력하시오.
1.가장 위의 카드는 버린다.
2.그 다음위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.
*/
public class queuePractice02 {
    public static int findLastCard(int N){
        Queue queue = (Queue) new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x)); ////n장의 카드뽑기
        System.out.println(queue);

        while (queue.size() > 1){
            queue.remove(); //맨 윗장 삭제
            int data = (int)queue.remove(); //꺼냄
            queue.add(data);//맨뒤에 다시 추가
            System.out.println(queue);
        }

        return (int)queue.remove(); //맨 마지막 장을 리턴
    }

    public static void main(String[] args){
        System.out.println(findLastCard(4));
        System.out.println(findLastCard(7));
        System.out.println(findLastCard(9));

    }
}
