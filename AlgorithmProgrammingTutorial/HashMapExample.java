package AlgorithmProgrammingTutorial;

import java.util.*;
import java.util.Map.*;

public class HashMapExample {
    public static void main(String[] args) {
        // HashMap: <key, value> 쌍, value 의 중복 허용, 순서 X
        // LinkedHashMap: <key, value> 쌍, value 의 중복 허용, 순서 O (삽입 순)
        // TreeMap: 순서가 오름차순으로 정렬
        
        HashMap<Integer, String> hm = new HashMap<>();
        
        // 요소 추가
        hm.put(1, "딸기");
        hm.put(2, "바나나");
        hm.put(1, "사과"); // 딸기 가 사과로 바뀜

        // 요소 삭제
        hm.remove(1);

        // 전체 삭제
        hm.clear();

        // key 포함 여부 확인
        hm.containsKey(1);

        // value 포함 여부 확인
        hm.containsValue("사과");

        // 출력
        for(Integer key : hm.keySet()) {
            System.out.println(key + " " + hm.get(key));
        }

        for(Entry<Integer, String> temp : hm.entrySet()) {
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
    }
}
