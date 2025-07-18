package gold;

import java.util.*;


public class q1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        long start = 0;
        long end = k;
        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++){
                cnt += Math.min(mid / i, N);
            }

            if (cnt < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
