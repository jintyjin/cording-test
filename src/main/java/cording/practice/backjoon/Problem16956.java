package cording.practice.backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point16956 {
    int x;
    int y;

    public Point16956(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Problem16956 {
    static char[][] board;
    static Queue<Point16956> q = new LinkedList<>();
    static boolean flag;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void BFS(int r, int c) {
        while (!q.isEmpty()) {
            Point16956 tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c){
                    if (board[nx][ny] == 'S') {
                        flag = false;
                        return;
                    } else if (board[nx][ny] == '.') {
                        board[nx][ny] = 'D';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        board = new char[r][c];
        flag = true;
        for (int i = 0; i < r; i++) {
            String tmp = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp.charAt(j);
                if (tmp.charAt(j) == 'W') {
                    q.offer(new Point16956(i, j));
                }
            }
        }
        BFS(r, c);
        if (!flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
