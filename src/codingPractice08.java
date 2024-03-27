import java.io.*;
import java.util.*;
/*
피자 나눠 먹기 (2)

머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
 n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를
 return 하도록 solution 함수를 완성해보세요.

 입출력 예 설명
입출력 예 #1

6명이 모두 같은 양을 먹기 위해 한 판을 시켜야 피자가 6조각으로 모두 한 조각씩 먹을 수 있습니다.
입출력 예 #2

10명이 모두 같은 양을 먹기 위해 최소 5판을 시켜야 피자가 30조각으로 모두 세 조각씩 먹을 수 있습니다.
입출력 예 #3

4명이 모두 같은 양을 먹기 위해 최소 2판을 시키면 피자가 12조각으로 모두 세 조각씩 먹을 수 있습니다.

 */

public class codingPractice08 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        for (int i = 1; i <= (6 * n); i++) {
            if ((6 * i) % n == 0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}