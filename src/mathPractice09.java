
// 기초 수학 - 지수와 로그
public class mathPractice09 {
    public static void main(String[] args) {
        //1. 제곱, 제곱근, 지수
        System.out.println("=== 제곱 ===");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println(Math.pow(-2, 30));
        System.out.printf("%.0f\n", Math.pow(-2, 30)); //소수점 없애고 그대로 출력

        System.out.println("=== 제곱근 ===");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.pow(16, 1.0/2));
        System.out.println(Math.pow(16, 1.0/4));

        //참고) 절대 값
        System.out.println("=== 절대 값 ===");
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5)); //음수의 절대 값 형태

        //2. 로그
        System.out.println("=== 로그 ===");
        System.out.println(Math.E); // 자연 상수
        System.out.println(Math.log(Math.E)); // 자연 상수를 로그로 출력
        System.out.println(Math.log10(1000));
        System.out.println(Math.log(4) / Math.log(2));

    }
}