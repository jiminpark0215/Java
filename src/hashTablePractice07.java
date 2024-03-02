//20240302
//정수형 배열 nums와 target 이 주어졌을 때,
//nums에서 임의의 두 수를 더해 target을 구할 수 있는지 확인하는 프로그램을 작성하세요
//두 수의 합으로 target을 구할 수 있으면 해당 값의 index를 반환하고, 없는 경우 null을 반환하세요.

import java.util.*;

public class hashTablePractice07 {
    public static int[] solution(int[] nums , int target){
        int[] result = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if(ht.containsKey(nums[i])){
                result[0] = ht.get(nums[i]);
                result[1] = i;
                return result;
            }
            ht.put(target - nums[i], i);//10 -7 = 3 을 key로 넣고 key값을 체크
        }

        return null;
    }
    public static void main(String[] args){
        //Test code
        int[] nums = {7, 11, 5, 3};
        System.out.println(solution(nums, 10));

        nums = new int[]{8, 3, -2};
        System.out.println(solution(nums, 6));

        nums = new int[]{1, 2, 3};
        System.out.println(solution(nums, 12));

    }
}
