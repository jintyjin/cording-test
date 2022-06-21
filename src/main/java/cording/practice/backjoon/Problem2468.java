package cording.practice.backjoon;

import java.util.Scanner;

public class Problem2468 {
    static int n, answer;
    static int[][] board;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, int l) {
        ch[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !ch[nx][ny] && board[nx][ny] > l) {
                DFS(nx, ny, l);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (max < board[i][j]) {
                    max = board[i][j];
                }
            }
        }
        answer = 0;
        for (int l = 1; l <= max; l++) {
            ch = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > l && !ch[i][j]) {
                        cnt++;
                        DFS(i, j, l);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
