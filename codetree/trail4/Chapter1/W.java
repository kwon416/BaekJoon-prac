package codetree.trail4.Chapter1;

import java.util.Scanner;
public class W {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int max = 0;
        for (int i = 0; i <= n - 3; i++)
            for (int j = 0; j <= n - 3; j++) {
                int sum =
                        grid[i][j] + grid[i][j+1] + grid[i][j+2] +
                                grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] +
                                grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                if (sum > max) max = sum;
            }

        System.out.print(max);
    }
}