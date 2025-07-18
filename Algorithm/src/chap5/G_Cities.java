package chap5;

import java.io.*;
import java.lang.*;
import java.util.*;


public class G_Cities {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getMaximumRangeDifference(int n, int k, City[] cities){
        int answer = 0;

        // 소득이 가장 작은 도시부터 pop되는 우선순위 큐
        PriorityQueue<City> rangeMinimum = new PriorityQueue<>();

        // 소득이 가장 높은 도시부터 pop되는 우선순위 큐
        PriorityQueue<City> rangeMaximum = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            City c = cities[i]; // c 모든 도시가 차례로 한 번씩 등장

            int rightEnd = i; // cities[i]가 윈도우의 마지막 원소
            int leftEnd = i - k + 1; // cities[i-k+1] 가 윈도우의 첫 원소
            rangeMaximum.add(c);
            rangeMinimum.add(c);

            // 윈도우를 벗어난 원소 삭제 -> min, max 에 영향을 주는 원소만 삭제
            while(rangeMaximum.size() > 0 && rangeMaximum.peek().index < leftEnd) {
                rangeMaximum.poll();
            }
            while(rangeMinimum.size() > 0 && rangeMinimum.peek().index <  leftEnd) {
                rangeMinimum.poll();
            }
            // 이제 rangeMin, rangeMax 에는 결과에 영향을 주는 윈도우 밖의 원소는 모두 삭제된 상태.
            if(leftEnd < 0) continue;

            // 윈도우의 k개의 원소가 있을 때,
            // 힙에 k개 이상의 원소가 있을 때, 다만 k개에 원소에 대한 최대/최소에 영향을 주지 않을 때
            int maximum = rangeMaximum.peek().income;
            int minimum = rangeMinimum.peek().income;
            int diff = maximum - minimum;
            answer = Math.max(answer, diff);

        }


        return answer;
    }

    public static void testCase(int caseIndex) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        City[] cities = new City[n];

        for(int i = 0 ; i < n ; i += 1){
            int income = scanner.nextInt();
            cities[i] = new City(i, income);
        }

        int answer = getMaximumRangeDifference(n, k, cities);

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

}


class City implements  Comparable<City>{
    public final int index;     // 도시의 인덱스
    public final int income;    // 해당 도시의 소득

    public City(int index, int income){
        this.index = index;
        this.income = income;
    }

    @Override
    public int compareTo(City o) {
        // 소득에 대해 우선순위를 가지도록 대소관계를 정의해준다
        return this.income - o.income;
    }
}