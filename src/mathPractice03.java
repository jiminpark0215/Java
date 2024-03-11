
// 기초 수학 - 순열
//1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법( 순서 o , 중복 x) 의 각 결과를 출력하시오
//방법 1

public class mathPractice03 {
    void permutation(int[] arr, int depth, int n, int r){
        if (depth == r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i); //자리바꿈
            permutation(arr, depth + 1 , n , r); //재귀호출
            swap(arr, depth, i); //자리바꿈
        }
    }

    void swap(int[] arr, int depth, int idx){
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        mathPractice03 p = new mathPractice03();
        p.permutation(arr, 0, 4, 3);

    }
}