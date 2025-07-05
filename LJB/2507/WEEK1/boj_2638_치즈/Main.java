package boj_2638_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt;
	static int[][] now, next;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		now = new int[N][M];
		next = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				now[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		while(isFinish()) {
		}
		
		System.out.println(cnt);
		
	}
	
	static boolean isFinish() {
		chkOutside(0,0);
		boolean flag = false;
		boolean countUp = true;
		int isRemovable;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(now[i][j] == 1) {
					if(countUp) {
						cnt++;
						countUp = !countUp;
					}
					isRemovable = 0;
					for(int d=0; d<4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if(bound(nx, ny) && now[ny][nx] == 2) {
							isRemovable++;
						}
					}
					if(isRemovable < 2) {
						next[i][j] = 1;
						flag = true;
					}
				}
			}
		}
		now = next;
		next = new int[N][M];
		return flag;
	}
	static void chkOutside(int x, int y) {
		now[y][x] = 2;
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(bound(nx, ny) && now[ny][nx] == 0) {
				chkOutside(nx, ny);
			}
		}
	}
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(now[i]));
		}
		System.out.println("\n");
	}
	static boolean bound(int x, int y) {
		return x >= 0 && y >= 0 && x<M && y < N;
	}
}
