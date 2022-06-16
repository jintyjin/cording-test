package cording.practice.backjoon;

import java.util.Scanner;

public class Problem2580 {
    static int n;
    static int[][] board;

    static void DFS(int x, int y) {
        if (y == n) {
            DFS(x + 1, 0);
            return;
        }

        if (x == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[x][y] == 0) {
            for (int i = 1; i <= n; i++) {
                if (isPossibility(x, y, i)) {
                    board[x][y] = i;
                    DFS(x, y + 1);
                }
            }
            board[x][y] = 0;
            return;
        }
        DFS(x, y + 1);
    }

    public static boolean isPossibility(int x, int y, int val) {
        for (int i = 0; i < n; i++) {
            if (board[x][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][y] == val) {
                return false;
            }
        }

        int xMin = x / 3 * 3;
        int yMin = y / 3 * 3;
        for (int i = xMin; i < xMin + 3; i++) {
            for (int j = yMin; j < yMin + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = 9;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        DFS(0, 0);
    }
}

