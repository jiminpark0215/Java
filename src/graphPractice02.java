
// 비선형 자료구조 - 그래프
// 인접 행렬 그래프의 DFS, BFS 구현

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends  MyGraphMatrix{
    public MyGraphMatrix2(int size){
        super(size);
    }

   public void dfs(int id) { // 깊이 우선 탐색 (Depth First Search) , DFS
       boolean[] visited = new boolean[this.elemCnt];
       Stack<Integer> stack = new Stack<>();

       stack.push(id);
       visited[id] = true;

       while (!stack.isEmpty()) {
           int curId = stack.pop();
           System.out.print(this.vertices[curId] + " ");

           // 인접행렬 정보를 가지고 교환 순서대로 탐색을 하기 위해 역순으로 돌림
           for (int i = this.elemCnt - 1; i >= 0; i--) {
               if (this.adjMat[curId][i] == 1 && visited[i] == false) {
                   stack.push(i);
                   visited[i] = true;
               }
           }
       }

       System.out.println();
   }

    public void bfs(int id){ //너비 우선 탐색 (Breadth First Search) , BFS
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()){
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            // 인접행렬 정보를 가지고 교환 순서대로 탐색을 하기 위해 역순으로 돌림
            for (int i = this.elemCnt - 1 ; i >= 0 ; i--) {
                if (this.adjMat[curId][i] == 1 && visited[i] == false){ //방문한 적이 없으면
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println();
    }
}

public class graphPractice02 {
    public static void main(String[] args) {
        MyGraphMatrix2 graph = new MyGraphMatrix2(7);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        graph.printAdjacentMatrix();

        System.out.println();
        graph.dfs(0);
        graph.bfs(0);
    }
}