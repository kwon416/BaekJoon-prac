package chap5;

import java.io.*;
import java.lang.*;
import java.util.*;


public class C_Histogram {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽에서 오른쪽으로 차례로 세워진 히스토그램들 내부에 만들 수 있는
     * 최대의 직사각형 넓이를 계산하는 함수
     *
     * @param n             히스토그램의 수
     * @param histograms    히스토그램이 차례로 저장된 배열
     * @return
     */
    public static long getLargestRectangleArea(int n, Histogram[] histograms) {
        long answer = 0;    // 최대 직사각형의 넓이

        // 현재 우측으로 확장 가능성이 있는 히스토그램들
        Stack<Histogram> continuedHistograms = new Stack<>();

        // 가장 왼쪽에 높이 0인 인덱스 추가
        continuedHistograms.push(new Histogram(-1, 0));
        for(int i = 0; i < n + 1; i++) {
            Histogram h = null;
            if(i < n) {
                h = histograms[i];
            } else { // i == n
                h = new Histogram(n, 0);
            }

            // 자기 자신보다 높은 막대들의 넓이를 다 결정한다.
            while(continuedHistograms.size() > 1 && continuedHistograms.peek().height >= h.height) {
                Histogram lh = continuedHistograms.pop(); // 스택의 마지막 원소를 삭제 후 할당
                // 오른쪽으로는 h의 바로 왼쪽까지 확장
                // 왼쪽으로는 스택에 남아있는 마지막 막대기의 바로 오른쪽까지 확장
                Histogram bh = continuedHistograms.peek();

                long width = (h.leftX - bh.rightX);
                long height = lh.height;
                long area = width * height;

                answer = Math.max(area, answer);

            }
            continuedHistograms.push(h);

        }




        return answer;
    }

    public static void testCase(int caseIndex) {
        int n = scanner.nextInt();

        Histogram[] histograms = new Histogram[n];
        for(int i = 0 ; i < n ; i ++) {
            int height = scanner.nextInt();
            histograms[i] = new Histogram(i, height);
        }

        long answer = getLargestRectangleArea(n, histograms);
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

}

class Histogram{
    public final int height;    // 히스토그램의 높이
    public final int leftX;     // 인덱스 혹은 히스토그램의 왼쪽 변의 x 좌표
    public final int rightX;    // 히스토그램의 오른쪽 변의 x좌표

    public Histogram(int index, int height) {
        this.leftX = index;
        this.rightX = this.leftX + 1;   // 각 히스토그램은 너비가 1이므로
        this.height = height;
    }

}