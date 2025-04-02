package AlgorithmProgrammingTutorial;

import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 요소 추가
        stack.push(1);

        // 요소 꺼내기
        stack.pop();

        //스택 최상단 요소 확인하기
        stack.peek();

        // 스택 비우기
        stack.clear();

        // 스택 크기 체크
        stack.size();

        // 스택이 비었는 지 유무 확인
        stack.isEmpty();

        // 스택에 요소 존재하는 지 확인
        stack.contains(1);


    }
}
