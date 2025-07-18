package silver;

import java.util.*;
import java.io.*;

public class q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = N-1; i >= 0; i--) {
            if (k >= A[i]) {
                cnt += k / A[i];
                k = k % A[i];
            }
        }

        System.out.println(cnt);
    }
}
