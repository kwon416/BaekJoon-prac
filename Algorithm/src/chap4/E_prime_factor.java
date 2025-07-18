package chap4;

import java.io.*;
import java.lang.*;
import java.util.*;


public class E_prime_factor {
    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        long N = scanner.nextLong();

        // N을 소인수 분해한다
        ArrayList<Long> factors = MathUtil.factorize(N);

        // 정답을 출력한다
        System.out.printf("#%d:\n", caseIndex);
        for(int i = 0 ; i <factors.size();i+=1)
        {
            System.out.print(factors.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

}


class MathUtil{
    /**
     * 자연수 N을 구성하는 모든 소인수를 반환하는 함수
     *
     * @param N
     * @return
     */
    public static ArrayList<Long> factorize(long N)
    {
        ArrayList<Long> factors = new ArrayList<>();

        for(long div = 2; div * div <= N; div++) {
            // div는 2부터 sqrt(N) 까지의 모든 정수가 차례로 한 번씩 오름차순으로 등장한다.
            while(N % div ==0) {
                // div 는 소인수 중 하나

                factors.add(div);
                N /= div;
            }
            // 만약에 남은 N 이 소수라면? div <= sqrt(N) 까지 탐색을 하다가 종료된다.
        }
        if(N > 1) {
            factors.add(N);
        }

        return factors;
    }
}