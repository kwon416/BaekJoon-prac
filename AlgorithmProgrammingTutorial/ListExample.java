package AlgorithmProgrammingTutorial;

import java.util.*;
import java.util.stream.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 요소 삽입
        list.add("one");

        // 특정 인덱스에 요소 삽입
        list.add(0, "zero");
        
        // 리스트 병합 (추가되는 리스트가 뒤)
        list.addAll(list2);
        
        // 특정 요소의 첫붠째 인덱스 반환
        list.indexOf("zero"); // 0
        
        // 특정 요소의 마지막 인덱스 반환
        list.lastIndexOf("zero");
        
        // 특정 인덱스 값 삭제
        list.remove(0);
        
        // 첫번째 값 삭제
        list.remove("one");
        
        // 리스트 차집합
        list.removeAll(list2); // list 에서 list2에 있는 모든 값을 삭제
        
        // 리스트 교집합
        list.retainAll(list2);

        // 리스트 비우기
        list.clear();

        // 리스트 비어있는지 첵크
        list.isEmpty();

        // 길이
        list.size();

        // 특정 요소 포함 여부
        list.contains("one");

        // 리스트에 다른 리스트 요소가 전부 있는 지
        list.containsAll(list2); // list 에 list2 의 모든 값이 포함되어 있으면  true

        // 람다식 사용하여 요소 제거
//        list.removeIf(x -> x % 2 == 0);
        
        // 문자열 타입 배열을 리스트로 변환
        String[] arr = {"apple", "banana", "lemon"};
        List<String> list3 = new ArrayList<>(Arrays.asList(arr));
        
        // 리스트를 문자열 배열로 변환
        String[] arr2 = list3.toArray(new String[list3.size()]);

        // 정수 배열을 리스트로 변환
        int[] arr3 = {1,2,3,4};
        List<Integer> list4 = Arrays.stream(arr3).boxed().toList();


    }
}
