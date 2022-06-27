package cording.practice.backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point13459 {

    int x;
    int y;
    int arrow;

    public Point13459(int x, int y, int arrow) {
        this.x = x;
        this.y = y;
        this.arrow = arrow;
    }
}
public class Problem13459 {
    static int n, m, answer;
    static char[][] board;
    static int[][] ch;
    static Point13459 red, blue, end;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dArrow = {1, 2, 3, 4};

    public static void BFS() {
        Queue<Point13459> q = new LinkedList<>();
        q.offer(red);
        ch[red.x][red.y] = 1;
        while (!q.isEmpty()) {
            Point13459 tmp = q.poll();
            if (blue.x == end.x && blue.y == end.y) {
                System.out.println(0);
                break;
            }
            if (ch[tmp.x][tmp.y] - 1 == 11) {
                System.out.println(0);
                break;
            }
            if (tmp.x == end.x && tmp.y == end.y) {
                while (blue.x >= 0 && blue.y >= 0 && blue.x < n && blue.y < m) {
                    if (blue.x == end.x && blue.y == end.y) {
                        System.out.println(0);
                        return;
                    }
                    for (int i = 0; i < 4; i++) {
                        int arrow = dArrow[i];
                        if (arrow == tmp.arrow) {
                            int bx = blue.x + dx[i];
                            int by = blue.y + dy[i];
                            blue.x = bx;
                            blue.y = by;
                        }
                    }
                }
                System.out.println(1);
                return;
            } else {
                for (int i = 0; i < 4; i++) {
                    int rx = tmp.x + dx[i];
                    int ry = tmp.y + dy[i];
                    int arrow = dArrow[i];
                    int bx = blue.x + dx[i];
                    int by = blue.y + dy[i];
                    if (bx < 0) {
                        bx = 0;
                    }
                    if (bx >= n) {
                        bx = n;
                    }
                    if (by < 0) {
                        by = 0;
                    }
                    if (by >= m) {
                        by = m;
                    }
                    if (board[bx][by] == '#') {
                        bx = blue.x;
                        by = blue.y;
                    }
                    blue.x = bx;
                    blue.y = by;
                    blue.arrow = arrow;
                    if (isPossibility(rx, ry)) {
                        if (arrow == tmp.arrow) {
                            ch[rx][ry] = ch[tmp.x][tmp.y];
                        } else {
                            ch[rx][ry] = ch[tmp.x][tmp.y] + 1;
                        }
                        q.offer(new Point13459(rx, ry, arrow));
                    }
                }
            }
        }
    }

    public static boolean isPossibility(int rx, int ry) {
        if (rx < 0 || ry < 0) {
            return false;
        }
        if (rx >= n || ry >= m) {
            return false;
        }
        if (ch[rx][ry] != 0) {
            return false;
        }
        if (rx == blue.x && ry == blue.y) {
            return false;
        }
        if (board[rx][ry] == '#') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j);
                if (board[i][j] == 'R') {
                    red = new Point13459(i, j, 0);
                } else if (board[i][j] == 'B') {
                    blue = new Point13459(i, j, 0);
                } else if (board[i][j] == 'O') {
                    end = new Point13459(i, j, 0);
                }
            }
        }
        BFS();
    }
}
