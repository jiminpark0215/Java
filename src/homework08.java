/*
처리일자 : 20240219
처리자 : 박지민

8번 과제 - 연소득 과세금액 계산 프로그램
 */

import java.util.*;

public class homework08 {
    public static void main(String[] args) {
        System.out.println("[과세금액 계산 프로그램]");
        Scanner incomeScan = new Scanner(System.in);//입력받기 위해 선언

        System.out.print("연소득을 입력해 주세요.:");
        long annualIncomeAmount = incomeScan.nextLong(); //int(-2,147,483,648 ~ 2,147,483,647)쓰면 에러남

        long taxAmount = taxAmountCalculation(annualIncomeAmount);
        long progressiveDeduction = progressiveDeductionCalculation(annualIncomeAmount);

        System.out.println();
        System.out.println("[세율에 의한 세금]:\t\t\t" + String.format("%15d", taxAmount));
        System.out.println("[누진공제 계산에 의한 세금]:\t" + String.format("%15d", progressiveDeduction));

    }

    //2022년도 기준
    //과세표준(해당 금액 기준으로 계산이 이루어짐)
    public static long[] standardTaxation = { 12000000L, 46000000L, 88000000L, 150000000L, 300000000L, 500000000L, 1000000000L };

    //세율
    public static long[] taxRate = { 6, 15, 24, 35, 38, 40, 42, 45 };
    //누진공제
    public static long[] progressiveDeduction = { 0L, 1080000L, 5220000L, 14900000L, 19400000L, 25400000L, 35400000L, 65400000L };

    //세액산출
    public static long taxAmountCalculation(long annualIncomeAmount){
        long totalTax = 0;

        //입력한 연소득이 얼마의 세금계산에 해당되는지 금액 비교
        if( annualIncomeAmount <= standardTaxation[0]){ // 연소득 1200만원 이하
            totalTax = (long)(annualIncomeAmount * taxRate[0] / 100);
            System.out.printf("%15d * %3d%% = % 15d\n", standardTaxation[0], taxRate[0], totalTax);
            return totalTax;

        }else { // 연소득 1200만원 초과
            totalTax += standardTaxation[0] * taxRate[0] / 100;
            annualIncomeAmount -= standardTaxation[0]; //1200만원 차액 대입
            System.out.printf("%15d * %3d%% = % 15d\n", standardTaxation[0], taxRate[0], totalTax);

            //세율 15% 이상 붙는 경우
            for (int j = 1; j < taxRate.length -1; j++) {
                if( annualIncomeAmount <= standardTaxation[0]){
                    totalTax += annualIncomeAmount * taxRate[j] / 100;
                    System.out.printf("%15d * %3d%% = % 15d\n", annualIncomeAmount, taxRate[j], (long)(annualIncomeAmount * taxRate[j]) / 100);
                    return totalTax;

                }else { //세율기준에 따라 1200만원 이상 연소득은 표준금액과 차액된 금액에 추가 세율계산이 필요
                    long remainingAmount = standardTaxation[j] - standardTaxation[j-1];
                    totalTax += remainingAmount * taxRate[j] / 100;
                    annualIncomeAmount -= remainingAmount;
                    System.out.printf("%15d * %3d%% = % 15d\n", remainingAmount, taxRate[j], (long)(remainingAmount * taxRate[j]) / 100);

                }
            }
        }
        return totalTax;
    }

    //누진공제
    public static long progressiveDeductionCalculation(long annualIncomeAmount){
        long totalProgressiveDeduction = 0L;

        for (int i = 0; i < standardTaxation.length; i++) {
            if(annualIncomeAmount <= standardTaxation[0]){ //연소득 1200만원 이하
                totalProgressiveDeduction = (annualIncomeAmount * taxRate[0] / 100);
                break;

            }else if(standardTaxation[i] < annualIncomeAmount && annualIncomeAmount <= standardTaxation[i+1] ){ //1200만원 초과 및 10억 이하
                long amount = (long) annualIncomeAmount * taxRate[i+1] / 100;
                totalProgressiveDeduction = amount - progressiveDeduction[i+1];
                break;

            }else if(annualIncomeAmount > standardTaxation[6]){ //10억원 초과
                long amount = (long)annualIncomeAmount * taxRate[7] / 100;
                totalProgressiveDeduction = amount - progressiveDeduction[7];
                break;
            }
        }
        return totalProgressiveDeduction;
    }
}
