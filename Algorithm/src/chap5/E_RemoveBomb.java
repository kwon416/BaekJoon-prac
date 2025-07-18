package chap5;

import java.io.*;
import java.lang.*;
import java.util.*;


public class E_RemoveBomb {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 문제의 조건에 따라 모든 폭탄을 제거할 수 있는지 판단하는 함수
     *
     * @param n
     * @param bombs
     * @return
     */
    public static boolean isAllRemovable(int n, Bomb[] bombs){
        // 현재 제거 완료된 폭탄들의 목록
        ArrayList<Bomb> removedList = new ArrayList<>();

        // 제거해도 전혀 이상이 없는 폭탄들의 목록
        Queue<Bomb> removableBombs = new LinkedList<>();

        // 초기 제거 가능한 폭탄 찾기
        for(Bomb b : bombs) {
            if(b.getChildCount() == 0) {
                removableBombs.add(b);
            }
        }

        // 제거 가능한 폭탄 찾기
        while(removableBombs.size() > 0) {
            Bomb b = removableBombs.poll();
            b.remove(); // 부모 노드들의 카운트를 감소시킨다.
            removedList.add(b);

            // 부모였던 노드들 중 새롭게 제거 가능해진(childCount 가 0인) 노드를 찾아 큐에 넣는다.
            for(Bomb p : b.getParentBombs()) {
                if(p.getChildCount() == 0) {
                    // 제거 가능해진 노드이므로 큐에 삽입
                    removableBombs.add(p);
                }
            }
        }


        // 모든 n개의 폭탄이 제거 완료되었다면 true, else false
        if(removedList.size() == n){
            return true;
        }else{
            return false;
        }
    }

    public static void testCase(int caseIndex) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Bomb[] bombs = new Bomb[n];
        for (int i = 0; i < n; i += 1) {
            bombs[i] = new Bomb(i);
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            Bomb parent = bombs[u];
            Bomb child = bombs[v];

            child.addParentBombs(parent);
        }

        boolean removable = isAllRemovable(n, bombs);

        if(removable){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

    }

}

class Bomb {
    public final int index;

    private int childCount; // 이 폭탄이 터졌을 때 함께 폭발하는 연쇄 폭탄의 수

    private ArrayList<Bomb> parentBombs; // 이 폭탄의 폭발을 유발할 수 있는 폭탄 리스트

    Bomb(int index) {
        this.index = index;
        this.parentBombs = new ArrayList<>();
        this.childCount = 0;
    }

    public void addParentBombs(Bomb parentBomb) {
        this.parentBombs.add(parentBomb);
        parentBomb.childCount += 1;
    }

    public ArrayList<Bomb> getParentBombs() {
        return this.parentBombs;
    }

    // 현재 이 폭탄이 제거되었을 때 폭발할 수 있는 폭탄의 수
    public int getChildCount() {
        return childCount;
    }

    public void remove() {
        // 이 폭탄을 제거한다.
        // 그러므로 부모 폭탄들은 연쇄 폭탄 하나가 사라진 꼴이 된다.
        for (int i = 0; i < parentBombs.size(); i += 1) {
            Bomb p = parentBombs.get(i);
            p.childCount -= 1;
        }
    }
}