package Week9;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_6603 {
	static int[] arr; // 배열
	static int[] lot; // 로또 저장 배열
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = 6; // 로또 크기는 6
		while(true) {
			N = sc.nextInt(); // 반복횟수 입력받고 0이면 중지
			if(N == 0) {
				break;
			}
			arr = new int[N]; // arr의 크기
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			lot = new int[6];
			lotto(0,0);
			System.out.println();
		}
	}
	// sidx는 뽑은 번호의 인덱스
	// idx는 고려할 번호의 인덱스
	static void lotto(int sidx, int idx) {
		if(sidx == K) {
			for(int i = 0; i < K; i++) {
				System.out.print(lot[i] + " ");
			}
			System.out.println();
			return;
		}
		if(idx == N) {
			return;
		}
		lot[sidx] = arr[idx];
		lotto(sidx + 1, idx + 1);
		lotto(sidx, idx + 1);
	}
}
