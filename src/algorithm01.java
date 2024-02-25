import java.util.ArrayList;
import java.util.Arrays;
//20240219 버블정렬, 삽입정렬, 선택정렬
 /*
    정렬
    특정 값을 기준으로 데이터를 순서대로 배치하는 방법
    구현 난이도는 쉽지만 속도는 느린 알고리즘 - 버블 정렬, 삽입 정렬, 선택 정렬
    구현 난이도는 조금 더 어렵지만, 속도는 빠른 알고리즘 - 합병 정렬, 힙 정렬, 퀵 정렬, 트리 정렬
    하이브리드 정렬 - 팀 정렬, 블록 병합 정렬, 인트로 정렬
    기타 정렬 알고리즘 - 기수 정렬, 카운팅 정렬, 셸 정렬, 보고 정렬

   버블 정렬 (Bubble Sort)
    인접한 데이터를 비교하며 자리를 바꾸는 방식
    알고리즘 복잡도 : O(n제곱) = n(n-1)/2
    인접한 값을 비교하고 작은 수가 앞쪽으로 자리교체
   버블정렬구현 의사코드 (Pseudocode)  *스도코드 : 알고리즘 flow 파악용 코드이며 실제 돌아가지 않음
       bubbleSort(arr[]){
            arr[SIZE]
            for i = 1 to SIZE - 1 {
                for j = 0 to SIZE - i {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr[j], arr[j+1])
                    }
                }
            }
       }

   삽입 정렬(Insertion Sort)
    앞의 데이터를 정렬 해가면서 삽입 위치를 찾아 정렬하는 방식, 버블정렬보다 빠름
    알고리즘 복잡도 : O(n제곱) = n(n-1)/2
   삽입정렬구현 의사코드 (Pseudocode)
        insertionSort(arr[]){
            arr[SIZE]
            for i = 1 to SIZE {
                for j = i to 0 (j--) {
                    if (arr[j] < arr[j - 1]) { //정렬되어있어도 비교가 되기 때문에 필요하면 break를 추가하면 좋음
                        swap(arr[j], arr[j - 1])
                    }
                }
            }
        }

   선택 정렬(Selection Sort)
    최소 또는 최대값을 찾아서 가장 앞 또는 뒤부터 정렬하는 방식, 배열 안에서 정렬이 일어나서 제자리 정렬이라고도 함.
    메모리를 최소한으로 사용함.
    알고리즘 복잡도 : O(n제곱) = n(n-1)/2
   선택정렬구현 의사코드 (Pseudocode)
        selectionSort(arr[]){
            arr[SIZE]
            for i = 0 to SIZE - 1 {
                min = i
                for j = i + 1 to SIZE {
                    if (arr[j] < arr[min]) {
                        min = j
                    }
                }
            swap(arr[i], arr[min])
            }
        }

    */

public class algorithm01 {
    public static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length - 1 ; i++) {  //case1 처음부터 시작
        //for (int i = arr.length - 1; i > 0 ; i--) {  //case2 끝부터 시작
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[i];
                    arr[i] = arr[j-1];
                    arr[j-1] = tmp;
                }else{
                    break;
                }
            }
        }


        /*
        for(int x = 1; x < arr.length; x++){
            for(int y = x; y > 0 ; y--){
                if(arr[y] < arr[y - 1]){
                    int temp = arr[x];
                    arr[x] = arr[y - 1];
                    arr[y - 1] = temp;
                }else{
                    break;
                }
            }
        }
        */
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]){ //작다고 생각했던 것보다 더 작으면
                    min = i;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

/*        for (int i =  arr.length - 1; i > 0 ; i--) { //뒤에서 부터 비교
            int max = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[max]){
                    max = i;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }*/
    }

    public static void main(String[] args) {
        //Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬 : " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬 : " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬 : " + Arrays.toString(arr));

    }
}
