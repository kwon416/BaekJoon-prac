package gold;

import java.util.*;

public class q1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int cnt = 0;

        while (pq.size() > 1) {
            int data1 = pq.remove();
            int data2 = pq.remove();
            cnt += data1 + data2;
            pq.add(data1 + data2);
        }

        System.out.println(cnt);
    }
}
