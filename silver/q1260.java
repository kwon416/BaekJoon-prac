package silver;

import java.util.*;

public class q1260 {
    public static ArrayList<Integer>[] A;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
    }

    static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) DFS(i);
        }
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");
            for (int i : A[n]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }


}
