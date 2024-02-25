import java.util.*;
//20240220 합병 정렬, 힙 정렬, 퀵 정렬, 트리 정렬
 /*

   합병 정렬 (Merge Sort)
    배열을 계속 분할해서 길이가 1이 되도록 만들고 인접한 부분끼리 정렬하면서 합병
    알고리즘 복잡도 : O(nlogn)
   합병정렬구현 의사코드 (Pseudocode)
       mergeSort(A[], p, r) ▷ A[p...r]을 정렬한다{
            if (p < r) then {
                q ← (p+q)/2; ----------------- ① ▷ p, q의 중간 지점 계산
                mergeSort(A, p, q); ---------- ② ▷ 전반부 정렬
                mergeSort(A, q+1, r); -------- ③ ▷ 후반부 정렬
                merge(A, p, q, r);------------ ④ ▷ 합병
            }
        }

        merge(A[], p, q, r){
            정렬되어 있는 두 배열 A[p...q]와 A[q+1...r]을 합하여
            정렬된 하나의 배열 A[p...r]을 만든다.
        }

   힙 정렬(Heap Sort)
    기존 배열을 최대 힙으로 구조 변경 후 정렬 진행
    알고리즘 복잡도 : O(nlogn)
   힙정렬구현 의사코드 (Pseudocode)
        HeapSort(arr) {
            buildHeap(arr) // O(n)
            // O(nlogn)
            for( i = heapLastIndex ~ 0 ) {
                swap(arr, i, heapLastIndex)
                heapify(arr, 0, i - 1)
            }
        }

   퀵 정렬(Quick Sort)
    임의의 기준 값(Pivot)을 정하고 그 값을 기준으로 좌우로 분할하며 정렬하는 방식
    알고리즘 복잡도 : O(n제곱) = n(n-1)/2 (기준 값이 최소값 또는 최대값으로 지정되는 경우)
   퀵정렬구현 의사코드 (Pseudocode)
        QuickSort(start, end, arr[]){
            if(start >= end)
                return;
            pivot = end;
            low = start;
            ptr = start;
            while(ptr < pivot){
                if(arr[ptr] < arr[pivot]){
                    if(low != ptr){
                        swap(arr[low], arr[ptr]);
                    }
                    low ++;
                }
                ptr ++;
            }
            swap(arr[low], arr[pivot]);
            QuickSort(start, low - 1, arr);
            QuickSort(low + 1, end, arr);
        }

    트리 정렬(Tree Sort)
      이진 탐색 트리(BST)를 만들어 정렬하는 방식
      알고리즘 복잡도 : O(nlogn)
    트리정렬구현 의사코드 (Pseudocode)
      //이진 트리
         Algorthm get_count(node)
          if node == NULL
            return 0
          else
            return 1 + get_count(node.left()) + get_count(node.right())
      //일반 트리
         Algorithm get_height(node)
          int height = 0;
          if(node != NULL)
            height = 1 + max( get_height(node.left()), get_height(node.right()) )
          return height;
         // node 가 NULL 이라면 0이 리턴되고, 아니라면 왼쪽 오른쪽 서브트리로 부터 계산된 결과값이 리턴

    */

public class algorithm02 {

    /*
    //Merge 합병정렬
    public static void mergeSort(int[] arr, int[] tmp, int left, int right){
        if(left < right){
            int mid = (left + right) / 2; //중앙 값에 대한 인덱스를 지정
            mergeSort(arr, tmp, left, mid); //배열 좌측자리로 분할
            mergeSort(arr, tmp, mid + 1 , right); //배열 우측자리로 분할
            merge(arr, tmp, left, right, mid);
        }
    }
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid){
        int p = left; //좌측
        int q = mid + 1; //우측
        int idx = p;

        while (p <= mid || q <= right){ //둘 중 하나라도 배열안에서 유효한 구간에 있다면
            if(p <= mid && q <= right){ // 둘 다 유효한 구간안이라면
                if(arr[p] <= arr[q]){
                    tmp[idx++] = arr[p++];
                }else{
                    tmp[idx++] = arr[q++];
                }

            } else if (p <= mid && q > right) { //중간범위를 벗어난 경우. 오른쪽에 더이상 값이 없을 때
                tmp[idx++] = arr[p++];

            } else{
                tmp[idx++] = arr[q++];
            }

            for (int i = left; i <= right; i++) {
                arr[i] = tmp[i];
            }
            
        }
    }
    */

    /*
    //Heap 힙정렬
    public static void heapSort(int[] arr){
        for (int i = arr.length/2 - 1; i >= 0 ; i--) { //반으로 나눠서 3번째부터 거꾸로 확인
            heapify(arr, i , arr.length);
        }

        for (int i = arr.length - 1; i > 0 ; i--) { //가장 끝에서 1개씩 줄도록
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size){ //힙자료구조로 변경
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]){
            maxIdx = leftIdx;
        }

        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]){
            maxIdx = rightIdx;
        }

        if(parentIdx != maxIdx){ //교체되지 않았을 때 스왑
            swap(arr, maxIdx , parentIdx);
            heapify(arr, maxIdx , size); //재귀호출
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
*/

    //Quick 퀵정렬
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot-1); //좌측에 대해
        quickSort(arr, pivot+1 , right); //우측에 대해

    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j){
            while (arr[j] > pivot && i < j){ // 피봇값보다 작은 값을 만나기 전까지 좌측으로 이동
                j--;
            }
            while (arr[i] <= pivot && i < j){ // 피봇값보다 큰 값을 찾아감
                i++;
            }
            swap(arr, i, j);
        }

        swap(arr, left, i); //피봇의 자리와 교환

        return i; //피봇자리가 새로 i의 자리로 감
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //Test code
        /*
        //Merge 합병정렬
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length -1);
        System.out.println("합병 정렬 : " + Arrays.toString(arr));
        */

        /*
        //Heap 힙정렬
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬 : " + Arrays.toString(arr));
        */

        //Quick 퀵정렬
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        quickSort(arr, 0,arr.length-1);
        System.out.println("퀵 정렬 : " + Arrays.toString(arr));
    }
}
