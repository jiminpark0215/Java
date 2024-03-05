import java.util.ArrayList;

//벨만포드 - 기본 사용방법 (매번 최소 간선을 구하기 위해서 구하는 구현)
public class bellmanFord {
    static class Edge { //간선 정보 관리하기 위한 클래스
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){ //간선들 선언
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }
    public static void bellmanFord(int v , int e , int[][] data, int start){
        Edge[] edge = new Edge[e]; // 간선 수 만큼
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge(data[i][0], data[i][1], data[i][2]); //각각의 간선정보를 객체화
        }

        int[] dist = new int[v + 1]; //최단 경로 계산을 위한 배열 초기화
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE; //각각을 max로 초기화
        }
        dist[start] = 0; //출발지는 0으로 세팅

        boolean isMinusCycle = false;//음수 사이클 체크용

        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < e; j++) { //돌릴 때 마다 모든 간선을 체크.
                Edge cur = edge[j];
                if(dist[cur.from] == Integer.MAX_VALUE){
                    continue;
                }

                if (dist[cur.to] > dist[cur.from] + cur.weight){ //경유해서 가는 경로의 길이가 짧으면
                    dist[cur.to] = dist[cur.from] + cur.weight; //업데이트

                    if (i == v){
                        isMinusCycle = true; // 음수사이클 체크
                    }
                }
            }
        }

        //출력
        System.out.println("음수 사이클 발생 : " + isMinusCycle);

        for (int i = 1; i < v + 1; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            }else{
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
    }
}
