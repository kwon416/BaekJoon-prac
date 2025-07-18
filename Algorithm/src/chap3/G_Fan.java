package chap3;

import java.io.*;
import java.lang.*;
import java.util.*;


public class G_Fan {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getUniqueRangeNumber(int[] birthDate, int n, int k)
    {
        int answer = 0; //모든 원소가 서로 다른 범위의 수

        // 모든 윈도우 중에 모든 원소가 서로 다른 윈도우를 카운트
        // 모든 원소가 서로 다르다 => 모든 원소가 빈도수가 1 => 모든 원소가 유니크하다
        // 모든 원소가 유니크하다 => table.uniqueElements == 현재 원소의 개수

        // table.uniqueElements == k 가 되는 윈도우의 수를 카운트
        FrequencyTable table = new FrequencyTable();
        for(int i = 0; i < k; i++) {
            table.addBirthDate(birthDate[i]);
        }
        if(table.uniqueElements == k) answer += 1;

        // 카운트
        for(int i = 1; i + k - 1 < n; i++) {
            // i-1번째 원소를 제거하고 i+k-1번째 원소를 추가한다.
            table.removeBirthDate(birthDate[i-1]);
            table.addBirthDate(birthDate[i+k-1]);
            if(table.uniqueElements == k) answer += 1;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] birthDate = new int[n];
        for(int i = 0 ; i < n ; i ++)
        {
            birthDate[i] = scanner.nextInt();
        }

        int answer = getUniqueRangeNumber(birthDate, n, k);

        System.out.println(answer);
    }

}

class FrequencyTable
{
    public static final int MAX_SIZE = 1000000;

    int uniqueElements; //현재 중복이 존재하지 않는 unique한 생일의 수
    int[] frequency;    //frequency[b] := 생일이 b인 정보의 수

    FrequencyTable(){
        this.uniqueElements = 0;
        this.frequency = new int[MAX_SIZE];
    }

    /**
     * 새로운 생일을 등록하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void addBirthDate(int birthDate)
    {
        int count = this.frequency[birthDate];

        if(count == 0) this.uniqueElements += 1;
        else if(count == 1) this.uniqueElements -= 1;
        // 빈도수를 증가시킨다.
        this.frequency[birthDate] += 1;
    }

    /**
     * 기존의 생일을 제거하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void removeBirthDate(int birthDate)
    {
        int count = frequency[birthDate];
        if(count == 1) this.uniqueElements -= 1;
        else if (count == 2) this.uniqueElements += 1;

        this.frequency[birthDate] -= 1;
    }

}