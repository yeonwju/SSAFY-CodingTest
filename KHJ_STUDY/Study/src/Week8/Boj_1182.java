package Week8;

import java.util.Scanner;

public class Boj_1182 {
	static int[] arr;
	static boolean[] bol;
	static int N, M;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		bol = new boolean[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		powerset(0);
		if(M == 0) {
			cnt--;
		}
		System.out.println(cnt);
	}
	static void powerset(int index) {
		// 종료부분
		if(index == N) {
			int sum = 0;
			for(int i = 0; i< N; i++) {
				if(bol[i]) {
					sum += arr[i];
				}
			}
			if(sum == M) {
				cnt++;
			}
			return;
		}
		// 재귀부분
		bol[index] = true;
		powerset(index + 1);
		bol[index] = false;
		powerset(index + 1);
	}
}
