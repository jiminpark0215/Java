//알고리즘 백트랙킹
//N-Queen 문제 (N x N 체스판에서 퀸 N개를 서로 공격할 수 없도록 배치하는 경우의 수)

public class backTracking {
    static int n = 4;
    static int[] board = new int[n];
    static int cnt;

    public static int nQueen(int row){
        if (row == n){
            cnt++;

            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;

            //유망한지 아닌지 체크
            if (isPromising(row)){
                nQueen(row + 1);
            }
        }

        return cnt;
    }

    public static boolean isPromising(int row){
        for (int i = 0; i < row; i++) {
            //같은 열이나 대각선에 있는 케이스에 대한 여부
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)  {
        System.out.println("경우의 수 : " + nQueen(0));

    }
}