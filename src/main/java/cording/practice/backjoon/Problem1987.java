package cording.practice.backjoon;

import java.util.Scanner;

public class Problem1987 {
    static int n, m, answer;
    static char[][] board;
    static boolean[][] ch;
    static String str;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, String str) {
        answer = Math.max(answer, str.length());
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !ch[nx][ny]) {
                if (str.indexOf(board[nx][ny]) == -1) {
                    ch[nx][ny] = true;
                    DFS(nx, ny, str + board[nx][ny]);
                    ch[nx][ny] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        ch = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }
        answer = 1;
        str = board[0][0] + "";
        DFS(0, 0, str);
        System.out.println(answer);
    }
}
