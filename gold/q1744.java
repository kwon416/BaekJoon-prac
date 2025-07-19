package gold;

import java.util.*;

public class q1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 양수는 내림차순 정렬
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input > 1) plusPq.add(input);
            else if (input < 0) minusPq.add(input);
            else if (input == 1) one++;
            else zero++;
        }

        int result = 0;

        while (plusPq.size() > 1) {
            int a = plusPq.remove();
            int b = plusPq.remove();
            result += a * b;
        }
        if (!plusPq.isEmpty()) result += plusPq.remove();

        while (minusPq.size() > 1) {
            int a = minusPq.remove();
            int b = minusPq.remove();
            result += a * b;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) result += minusPq.remove();
        }

        result += one;
        System.out.println(result);

    }
}
