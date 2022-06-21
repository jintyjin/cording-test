package cording.practice.backjoon;

import java.util.Scanner;

public class Problem15684 {
    static int n, m, h, answer;
    static int[][] board;
    static boolean flag;

    public static boolean solution() {
        for (int i = 1; i <= n; i++) {
            int x = 1;
            int y = i;
            while (x <= h) {
                if (board[x][y] == 1) {
                    y++;
                } else if (board[x][y] == 2) {
                    y--;
                }
                x++;
            }
            if (y != i) {
                return false;
            }
        }

        return true;
    }

    public static void DFS(int x, int y, int count) {
        if (flag) {
            return;
        }
        if (answer == count) {
            if (solution()) {
                flag = true;
            }
            return;
        } else {
            for (int i = x; i <= h; i++) {
                for (int j = y; j < n; j++) {
                    if (board[i][j] == 0 && board[i][j + 1] == 0) {
                        board[i][j] = 1;
                        board[i][j + 1] = 2;
                        DFS(1, 1, count + 1);
                        board[i][j] = 0;
                        board[i][j + 1] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        board = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = 1;
            board[x][y + 1] = 2;
        }
        flag = false;
        for (int i = 0; i <= 3; i++) {
            answer = i;
            DFS(1, 1, 0);
            if (flag) {
                break;
            }
        }
        if (flag) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
