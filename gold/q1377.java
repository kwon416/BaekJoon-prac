package gold;

import java.util.*;
import java.io.*;

public class q1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        mData[] A = new mData[n];

        for (int i = 0; i < n; i++) {
            A[i] = new mData(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        System.out.println(max+1);



    }

    public static class mData implements Comparable<mData> {
        int value;
        int index;

        public mData(int index, int value) {
            super();
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }


    }
}
