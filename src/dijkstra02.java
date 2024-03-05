import java.util.ArrayList;
import java.util.PriorityQueue;

//다익스트라 - 기본 사용방법에 우선순위 큐를 추가하여 구현
public class dijkstra02 {
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

        //우선순위 큐 형태 추가
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight); //최소 간선에 대한 정보
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight){
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight){
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
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
