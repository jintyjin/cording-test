package cording.practice.backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2667 {
    static int n, cnt;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> arr;

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                cnt++;
                DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }
        int answer = 0;
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    cnt = 1;
                    DFS(i, j);
                    arr.add(cnt);
                }
            }
        }
        System.out.println(answer);
        Collections.sort(arr);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
