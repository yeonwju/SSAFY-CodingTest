package Week9;

import java.util.Scanner;

public class Boj_2003 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0; // 개수 확인
		for(int i = 0; i < N; i++) {
			int sum = 0; // 누적 값
			for(int j = i; j < N; j++) {
				sum += arr[j]; // sum에 값을 더해준다.
				if(sum == num) { // 같아지면 카운트를 늘리고 멈춘다.
					cnt++;
					break;
				}
				if(sum > num) { // 목표했던 값을 초과하면 중지
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}

