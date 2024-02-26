//for문 연습 - 별찍기

public class javaBasicPractice05 {
    public static int solution(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right){
            int x = (right - left);
            int y = height[left] < height[right] ? height[left] : height[right]; // 작으면 오른쪽
            int curArr = x * y;
            maxArea = maxArea > curArr ? maxArea : curArr;
//            curArr = x * Math.min(height[left], height[left]); //이렇게도 사용가능
//            maxArea = Math.max(maxArea, curArr); //이렇게도 사용가능

            if(height[left] < height[right]){ // 작은 쪽은 한칸 옮겨서 큰 면적이 나올 수 잇는지 두 벽의 높이를 계산
                left++;
            }else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }

}
