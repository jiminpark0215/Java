import java.util.*;
import java.io.*;

/*
백준 2750

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class codingPractice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];

        for(int i = 0; i < cnt; i++){
            arr[i] = sc.nextInt();
        }

        for(int x = 0; x < arr.length-1; x++){
            for(int y = x + 1; y > 0 ; y--){
                if(arr[y] < arr[y - 1]){
                    int temp = arr[y];
                    arr[y] = arr[y - 1];
                    arr[y - 1] = temp;
                }else {
                    break;
                }

            }
        }

        StringBuilder stb = new StringBuilder();
        for(int item : arr){
            stb.append(item + "\n");
        }

        System.out.println(stb);

    }
}