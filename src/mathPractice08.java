
// 기초 수학 - 점화식과 재귀함수
// 재귀 함수를 이용하여 최대공약수 구하기

public class mathPractice08 {
    static int gcd(int a, int b){
        if (a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        //Test Code
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));

    }
}