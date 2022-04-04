package cording.practice.section3;

import java.util.Scanner;

/**
 * 1. 두 배열 합치기
 *
 * 설명
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 예시 입력 1
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * 예시 출력 1
 * 1 2 3 3 5 6 7 9
 *
 */
public class Third1 {
    public static String solution(int n, int[] arrN, int m, int[] arrM) {
        String answer = "";

        int nt = 0;
        int mt = 0;
        while (nt < n && mt < m) {
            if (arrN[nt] <= arrM[mt]) {
                answer += arrN[nt++] + " ";
            } else {
                answer += arrM[mt++] + " ";
            }
        }

        for (int i = nt; i < n; i++) {
            answer += arrN[i] + " ";
        }

        for (int j = mt; j < m; j++) {
            answer += arrM[j] + " ";
        }

        return answer;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
        }

        System.out.println(solution(n, arrN, m, arrM));
    }
}
