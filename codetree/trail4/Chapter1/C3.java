package codetree.trail4.Chapter1;


import java.util.Scanner;

public class C3 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int max = 0;

        // k는 서비스 영역 크기 (0 ~ 2n까지도 고려 가능)
        for (int k = 0; k <= 2 * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int count = countGold(grid, i, j, k);
                    int cost = k * k + (k + 1) * (k + 1);
                    if (count * m >= cost) {
                        max = Math.max(max, count);
                    }
                }
            }
        }

        System.out.println(max);
    }

    static int countGold(int[][] grid, int cx, int cy, int k) {
        int cnt = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (Math.abs(cx - x) + Math.abs(cy - y) <= k) {
                    if (grid[x][y] == 1) cnt++;
                }
            }
        }
        return cnt;
    }
}
