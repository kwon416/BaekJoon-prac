package silver;

import java.util.*;
import java.io.*;

public class q11724 {

    public static ArrayList<Integer>[] A;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s); // 양방향 에지이므로 양쪽에 에지를 더하기
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int v) {
        if (visited[v]) return;

        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
