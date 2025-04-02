import java.util.*;
import java.io.*;
public class q1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for (int k = 0; k < N; k++) {
            int i = 0;
            int j = N-1;
            int find = A[k];

            while (i < j) {
                if (A[i] + A[j] == A[k]) {
                    if (i != k&& j != k) {
                        count++;
                        break;
                    } else if (i == k) i++;
                    else if (j == k) j--;
                } else if (A[i] + A[j] < A[k]) i++;
                else j--;
            }
        }

        System.out.println(count);
        br.close();
    }
}
