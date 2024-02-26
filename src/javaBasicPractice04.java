//for문 연습 - 별찍기

import java.util.Scanner;

public class javaBasicPractice04 {
    public static void solution(int n , int type){
        if(type == 1){
            type1(n);
        }else if(type == 2){
            type2(n);
        }else if(type == 3){
            type3(n);
        }else if(type == 4){
            type4(n);
        }else if(type == 5){
            type5(n);
        }
    }

    public static void type1(int n){
        System.out.println("=== Type1 ===");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type2(int n){
        System.out.println("=== Type2 ===");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type3(int n){
        System.out.println("=== Type3 ===");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type4(int n){
        System.out.println("=== Type4 ===");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i) - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i * 2) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type5(int n){
        System.out.println("=== Type5 ==="); // 다이아몬드
        //상단
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j < (n / 2) - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i * 2) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //하단
        for (int i = n / 2; i > 0 ; i--) {
            for (int j = 0; j < (n / 2) + 1 - i; j++) { //공백 늘려나감
                System.out.print(" ");
            }
            for (int j = 0; j < (i * 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        solution(5, 1);
        solution(5, 2);
        solution(5, 3);
        solution(5, 4);
        solution(7, 5);

    }

}
