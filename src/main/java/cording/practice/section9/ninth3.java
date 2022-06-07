package cording.practice.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class People implements Comparable<People> {
    int time;
    char state;

    public People(int s, char state) {
        this.time = s;
        this.state = state;
    }

    public int compareTo(People people) {
        if (this.time == people.time) {
            return this.state - people.state;
        } else {
            return this.time - people.time;
        }
    }
}
public class ninth3 {
    public static int solution(ArrayList<People> arr) {
        int cnt = 0;
        int answer = 0;
        Collections.sort(arr);
        for (People ob : arr) {
            if (ob.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<People> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            arr.add(new People(s, 's'));
            int e = sc.nextInt();
            arr.add(new People(e, 'e'));
        }
        System.out.println(solution(arr));
    }
}
