package AlgorithmProgrammingTutorial;

import java.util.*;

public class dfs {
    public static void main(String[] args) {
        // 스택과 재귀 활용
        int n = 6; // 노드 개수
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        // 그래프 연결 정보
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(6);

        boolean[] visited = new boolean[n + 1];
        System.out.print("DFS 탐색 순서: ");
        dfs(1, graph, visited);
    }
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }

    public static void stackDfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                for (int i = 0; i < graph.get(node).size(); i++) {
                    int next = graph.get(node).get(i);
                    if(!visited[next]) stack.push(next);
                }
            }
        }
    }
}
