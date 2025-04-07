package Week004;

import java.util.Scanner;

public class SWEA_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 최종 누적 값 변수
			int lastCnt = 0;
			// 한줄씩 확인한다.
			// 가로
			for(int i = 0; i < N; i++) {
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					// 1이 흰색이니까 흰색을 만날때마다 카운트를 해준다.
					if(arr[i][j] == 1) {
						cnt++;
					// 0을 만나면 초기화를 한다.
					}else {
						// 그때 cnt 가 K의 값과 같다면 lastCnt 값을 증가
						if(cnt == K) {
							lastCnt ++;
						}
						cnt = 0;
					}
					// j가 마지막일때 K와 cnt의 값이 같다면 lastCnt를 추가
					if(j == N-1 && cnt == K) {
						lastCnt++;
					}
				}
			}
			
			// 세로
			// 위와 동일
			for(int i = 0; i < N; i++) {
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					if(arr[j][i] == 1) {
						cnt++;
					}else {
						if(cnt == K) {
							lastCnt ++;
						}
						cnt = 0;
					}
					if(j == N-1 && cnt == K) {
						lastCnt++;
					}
				}
			}
			System.out.println("#" + tc + " " + lastCnt);
		}
	}
}
