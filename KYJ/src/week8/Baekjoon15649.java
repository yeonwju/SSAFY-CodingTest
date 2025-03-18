package week8;

import java.util.Scanner;

public class Baekjoon15649 {
	
	static int n; 
	static int m;
	static boolean[] visit;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 1~n
		m = sc.nextInt(); // 길이 m 
		visit = new boolean[n + 1]; //0번 인덱스 사용 x
		arr = new int[m]; // 길이 m 배열
		dfs(0);

	}

	// 백트래킹
	static void dfs(int depth) {

		if (depth == m) { //길이가 m이 되면 출력
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visit[i] == false) { //해당 숫자에 방문하지 않았으면
				visit[i] = true; // 방문 처리 후 
				arr[depth] = i; // 배열에 해당 숫자 담기
				dfs(depth + 1); // 다음 숫자 담으러 가기
				visit[i] = false; // 백
			}
		}
	}
	
}
