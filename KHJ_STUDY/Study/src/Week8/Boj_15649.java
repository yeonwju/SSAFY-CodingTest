package Week8;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15649 {
	static boolean vis[]; // 숫자가 쓰였는지 확인하는 배열
	static int arr[];
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		vis = new boolean[N];
		perm(0);
	}
	static void perm(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!vis[i]) { // 숫자를 사용하지 않았다면
				vis[i] = true; // 해당 부분을 true로 바꾸고 사용했다고 표시
				arr[idx] = i + 1; // arr에 해당 숫자 저장
				perm(idx + 1);
				vis[i] = false;
			}
		}
	}
		
}
