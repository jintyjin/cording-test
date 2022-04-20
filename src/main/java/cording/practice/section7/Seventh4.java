package cording.practice.section7;

import java.util.Scanner;

public class Seventh4 {
    static int[] fibo;
    public static int DFS(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            fibo[n] = 1;
            return 1;
        } else if (n == 2) {
            fibo[n] = 1;
            return 1;
        } else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
