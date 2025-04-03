package Week010;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1012 {
	static int[][] area; // 배추 배열
	static boolean[][] vis; // 방문체크 배열
	static int M; // 가로
	static int N; // 세로
	static int[] dr = {1, 0,-1, 0}; // 델타탐색
	static int[] dc = {0, 1, 0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		for(int tc = 0; tc < T; tc++) {
			M = sc.nextInt(); // 가로 세로 입력
			N = sc.nextInt();
			int K = sc.nextInt(); // 벌레 위치의 개수
			area = new int[M][N];
			vis = new boolean[M][N];
			for(int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				area[x][y] = 1;
			}
			int cnt = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
				// 반복문을 돌면서 방문하지 않았고 해당 값이 1이면 dfs를 시작
					if(area[i][j] == 1 && !vis[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static void dfs(int row, int col) {
		vis[row][col] = true; // 해당 위치를 방문했다고 표시
		for(int i = 0; i < 4; i++) {
		  // 4방향 확인을 위한 위치 변수
			int dx = row + dr[i];
			int dy = col + dc[i];
			// 벽의 범위를 초과하는가 확인
			if(dx >= 0 && dy >= 0 && dx < M && dy < N) {
			  // 이동한 위치가 1이고 방문하지 않은경우 다시 dfs 실행
				if(area[dx][dy] == 1 && !vis[dx][dy]) {
					dfs(dx,dy);
				}
			}
		}
	}
}
