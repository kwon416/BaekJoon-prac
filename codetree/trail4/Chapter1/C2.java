package codetree.trail4.Chapter1;


import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        // Please write your code here.
        // ㄴ자 블럭을 배치하는 경우
        // 회전하면 2*2 에서 하나를 빼는 것과 같음
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < m - 1; j++) {
                int a = grid[i][j];
                int b = grid[i][j+1];
                int c = grid[i+1][j];
                int d = grid[i+1][j+1];

                int sum = Math.max(
                        Math.max(a+b+c, a+b+d),
                        Math.max(a+c+d, b+c+d)
                );

                max = Math.max(max, sum);
            }

        // 직선 3개 블록
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 행에서 찾기
                if (j >= m-2) continue;
                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //열에서 찾기
                if (i >= n-2) continue;
                int sum = grid[i][j] + grid[i+1][j] + grid[i+2][j];
                max = Math.max(max, sum);
            }
        }

        System.out.print(max);
    }
}