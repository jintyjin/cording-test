package cording.practice.backjoon;

import java.util.*;

class Point6593 {
    int x;
    int y;
    int z;

    public Point6593(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Problem6593 {
    static int l, r, c, answer;
    static ArrayList<char[][]> arr = new ArrayList<>();
    static ArrayList<int[][]> ch = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void BFS(Point6593 point6593) {
        Queue<Point6593> q = new LinkedList<>();
        q.offer(point6593);
        ch.get(point6593.z)[point6593.x][point6593.y] = 1;
        while (!q.isEmpty()) {
            Point6593 tmp = q.poll();
            if (arr.get(tmp.z)[tmp.x][tmp.y] == 'E') {
               answer = Math.min(answer, ch.get(tmp.z)[tmp.x][tmp.y] - 1);
               return;
            } else {
                for (int i = 0; i < 6; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    int nz = tmp.z + dz[i];
                    if (isPossibility(nx, ny, nz)) {
                        ch.get(nz)[nx][ny] = ch.get(tmp.z)[tmp.x][tmp.y] + 1;
                        q.offer(new Point6593(nx, ny, nz));
                    }
                }
            }
        }
    }

    public static boolean isPossibility(int nx, int ny, int nz) {
        if (nx < 0 || ny < 0 || nz < 0) {
            return false;
        }
        if (nx >= r || ny >= c || nz >= l) {
            return false;
        }
        if (ch.get(nz)[nx][ny] != 0) {
            return false;
        }
        if (arr.get(nz)[nx][ny] == '#') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            arr = new ArrayList<>();
            ch = new ArrayList<>();
            int x = 0;
            int y = 0;
            int z = 0;
            for (int i = 0; i < l; i++) {
                char[][] board = new char[r][c];
                for (int j = 0; j < r; j++) {
                    String tmp = sc.next();
                    for (int k = 0; k < c; k++) {
                        if (tmp.charAt(k) == 'S') {
                            x = j;
                            y = k;
                            z = i;
                        }
                        board[j][k] = tmp.charAt(k);
                    }
                }
                arr.add(board);
                ch.add(new int[r][c]);
            }
            answer = Integer.MAX_VALUE;
            BFS(new Point6593(x, y, z));
            if (answer == Integer.MAX_VALUE) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s)");
            }
        }
    }
}
