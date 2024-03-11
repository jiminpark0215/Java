
// 기초 수학 - 조합
//1, 2, 3, 4,를 이용하여 세자리 자연수를 만드는 방법 (순서 정렬 및 중복 허용 불가)

public class mathPractice06 {
    void combination(int[] arr, boolean[] visited , int depth, int n , int r){

        if (r == 0){
            for (int i = 0; i < n; i++) {
                if (visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (depth == n){
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n , r -1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n , r );
    }
    
    public static void main(String[] args) {
        //Test Code
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = {false, false, false, false};
        mathPractice06 p = new mathPractice06();
        p.combination(arr, visited, 0, 4, 3);

    }
}