package Week_11;

import java.util.Scanner;

public class boj1303_전쟁전투 {
	
	static char[][] map;
	static int N, M, cnt_W, cnt_B, ans_W, ans_B;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//가로
		M = sc.nextInt();//세로
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans_W = 0;
		ans_B = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt_W = 1;
					cnt_B = 1;
					dfs(i, j);
					
					if(map[i][j] == 'W') {
						ans_W += (cnt_W)*(cnt_W);
					}else {
						ans_B += (cnt_B)*(cnt_B);
					}
					
				}
			}
			
		}
		
		System.out.println(ans_W +" "+ans_B);
		
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		char army = map[x][y];
		
		for(int i=0; i<4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(nr>=M || nr<0 || nc>=N || nc<0 || visited[nr][nc]) continue;
			
			if(map[nr][nc] == army) {
				visited[nr][nc] = true;
				if(army == 'W') {
					cnt_W++;
				}else {
					cnt_B++;
				}
				dfs(nr, nc);
			}
		}
		return;
	}
}
