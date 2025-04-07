package silver;

import java.util.*;

public class q1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] A = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            A[i] = Integer.parseInt(s.substring(i, i+1));
        }

        for (int i = 0; i < s.length(); i++) {
            int max = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (A[max] < A[j]) max = j;
            }
            if (A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for (int i = 0; i < A.length; i++){
            System.out.print(A[i]);
        }
    }
}
