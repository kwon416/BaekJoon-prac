package chap5;

import java.io.*;
import java.lang.*;
import java.util.*;


public class H_Duplication {
    public static final Scanner scanner = new Scanner(System.in);
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = scanner.nextInt();

//        TreeSet<Integer> integers = new TreeSet<>(); // Tree -> O(logN) 저장한 값들을 대소관계의 순서에 따라서 접근할 필요가 있을 때
        HashSet<Integer> integers = new HashSet<>(); // Hash -> O(1) 문자열 검색에 유리


        for(int i = 0 ; i < N ; i++){
            // integers := 이전까지 등장한 모든 정수를 저장한 집합
            int X = scanner.nextInt();
            if(integers.add(X)) {
                System.out.println("OK");
                // writer.write("OK\n");
            } else {
                System.out.println("DUPLICATED");
                // writer.write("DUPLICATED\n");
            }

        }

        writer.flush();
        writer.close();
    }

}
