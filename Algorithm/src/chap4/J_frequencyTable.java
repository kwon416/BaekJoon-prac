package Algorithm.src.chap4;

import java.io.*;
import java.lang.*;
import java.util.*;


public class J_frequencyTable {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_VALUE = 1000000;


    /**
     * 게임의 규칙을 만족하면서 만들 수 있는 가장 큰 최대공약수를 반환하는 함수
     *
     * @param n         주어진 카드의 수
     * @param cards     각 카드에 적힌 숫자 배열
     * @return
     */
    public static int getMaximumGCD(int n, int[] cards)
    {
        int answer = 1;
        int[] frequency = new int[MAX_VALUE + 1];

        // 소인수분해를 한다
        for(int c : cards) {
            ArrayList<Long> factors = MathUtil.factorize(c);
            for(long f : factors) {
                // 모든 소인수에 대해 빈도수 증가
                frequency[(int) f] += 1;
            }
        }

        // 각각의 소인수를 n개의 카드에 균등 분할한다.
        // -> 각 카드에 소인수 p를 frequency[p] / n 만큼 곱해준다
        for(int i = 2; i <= MAX_VALUE; i += 1) {
            // 모든 소인수 i에 대해
            // 어차피 소인수가 아니면 빈도수 0이라 스킵
            if(frequency[i] == 0) continue;

            // 균등 분할 하려면 몇 개씩?
            int count = frequency[i] / n;
            answer *= MathUtil.powInt(i, count);

        }



        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] cards = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            cards[i] = scanner.nextInt();
        }

        int answer = getMaximumGCD(n, cards);

        System.out.println(answer);
    }

}

class MathUtil{
    /**
     *
     * @param N
     * @return
     */
    public static ArrayList<Long> factorize(long N) // 최몇
    {
        ArrayList<Long> factors = new ArrayList<>();
        for(long div = 2; div * div <= N; div += 1) {
            // 약수면
            while(N % div == 0) {
                factors.add(div);
                N /= div;
            }
        }
        // 큰 소인수 하나가 남으면
        if(N > 1) factors.add(N);
        return factors;
    }


    /**
     * 두 정수 a, n에 대해 a ^ n을 계산해주는 함수
     *
     * @param a
     * @param n
     * @return
     */
    public static int powInt(int a, int n)
    {
        int result = 1;
        for(int i = 0; i < n; i += 1) {
            result *= a;
        }
        return result;

    }
}



