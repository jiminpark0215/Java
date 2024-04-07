import java.io.*;
import java.util.*;
/*

백준 2178

문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

 */

public class codingPractice19 {

    static int N, M;
    static int[][] arr;
    static boolean[][] check;
    static int[] moveX = { 0, 0, 1, -1 };
    static int[] moveY = { 1, -1, 0, 0 };
    static Queue<point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        check[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);

        br.close();

    }

    public static void bfs(int x, int y) {

        q.add(new point(x, y));

        while (!q.isEmpty()) {
            point s = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = s.x + moveX[i];
                int nextY = s.y + moveY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (check[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }
                q.add(new point(nextX, nextY));
                arr[nextX][nextY] = arr[s.x][s.y] + 1;
                check[nextX][nextY] = true;
            }
        }
    }

}

class point {
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}