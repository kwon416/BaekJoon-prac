package gold;

import java.util.*;

public class  q10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        for (int i = 1; i < N; i++) {
            // 합 배열 생성
            S[i] = S[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            // 나머지 구하기
            int remainder = (int) (S[i] % M);
            // 나머지가 0 이면 0 ~ i 에서 나누어 떨어지는 경우
            if (remainder == 0) answer++;
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += C[i] * (C[i]-1) / 2;
            }
        }
        System.out.println(answer);
    }
}
