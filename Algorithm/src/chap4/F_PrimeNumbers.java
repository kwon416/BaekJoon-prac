package chap4;
import java.io.*;
import java.lang.*;
import java.util.*;


public class F_PrimeNumbers {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_VALUE = 1000000;
    public static final Sieve sieve = new Sieve(MAX_VALUE);

    public static ArrayList<Integer> getAllPrimeNumbers(int from, int to)
    {
        ArrayList<Integer> primes = new ArrayList<>();

        for(int num = from; num <= to; num += 1)
        {
            if(sieve.isPrimeNumber(num) == true)
            {
                primes.add(num);
            }
        }

        return primes;
    }

    public static void testCase(int caseIndex) {
        int L = scanner.nextInt();
        int R = scanner.nextInt();

        ArrayList<Integer> allPrimeNumbers = getAllPrimeNumbers(L, R);

        System.out.printf("Case #%d:\n", caseIndex);
        System.out.println(allPrimeNumbers.size());
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

}


class Sieve //소인수 분해를 빠르게
{
    final int maximumValue;     // 에라토스테네스의 체에서 다룰 가장 큰 범위의 값
    final boolean[] isPrime;    // 각 숫자별 소수 여부
    Sieve(int maximumValue)
    {
        this.maximumValue = maximumValue;
        this.isPrime = new boolean[maximumValue+1];
        this.fillSieve();
    }

    /**
     *
     * @param num
     * @return 'num'이 소수라면 true, 그렇지 않으면 false
     */
    public boolean isPrimeNumber(int num)
    {
        return this.isPrime[num];
    }

    /**
     * isPrime 배열의 값을 채우는 함수
     */
    private void fillSieve()
    {

        // 전체 배열을 소수로 선언한다.
        Arrays.fill(isPrime, true);

        // 반복문으로 모든 자연수를 오름차순으로 조회한다.
        isPrime[1] = false;
        for(int num =2; num <= maximumValue; num++) {
            // 만약 소수가 아니라면 스킵하고
            if(isPrime[num] == false) {
                // 이미 앞에서 어떤 소인수가 이 수를 배수로서 삭제했다.
                continue;
            }

            // num은 소수이다.
            // 소수라면 배수를 모두 false로 바꾼다.
            for(int mul = num * num; mul <= maximumValue; mul += num) {
                // 이미 2 부터 num-1 까지의 배수들은 삭제가 되었기 때문에 제곱부터 삭제 가능
                isPrime[mul] = false;
            }

        }

    }
}
