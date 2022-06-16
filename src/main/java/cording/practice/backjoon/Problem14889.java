package cording.practice.backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem14889 {
    static int n, answer;
    static int[][] board;
    static int[] ch;

    public static void DFS(int L, int v) {
        if (L == n / 2) {
            ArrayList<Integer> startArr = new ArrayList<>();
            ArrayList<Integer> linkArr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    startArr.add(i);
                } else {
                    linkArr.add(i);
                }
            }
            int start = 0;
            int link = 0;
            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    start += board[startArr.get(i)][startArr.get(j)] + board[startArr.get(j)][startArr.get(i)];
                    link += board[linkArr.get(i)][linkArr.get(j)] + board[linkArr.get(j)][linkArr.get(i)];
                }
            }
            answer = Math.min(answer, Math.abs(start - link));
            return;
        } else {
            for (int i = v; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        answer = Integer.MAX_VALUE;
        DFS(0, 0);
        System.out.println(answer);
    }
}
