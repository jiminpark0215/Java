import java.util.ArrayList;
import java.util.Arrays;

//20240225
/*
주어진 nums 배열에서 3 개의 합이 0이 되는 모든 숫자들을 출력하세요
중복된 숫자 set은 제외하고 출력
 */
public class twoPointerPractice04 {
    public static ArrayList<ArrayList<Integer>> solution(int[] nums){
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//결과 반환용 변수

        for (int i = 0; i < nums.length - 2 ; i++) { //포인터 갯수를 뺀 길이만큼 돌림
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]){
                int p1 = i + 1; //왼쪽에서 0번째는 제일 작은 값. 그래서 1번째로 지정
                int p2 = nums.length - 1; //오른쪽 끝
                int sum = 0 - nums[i];

                while (p1 < p2){
                    if(nums[p1] + nums[p2] == sum){
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));

                        while (p1 < p2 && nums[p1] == nums[p1 + 1]){
                            p1++;
                        }

                        while (p1 < p2 && nums[p2] == nums[p2 - 1]){
                            p2--;
                        }

                        p1++;
                        p2--;

                    }else if (nums[p1] + nums[p2] < sum){
                        p1++;
                    }else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Test code
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution(nums));

        nums = new int[] {1, -7, 6, 3, 5, 2};
        System.out.println(solution(nums));

    }
}
