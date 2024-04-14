/*
처리일자 : 20240212
처리자 : 박지민

6번 과제 - 가상 대선 당선 시뮬레이션 프로그램
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class homework06 {
    public static void main(String[] args) {
        Scanner voteScan = new Scanner(System.in);//입력받기 위해 선언

        int totalVoteCnt;
        int VirtualVote;
        String voteCandidateName;

        ArrayList<String> voteCandidate = new ArrayList<String>();  //후보자명 보관

        while (true) {
            System.out.print("총 진행할 투표수를 입력해 주세요. ");
            totalVoteCnt = voteScan.nextInt();
            if (totalVoteCnt < 1 || totalVoteCnt > 10000) {  //입력조건 : 1 ~ 10000 사이의 정수
                System.out.println("1 ~ 10000 사이의 수를 입력해 주세요");
                continue;
            }

            System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요. ");
            VirtualVote = voteScan.nextInt();
            if (VirtualVote < 2 || VirtualVote > 10) {  //입력조건 : 2 ~ 10 사이의 정수
                System.out.println("2 ~ 10 사이의 수를 입력해 주세요");
                continue;
            }

            for (int i = 0; i < VirtualVote; i++) {
                System.out.print(i + 1 + "번째 후보자이름을 입력해 주세요. ");
                voteCandidateName = voteScan.next();

                if (voteCandidateName.length() < 0 || voteCandidateName.length() > 9) {  //입력조건 : 10자 미만으로 입력
                    System.out.println("1 ~ 10자 미만의 글자를 입력해 주세요");
                    continue;
                }

                voteCandidate.add(voteCandidateName); //입력받은 후보자명을 담음
            }

            System.out.println();
            break;
        }

        Random voteRandom = new Random(); //난수 뽑기
        int voteNumber = 0;

        int[] resultVote = new int[VirtualVote]; //당선자를 후보자 중에서 뽑기 때문에 후보자 인원수만큼 배열 생성

        for (int i = 0; i < totalVoteCnt; i++) { //총 투표수 만큼 반복

            //투표진행률 = 현재 투표인원 / 전체 인원 * 100
            double voteProgress = (double) (i + 1) / totalVoteCnt * 100; //총 투표수로 진행율 계산시 1부터 인원수를 따짐

            voteNumber = voteRandom.nextInt(VirtualVote) + 1; //랜덤으로 각각의 득표수 생성시 1부터 증가함

            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s\n", voteProgress, (i + 1), voteCandidate.get(voteNumber - 1));  // 서식에 맞게 소수처리, 정수 명, 저장한 후보자 차례대로 출력
            resultVote[voteNumber - 1]++;

            for (int j = 0; j < VirtualVote; j++) {//후보자 인원수만큼 반복
                double turnout = (double) resultVote[j] / totalVoteCnt * 100;  //개인당 투표율 계산

                System.out.printf("[기호:%d] %s:\t", (j + 1), voteCandidate.get(j)); //기호와 이름 출력 (기호는 1번부터 생성)

                //투표자
                System.out.printf("\t%.2f%% \t (투표수: %d)\n", turnout, resultVote[j]); //개인별 비율과 투표수 출력
            }
            System.out.println();
        }

        int maxIndex = 0;//최다 득표수
        int voteIndex = 0;
        //투표결과 . 최다 득표자를 찾기위해 maxIndex를 이용, 가장 큰 index값가 당선자가 됨
        for (int i = 0; i < resultVote.length; i++) {//가상 후보자만큼 득표값을 비교
            if (resultVote[i] > maxIndex) {
                resultVote[i] = maxIndex;
                voteIndex = i;

            }
        }
        System.out.println("[투표결과] 당선인 : " + voteCandidate.get(voteIndex));

    }
}
