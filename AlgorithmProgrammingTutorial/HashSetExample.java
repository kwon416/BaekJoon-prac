package AlgorithmProgrammingTutorial;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        // HashSet: 중복 허용 X, 순서 X
        // LinkedHashSet: 중복 허용 X, 순서 O (삽입 순)
        // TreeSet: 중복 허용 X, 이진 탐색 트리 형태로 데이터 저장, 정렬됨

        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        // 요소 추가
        hs.add(1);

        // 요소 삭제
        hs.remove(1); // 값이 1인 요소 삭제

        // 차집합
        hs.removeAll(hs2);

        //  교집합
        hs.retainAll(hs2);

        // 초기화
        hs.clear();

        // 사이즈
        hs.size();

        // 특정 요소 포함 여부
        hs.contains(1);

        // 요소 전체 출력
        // Iterator 사용
        Iterator<Integer> tempIterator = hs.iterator();
        while(tempIterator.hasNext()) {
            System.out.println(tempIterator.next());
        }

        // for-each 사용
        for (Integer item : hs) {
            System.out.println(item);
        }



    }
}
