
// 비선형 자료구조 - 그래프
// 인접 리스트 그래프의 DFS, BFS 구현

import java.util.*;
import java.util.LinkedList;

class MyGraphList2 extends MyGraphList{
    public MyGraphList2(int size){
        super(size);
    }

   public void dfs(int id) { // 깊이 우선 탐색 (Depth First Search) , DFS
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()){
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            //링크를 따라가면서 순회
            Node14 cur = this.adjList[curId];
            while (cur != null){
                if (visited[cur.id] == false){
                    stack.push(cur.id);
                    visited[curId] = true;
                }
                cur = cur.next;
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

            Node14 cur = this.adjList[curId];
            while (cur != null){
                if (visited[cur.id] == false){
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

public class graphPractice03 {
    public static void main(String[] args) {
        MyGraphList2 graph = new MyGraphList2(7);

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
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.dfs(0);
        graph.bfs(0);
    }
}