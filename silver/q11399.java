package silver;

import java.util.*;
import java.io.*;

public class q11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] S = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int insertPoint = i;
            int insertValue = A[i];

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insertPoint = j+1;
                    break;
                }
                if (j == 0) insertPoint = 0;
            }

            for (int j = i; j > insertPoint; j--) {
                A[j] = A[j-1];
            }
            A[insertPoint] = insertValue;
        }

        S[0] = A[0];
        for (int i = 1; i < n; i++) {
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += S[i];
        }

        System.out.println(sum);
    }
}
