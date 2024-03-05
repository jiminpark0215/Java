import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

//다익스트라 - 기본 사용방법 (매번 최소 간선을 구하기 위해서 구하는 구현)
public class dijkstra {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to ;
            this.weight = weight;
        }

    }
    public static void dijkstra(int v, int[][] data, int start){
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2])); //시작 위치의 노드 -> 얼마만큼의 비용이 드는 지 정보를 구성
        }

        int[] dist = new int[v + 1]; //최단 거리 기록용 메모리

        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE; //초기화
        }

        dist[start] = 0; //스타트위치도 초기화

        boolean[] visited = new boolean[v + 1]; //방문 배열. 이미 방문했으면 진행하지 않음

        for (int i = 0; i < v; i++) { //모든 노드에 대해 방문하면서 거리 정보를 갱신
            int minDist = Integer.MAX_VALUE; //가장 짧은 간선을 찾기 위한 임시변수
            int curIdx = 0; //현제 노드에 대한 정보
            for (int j = 1; j < v + 1; j++) { //
                if (!visited[j] && dist[j] < minDist){ //방문한 적이 없고 거리가 minDist보다 작으면
                    minDist = dist[j]; //최소정보를 가진 노드로 업데이트시킴
                    curIdx = j;
                }
            }

            visited[curIdx] = true;

            for (int j = 0; j < graph.get(curIdx).size(); j++) { //인접 노드의 사이즈만큼
                Node adjNode = graph.get(curIdx).get(j); //인접 노드 값을 가지고 와서
                if (dist[adjNode.to] > dist[curIdx] + adjNode.weight){ //원래 들어있던 값보다 현재 거리와 거쳐가는 해당 비용을 합친게 더 작으면
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight; //최소값으로 업데이트
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE){ //거리 정보에 대한 값이 업데이트 되지 않으면
                System.out.print("INF ");
            }else{ //그 외의 경로에 값이 업데이트 되었으면
                System.out.print(dist[i] + " ");
            }
        }

        System.out.println();

    }

    public static void main(String[] args){
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2 ,3 ,4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
