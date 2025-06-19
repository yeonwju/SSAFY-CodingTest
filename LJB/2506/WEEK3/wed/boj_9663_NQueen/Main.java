package boj_9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, result;
	static boolean[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		result = 0;
		dfs(0);
		
		System.out.println(result);
	}
	
	static void dfs(int t) {
		if(t == N) {
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(chkCol(i, t) && chkDial(i, t)) {
				map[t][i] = true;
				dfs(t+1);
				map[t][i] = false;
			}
		}
	}
	
	static boolean chkCol(int x, int y) {
		boolean flag = true;
		for(int i=0; flag && i<y; i++) {
			flag = !map[i][x];
		}
		return flag;
	}
	static boolean chkDial(int x, int y) {
		boolean flag = true;
		for(int i=1; flag && i <= y; i++) {
			if(x-i >= 0) {
				flag = !map[y-i][x-i];
			}
			if(flag && x+i < N) {
				flag = !map[y-i][x+i];
			}
		}
		return flag;
	}
}
