package bronze;

import java.io.*;
import java.util.*;

public class q10989  {

    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        radixSort(A, 5);
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }


    public static void radixSort(int[] A, int maxSize) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;

        while (count != maxSize) { // 최대 자릿수만큼 반복하기
            int[] bucket = new int[10];

            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++; // 1의 자리부터 시작하기
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }

            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }
            
            for (int i = 0; i < A.length; i++) {
                // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
                A[i] = output[i];
            }

            jarisu = jarisu * 10;
            count++;
        }
    }
}
