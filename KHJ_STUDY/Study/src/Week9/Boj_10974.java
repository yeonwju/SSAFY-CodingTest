package Week9;

import java.util.Scanner;

public class Boj_10974 {
	static int N; // 입력 받을 숫자
	static boolean[] vis; // 확인했는지 배열
	static int[] arr; // 값을 담을 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		vis = new boolean[N];
		arr = new int[N];
		perm(0);
	}
	static void perm(int idx) {
		if(N == idx) {
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(vis[i]) { // 방문했으면 건너뛰기
				continue;
			}
			arr[idx] = i+1; // 배열에 i + 1 값 넣기
			vis[i] = true; // 방문 처리
			perm(idx + 1); 
			vis[i] = false; // 방문 안한거로 변경
		}
	}
}
