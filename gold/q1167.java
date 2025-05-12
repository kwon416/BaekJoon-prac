package gold;

import java.io.*;
import java.util.*;

public class q1167 {
    public static boolean[] visited;
    public static int[] distance;
    public static ArrayList<Edge>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while (true) {
                int E = Integer.parseInt(st.nextToken());
                if (E == -1) break;
                int V = Integer.parseInt(st.nextToken());
                A[S].add(new Edge(E, V));
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[i] > distance[max]) {
                max = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge i : A[now]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    queue.add(e);
                    visited[e] = true;
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
