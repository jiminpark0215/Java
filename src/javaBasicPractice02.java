//사용자가 입력한 알파벳의 대소문자를 변경하는 프로그램

import java.util.Scanner;

public class javaBasicPractice02 {
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        System.out.println("알파벳 입력 : ");
        char input = sc.nextLine().charAt(0);
        int output = 0;

        int step = (int)'a' - (int)'A';
        if (input >= 'a' && input <= 'z'){
            output = (int)input - step;
            System.out.println("대문자 변환 : " + (char)output);
        }else if (input >= 'A' && input <= 'Z'){
            output = (int)input + step;
            System.out.println("소문자 변환 : " + (char)output);
        }else {
            System.out.println("입력한 값이 알파벳이 아닙니다.");
        }
    }
    public static void reference(){
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args){
        reference();
        solution();

    }

}
