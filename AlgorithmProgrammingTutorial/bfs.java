package AlgorithmProgrammingTutorial;

import java.util.*;

public class bfs {
    public static void main(String[] args) {
        // 큐를 사용, 최단 경로
        int n = 6; // 노드 개수
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프 연결 정보
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(6);

        boolean[] visited = new boolean[n+1];
        System.out.print("BFS 탐색 순서: ");
        bfs(1, graph, visited);
    }

    public static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph.get(node)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
