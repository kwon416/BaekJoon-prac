package gold;

import java.util.*;
import java.io.*;

public class q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] ans = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                int index = stack.pop();
                ans[index] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
