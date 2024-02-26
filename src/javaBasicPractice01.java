import java.util.Scanner;

//정수 자료형의 숫자를 거꾸로 변환하는 프로그램
public class javaBasicPractice01 {
    public static void solution(int num){
        int numReverse = 0;
        boolean isMinus = false;

        if (num < 0){ //음수일 때
            isMinus = true; 
            num *= -1;
        }

        while (num > 0){ //양수일 때
            int r = num % 10; //몫을 구해서 한자리 씩 떼옴
            num /= 10; //다음 반복을 위해 세팅
            numReverse = numReverse * 10 + r; //뒤집은 값을 만들기 위해 구한 값에 떼온 값 더함
        }

        System.out.println(isMinus ? numReverse * -1 : numReverse);
    }

    public static void main(String[] args){
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);

    }

}
