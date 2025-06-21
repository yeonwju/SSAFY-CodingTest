package boj_18111_마인크래프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M, B;
		final int MAX_HEIGHT = 256;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[] heightMemo = new int[MAX_HEIGHT+1];
		
		int totalBlock = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				heightMemo[map[i][j]]++;
				totalBlock += map[i][j];
			}
		}
		
		int maxH = (totalBlock + B) / (N * M);
		int tmpT;
		int minT = Integer.MAX_VALUE;
		int heightAtMinT = -1;
		for(int i=0; i<=maxH; i++) {
			tmpT = 0;
			for(int j=0; j<=MAX_HEIGHT; j++) {
				if(heightMemo[j] <= 0) {
					continue;
				}
				if(i > j) {
					tmpT += (heightMemo[j]*(i-j));
				} else if( i < j ) {
					tmpT += (heightMemo[j]*2*(j-i));
				}
			}
			if(minT >= tmpT) {
				minT = tmpT; 
				heightAtMinT = i;
			}
		}
		System.out.println(minT + " " + heightAtMinT);
	}
}
