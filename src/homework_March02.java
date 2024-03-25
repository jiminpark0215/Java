
import java.util.*;

//20240312 박지민 - 깜짝과제 2

public class homework_March02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력
        System.out.println("나의 좌표 x 값을 입력해 주세요");
        int x = sc.nextInt();
        System.out.println("나의 좌표 y 값을 입력해 주세요");
        int y = sc.nextInt();

        int cnt = 0;
        ArrayList<Integer> arrX = new ArrayList<>();
        ArrayList<Integer> arrY = new ArrayList<>();

        while (true){
            System.out.println( "10번 중 " + ( arrX.size() + 1 ) + "번째 입력" );

            System.out.println("임의의 좌표 x 값을 입력해 주세요");
            int randomX = sc.nextInt();
            System.out.println("임의의 좌표 y 값을 입력해 주세요");
            int randomY = sc.nextInt();

            if (arrX.contains(randomX) && arrY.contains(randomY)){
                System.out.println("이미 동일한 좌표값이 존재합니다. 다시 입력해주세요.");
            }else {
                arrX.add(randomX);
                arrY.add(randomY);
            }

            if (arrX.size() == 10){
                break;
            }
        }

        //출력
        double min = Integer.MAX_VALUE;
        int distX = 0;
        int distY = 0;

        for (int i = 0; i < arrX.size(); i++) {
            System.out.println("(" + arrX.get(i) + " , " + arrY.get(i) + ")");
            //거리
            double distance = Math.sqrt(Math.pow(arrX.get(i), 2) + Math.pow(arrY.get(i), 2)); // 거리 = 제곱근( (x * x) + (y * y) )
            //좌표값과 비교
            if (distance < min){
                min = distance;
                distX = arrX.get(i);
                distY = arrY.get(i);
            }
        }

        System.out.println("나와 가장 가까운 좌표값은 (" + distX + "," + distY + ") 입니다.");

    }
}