package AlgorithmProgrammingTutorial;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        // 큐에 요소 추가
        q.add(1); // 문제 상황에서 예외 발생
        q.offer(1); // 문제 상황에서 false 리턴
        
        // 큐에서 요소 제거
        q.remove(); // 문제 상황에서 예외 발생
//        q.pool(); // 
        
        // 큐 비우기
        q.clear();
        
        // 큐 최전방 요소 확인
        q.element(); // 문제 상황에서 예외 발생
        q.peek(); // 문제 상황에서 null 리턴


    }
}
