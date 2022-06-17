package cording.practice.backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Camera {

    int start;
    String answer;

    public Camera(int start, String answer) {
        this.start = start;
        this.answer = answer;
    }
}


public class Problem9019 {
    static char[] arr = {'D', 'S', 'L', 'R'};
    static int[] ch;

    public static void BFS(int s, int e) {
        ch = new int[10000];
        Queue<Camera> Q = new LinkedList<>();
        ch[s] = 1;
        Q.add(new Camera(s, ""));
        while (!Q.isEmpty()) {
            Camera tmp = Q.poll();
            if (tmp.start == e) {
                System.out.println(tmp.answer);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int start = tmp.start;

                if (arr[i] == 'D') {
                    start = start * 2;
                    if (start > 9999) {
                        start = start % 10000;
                    }
                }

                if (arr[i] == 'S') {
                    start = start == 0 ? 9999 : start - 1;
                }

                if (arr[i] == 'L') {
                    start = start % 1000 * 10 + start / 1000;
                }

                if (arr[i] == 'R') {
                    start = start % 10 * 1000 + start / 10;
                }

                if (ch[start] == 0) {
                    ch[start] = 1;
                    Q.offer(new Camera(start, tmp.answer + arr[i]));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            BFS(start, end);
        }
    }
}
