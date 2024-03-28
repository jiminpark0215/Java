import java.io.IOException;
import java.util.Scanner;
/*


마을판사가 존재하고 x라고 하자. 모두가 x를 신뢰해야 하므로 ①trust배열 안에 [1,x],[2,x],[3,x]....[n,x]가 전부 있어야 하고
x는 아무도 신뢰하지 않으므로 ②[x,n]은 있으면 안된다
이 값을 계산하기 위해 tsum[N] 배열을 만들어서 tsum[x-1]에 x를 믿는 사람들의 번호의 합을 저장한다.
x가 마을판사이려면 자기자신인 x를 제외한 1~N의 사람들이 전부 x를 신뢰해야 하므로 tsum[x-1][1]은 1~N의 합-x 어야 한다.
그리고 x는 아무도 믿지 않으므로 [x,b]일 때 tsum[x-1]의 값에 -1을 집어넣는다.
이렇게 하면 x를 제외한 모두가 x를 믿는다고 해도 tsum[x-1]의 값은 1~N-x보다 작아진다.
-1대신에 아무 음수 또는 N(N+1)/2보다 큰값을 집어넣어도 된다. 코드는 다음과 같다.


 */

public class codingPractice09 {
    public static int solution(int N, int[][] trust) {
        int[] arr = new int[N];
        int sum = N * (N + 1)/2;

        // [a,b]이면 arr[b-1]에 a를 더함
        for(int x = 0; x < trust.length; x++){
            arr[trust[x][1] - 1] = arr[trust[x][1] - 1] + trust[x][0];
            arr[trust[x][0] - 1] = -1;
        }

        //arr[x-1]이 1~N의 합과 같으면 x 리턴
        for(int i = 0; i < arr.length; i++){
            if((arr[i] + i) + 1 == sum){
                return i + 1;
            }
        }
        return -1;

        //이 방법의 시간복잡도는 O(n) 공간복잡도도 O(n)이다.
    }
    public static void main(String[] args) throws IOException {
        int N = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        solution(N , trust);
    }
}