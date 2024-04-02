import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 1260

DFS와 BFS
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	280237	109207	64863	37.649%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

 */

public class codingPractice15 {
    public static int N;
    public static int M;
    public static int V;
    public static boolean[] visit;
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(V);
        Arrays.fill(visit, false);
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int num) {
        visit[num] = true;
        sb.append(num).append(" ");
        for (int i = 1; i <= N; i++) {
            if(arr[num][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int num) {
        q.add(num);
        visit[num] = true;
        sb.append('\n').append(num).append(" ");
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 1; i <= N; i++) {
                if(arr[idx][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}