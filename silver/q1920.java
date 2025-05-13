package silver;

import java.io.*;
import java.util.*;

public class q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] queries = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int target : queries) {
            sb.append(binarySearch(A, target)).append("\n");
        }
    }

    private static int binarySearch(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) return 1;
            else if (A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] A = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(A);
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            boolean find = false;
//            int target = Integer.parseInt(st.nextToken());
//            int start = 0;
//            int end = N-1;
//            while (start <= end) {
//                int midi = (start + end) / 2;
//                int mid = A[midi];
//                if (mid > target) end = midi - 1;
//                else if (mid < target) start = midi + 1;
//                else {
//                    find = true;
//                    break;
//                }
//            }
//            if (find) System.out.println("1");
//            else System.out.println("0");
//        }
//    }
}
