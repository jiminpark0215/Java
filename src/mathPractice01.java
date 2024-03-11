import java.util.ArrayList;
// 기초 수학 - 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1 ~ 10 사이의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1 ~ 10 사이의 수 중 A의 약수이면서 B의 약수인 경우의 수
public class mathPractice01 {
    //약수
    public ArrayList getDivisor(int num){
        ArrayList result = new ArrayList();

        for (int i = 1; i <= (int)num/2 ; i++){
            if (num % i == 0){
                result.add(i);
            }
        }
        result.add(num);

        return result;
    }

    //최대 공약수 (GCD : the Greatest Common Denominator)
    public int getGCD(int numA, int numB){
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA); //각각의 약수들
        ArrayList divisorB = this.getDivisor(numB);

        for (int itemA : (ArrayList<Integer>)divisorA){
            for (int itemB : (ArrayList<Integer>)divisorB){
                if (itemA == itemB){ //약수들끼리 비교해서 같은 값이면서
                    if (itemA > gcd){ //gcd 값보다 큰 수일 때
                        gcd = itemA; // 값을 대입
                    }
                }
            }
        }

        return gcd;
    }

    //최소 공배수 (LCM : the Lowest Common Multiple)
    public int getLCM(int numA, int numB){
        int lcm = -1;

        int gcd = this.getGCD(numA, numB); // 최대 공약수

        if (gcd != -1){
            lcm = numA * numB / gcd;
        }
        return lcm;
    }

    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 6;

        mathPractice01 p = new mathPractice01();

        ArrayList l1 = p.getDivisor(number1);
        ArrayList l2 = p.getDivisor(number2);

        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수 : " + p.getGCD(number1, number2));
        System.out.println("최소 공배수 : " + p.getLCM(number1, number2));

    }
}