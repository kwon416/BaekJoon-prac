package chap4;

import java.io.*;
import java.lang.*;
import java.util.*;


public class I_GoldBach {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_VALUE = 1000000;
    public static final Sieve sieve = new Sieve(MAX_VALUE);

    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void testCase(int caseIndex) {
        int x = scanner.nextInt();

        int a = -1;
        int b = -1;

        // 정답을 출력한다
        System.out.printf("Case #%d:\n", caseIndex);
        if(a > 0 && b > 0)
        {
            System.out.printf("%d = %d + %d\n", x, a, b);
        }else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}