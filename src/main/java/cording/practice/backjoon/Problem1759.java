package cording.practice.backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem1759 {
    static int l, c;
    static ArrayList<Character> arr;
    static int[] ch;
    static char[] dy = {'a', 'e', 'i', 'o', 'u'};

    static void DFS(int start, int L) {
        if (L == l) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            int m = 0;
            for (int i = 0; i < c; i++) {
                if (ch[i] == 1) {
                    if (isM(arr.get(i))) {
                        m++;
                    } else {
                        j++;
                    }
                    sb.append(arr.get(i));
                }
            }
            if (m >= 1 && j >= 2) {
                System.out.println(sb);
            }
        } else {
            for (int i = start; i < c; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i + 1, L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    private static boolean isM(Character ch) {
        for (int i = 0; i < dy.length; i++) {
            if (ch == dy[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        arr = new ArrayList<>();
        ch = new int[c];
        for (int i = 0; i < c; i++) {
            arr.add(sc.next().charAt(0));
        }
        Collections.sort(arr);
        DFS(0, 0);
    }
}
