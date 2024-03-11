
// 기초 수학 - 순열
//1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법( 순서 o , 중복 x) 의 각 결과를 출력하시오
//방법 2

import java.util.Arrays;

public class mathPractice04 {
    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out){
        if(depth == r){ //3 자리수 일 때 출력
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true){
                visited[i] = true;
                out[depth] = arr[i]; //방문한 적이 없는 값이면 자리수를 만들어서 요소로 저장
                permutation(arr, depth + 1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }

    void swap(int[] arr, int depth, int idx){
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;

    }
    public static void main(String[] args) {
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[r];

        mathPractice04 p = new mathPractice04();
        p.permutation(arr, 0, n, r, visited, out);

    }
}