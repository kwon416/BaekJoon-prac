package chap3;

import java.io.*;
import java.lang.*;
import java.util.*;


public class D_Fibo {
    public static final Scanner scanner = new Scanner(System.in);
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static final int MAX_N = 100000000 + 1;
    public static int[] FIBONACCI_TABLE;


    public static int getFiboByIter(int n) {
        int answer = 0;
        int a = 0;
        int b = 1;

        for(int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return answer;
    }

    /**
     * 피보나치 수열의 1~n번째 항을 배열에 저장하여 반환해주는 함수
     * * 단, 항의 가장 뒤 8자리만을 저장한다.
     * @param n
     * @return fibo[i] := 피보나치 수열의 i번째 항
     */
    public static int[] makeFibonacciTable(int n)
    {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
            // i = 2 -> fib[0] + fib[1]
            // i = 3 -> fib[1] + fib[2]

            fib[i] = (fib[i-1] + fib[i-2]) % 100000000;
        }
        return fib;
    }

    /**
     * 피보나치 수열의 n번째 항을 반환하는 함수
     * 단, 항의 가장 뒤 8자리만을 반환한다.
     * @param n
     * @return
     */
    public static int getFibo(int n)
    {
        int answer = FIBONACCI_TABLE[n];
        return answer;
    }

    public static void main(String[] args) throws Exception {

        //가능한 모든 범위에 대한 피보나치 수열의 값을 계산해두자
        FIBONACCI_TABLE = makeFibonacciTable(MAX_N);

        //테스트케이스를 반복 수행한다.
        int caseSize = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1)
        {
            int n = scanner.nextInt();

            //피보나치 수열의 n번째 항을 계산하여 출력한다.
            int answer = getFibo(n);
            writer.write(String.valueOf(answer) + "\n");
        }

        //불필요한 배열은 가능하면 할당 해제해주는 버릇을 들이자.
        FIBONACCI_TABLE = null;

        writer.flush();
        writer.close();
    }

}
