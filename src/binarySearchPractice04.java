//20240224
/*
정수형 배열 weights 와 정수 days 가 주어졌다.
weights 에는 각 상품의 무게들의 정보가 들어있고 days 는 운송 납기일이다.
상품들은 weights 에 젹혀있는 순서대로 실어서 운송해야하는데,
days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요
*/
public class binarySearchPractice04 {
    public static int solution(int[] weights , int days){
        int left = 0;
        int right = 0;

        for (int w : weights){
            left = Math.max(left, w);
            right += w;
        }
        while (left <= right){
            int mid = (left + right) / 2 ;
            int cnt = 1;
            int cur = 0;

            for (int w : weights){
                if(cur + w > mid){
                    cnt += 1;
                    cur = 0;
                }
                cur += w;
            }

            if(cnt > days){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args){
        //Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));
    }
}