
//20240224
/*
 이진 탐색 추가 구현
 target 값이 arr 내에 있으면 해당 인덱스 반환
 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환
*/
public class binarySearchPractice01 {
    //반복문 구조
    public static int solution(int arr[] , int target){
        if(arr == null || arr.length == 0){
            return -1;
        }

        int left = 0;
        int right = arr.length -1;

        while (left <= right){
            //int mid = (left + right) / 2; //데이터가 너무 크면 오버플로우 상태로 넘어갈 수 있음
            int mid = left + (right - left) / 2; // 오버플로우 방지

            if(target == arr[mid]){
                return  mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -left - 1;
    }

    public static void main(String[] args){
        //Test code
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60}; //정렬이 되어있어야 함

        System.out.println("Index : " + solution(arr, 30));
        System.out.println("Index : " + solution(arr, 3));
        System.out.println("Index : " + solution(arr, 11));
        System.out.println("Index : " + solution(arr, 35));

    }
}