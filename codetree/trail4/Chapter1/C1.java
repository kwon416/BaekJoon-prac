package codetree.trail4.Chapter1;


import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Please write your code here.
        int count = 0;
        if (n == 1 && m == 1) {System.out.print(2); return; }
        //행
        for (int i = 0; i < n; i++) {
            int prevR = 1;
            for (int j = 0; j < n - 1; j++) {
                // 행 순회
                if (grid[i][j] == grid[i][j+1]) {
                    prevR++;
                } else {
                    prevR = 1;
                }
                if (prevR >= m) {count++; break;}
            }
        }
        // 열
        for (int i = 0; i < n; i++) {
            int prevC = 1;
            for (int j = 0; j < n - 1; j++) {
                // 열 순회
                if (grid[j][i] == grid[j+1][i]) {
                    prevC++;
                } else {
                    prevC = 1;
                }
                if (prevC >= m) {count++; break;}
            }
        }

        System.out.print(count);

    }
}