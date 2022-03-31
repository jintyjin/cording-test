package cording.practice.section2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5. 소수(에라토스테네스 체)
 *
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 * 예시 입력 1
 * 20
 *
 * 예시 출력 1
 * 8
 */

public class Second5 {
    public static int solution(int n) {
        int answer = 0;

        int[] arr = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if (arr[i] == 0) {
                answer++;
            }
            for (int j = i; j < n + 1; j += i) {
                arr[j] = 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
