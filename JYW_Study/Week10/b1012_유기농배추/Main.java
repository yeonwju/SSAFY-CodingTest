package b1012_유기농배추;

import java.util.Scanner;

public class Main {
	
	static boolean[][] visited;
	static int cnt;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int N, M, K;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			M = sc.nextInt(); //가로길이
			N = sc.nextInt(); //세로길이
			K = sc.nextInt(); //배추가 심어져있는 위치 개수
			
			map = new int[N][M];
			
			for(int i=0; i<K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				map[b][a] = 1;
			}
			
			cnt = 0;
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}//tc for
		
	}//main
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(nr>=N || nc>=M || nr<0 || nc<0 || visited[nr][nc]) continue;	
			if(map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
		return;
	}
}


















