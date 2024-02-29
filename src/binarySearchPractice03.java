
//20240224
/*
2차원 행렬에서 이진 탐색으로 데이터 찾기
row x col 행렬 데이터가 주어졌을 때, target을 이진 탐색으로 찾는 프로그램을 작성하세요.
각 행의 데이터는 오름차순으로 정렬 상태
*/
public class binarySearchPractice03 {
    public static boolean solution(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int left = 0;
        int rows = matrix.length; //행이 몇줄인지
        int cols = matrix[0].length; //열이 몇개인지
        int right = rows * cols - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(matrix[mid/cols][mid%cols] == target){ //
                return true;
            } else if (matrix[mid/cols][mid%cols] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        //Test code
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};

        System.out.println(solution(matrix, 3));
        System.out.println(solution(matrix, 13));
        System.out.println(solution(matrix, 35));

    }
}