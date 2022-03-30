package cording.practice.section1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10. 가장 짧은 문자거리
 *
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 예시 입력 1
 * teachermode e
 *
 * 예시 출력 1
 * 1 0 1 2 1 0 1 2 2 1 0
 */

public class First10 {
    public static int[] solution(String str, char ch) {
        int[] answer = new int[str.length()];

        int n = 1000;
        for (int i = 0; i < answer.length; i++) {
            if (str.charAt(i) == ch) {
                n = 0;
            } else {
                n++;
            }
            answer[i] = n;
        }

        n = 1000;
        for (int i = answer.length - 1; i >= 0; i--) {
            if (str.charAt(i) == ch) {
                n = 0;
            } else {
                n++;
                answer[i] = Math.min(answer[i], n);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        for (int x : solution(str, ch)) {
            System.out.print(x + " ");
        }
    }
}
