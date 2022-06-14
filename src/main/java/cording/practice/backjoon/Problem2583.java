package cording.practice.backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2583 {
    static int m, n, k;
    static int answer;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> arr = new ArrayList<>();
    static int max;

    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                max++;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[m][n];
        for (int i = 0; i < k; i++) {
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            for (int j = m - x2; j < m - x1; j++) {
                for (int h = y1; h < y2; h++) {
                    board[j][h] = 1;
                }
            }
        }
        answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    answer++;
                    max = 1;
                    DFS(i, j);
                    arr.add(max);
                }
            }
        }
        System.out.println(answer);
        Collections.sort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
