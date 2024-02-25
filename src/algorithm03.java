import java.util.*;

//20240222 기수 정렬, 힙 정렬, 퀵 정렬, 트리 정렬
/*

   기수 정렬 (Radix Sort)
    낮은 자리수 부터 정렬하는 방식. 각 원소 간의 비교 연산을 하지 않아 빠른 대신,
    기수 테이블(queue)을 위한 메모리 필요
    알고리즘 복잡도 : O(dn)
   기수정렬구현 의사코드 (Pseudocode)


   계수 정렬(Counting Sort)
    숫자끼리 비교하지 않고 카운트를 세서 정렬하는 방식. 카운트를 위한 메모리 필요
    알고리즘 복잡도 : O(n + k)
   계수정렬구현 의사코드 (Pseudocode)


   셸 정렬(shell Sort)
    삽입정렬의 약점을 보완한 정렬 방식. 이전 모든 데이터와 비교하지 않고 일정 간격을 두어 비교
     -> 삽입정렬의 약점 : 오름차순 정렬기준, 내림차순으로 구성된 데이터에 대해서는
        앞의 데이터와 하나씩 비교하며 모두 교환해야 함
    알고리즘 복잡도 : O(n제곱) = n(n-1)/2
   셸정렬구현 의사코드 (Pseudocode)

    */

public class algorithm03 {

    /*
    //Radix Sort 기수정렬
    public static void  radixSort(int[] arr){
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLength(arr);

        for (int i = 0; i < maxLen; i++) {

            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j] / div)% 10 ).offer(arr[j]);
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);

                while (!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            div *= 10;

        }
    }
    public static int getMaxLength(int[] arr){
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i]) + 1;
            if(maxLen < len){
                maxLen = len;
            }
        }
        return maxLen;
    }
    */

    /*
     //Counting Sort 계수정렬
    public static void countingSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) { //카운팅 테이블
            cntArr[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) { //정렬
            while (cntArr[i] > 0){
                arr[idx++] = i;
                cntArr[i] -= 1;
            }
        }

//        HashMap<Integer, Integer> map = new HashMap<>(); //하나의 데이터가 방대할 경우 사용
//        for (int item : arr){
//            map.put(item, map.getOrDefault(item, 0) + 1);
//        }
//
//        int idx2 = 0;
//        ArrayList<Integer> list = new ArrayList<>(map.keySet());
//        Collections.sort(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            int cnt = map.get(list.get(i));
//            while (cnt>0){
//                arr[idx2++] = list.get(i);
//                cnt--;
//            }
//        }
      }
        */

    //셀 정렬 Shell Sort
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;

        for (int g = gap; g > 0 ; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                int tmp = arr[i];
                int j = 0;
                for (j = i - g; j >= 0; j -= g) { // 0 부터
                    if(arr[j] > tmp){ //tmp값보다 크면
                        arr[j + g] = arr[j]; //tmp쪽에 넣어줌
                    }else {
                        break;
                    }
                }
                arr[j + g] = tmp; //갭 간격으로 삽입정렬을 진행
            }
        }
    }

    public static void main(String[] args) {
        //Test code

        /*
        //Radix Sort 기수정렬
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬 : " + Arrays.toString(arr));
        */

        /*
        //Counting Sort 계수정렬
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬 : " + Arrays.toString(arr));
        */

        //셀 정렬 Shell Sort
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셀 정렬 : " + Arrays.toString(arr));
    }
}
