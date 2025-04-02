package AlgorithmProgrammingTutorial;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        int[] temp = {1,2,3,10,20};
//        List<Integer> list = new ArrayList<>(Arrays.asList(temp));
        List<Integer> list = Arrays.stream(temp).boxed().toList();

        // 정수형 list 원소 중 최대 최소값
        Collections.max(list);
        Collections.min(list);

        // list 정렬
        Collections.sort(list); // 오름차순
        Collections.sort(list, Collections.reverseOrder()); // 내림차운

        // 뒤집기
        Collections.reverse(list);

        // list 내 원소 개수 반환
        Collections.frequency(list, 3);

        // list 내 원소를 이진탐색으로 찾기
        // 반드시 정렬 필요
        Collections.binarySearch(list, 10); // 3
    }

}
