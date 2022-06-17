package cording.practice.backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem5014 {
    static int f, g, u, d, answer;
    static int[] ch;
    static int[] dx;

    public static void BFS(int s) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        ch[s] = 1;
        while (!Q.isEmpty()) {
            int tmp = Q.poll();
            if (tmp == g) {
                System.out.println(ch[tmp] - 1);
                break;
            }
            for (int i = 0; i < 2; i++) {
                int nx = tmp + dx[i];
                if (nx <= f && nx > 0 && ch[nx] == 0) {
                    ch[nx] = ch[tmp] + 1;
                    Q.offer(nx);
                }
            }
        }
        if (ch[g] == 0) {
            System.out.println("use the stairs");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        ch = new int[f + 1];
        dx = new int[2];
        int s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        dx[0] = u;
        d = sc.nextInt();
        dx[1] = d * -1;
        answer = Integer.MAX_VALUE;
        BFS(s);
    }
}
