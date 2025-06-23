package boj_2096_내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		final int L = 0;
		final int C = 1;
		final int R = 2;
		final int MIN = 0;
		final int MAX = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] nums = new int[N+1][3];
		StringTokenizer st =  null;
		for(int i=1; i<=N; i++) {
			st =  new StringTokenizer(br.readLine());
			nums[i][L] = Integer.parseInt(st.nextToken());
			nums[i][C] = Integer.parseInt(st.nextToken());
			nums[i][R] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] minMax = new int[N+1][3][2];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				if(j == L) {
					minMax[i][j][MIN] = Math.min(minMax[i-1][L][MIN], minMax[i-1][C][MIN]) + nums[i][L];
					minMax[i][j][MAX] = Math.max(minMax[i-1][L][MAX], minMax[i-1][C][MAX]) + nums[i][L];	
					continue;
				}
				if(j == R) {
					minMax[i][j][MIN] = Math.min(minMax[i-1][C][MIN], minMax[i-1][R][MIN]) + nums[i][R];
					minMax[i][j][MAX] = Math.max(minMax[i-1][C][MAX], minMax[i-1][R][MAX]) + nums[i][R];	
					continue;
				}
				if(j == C) {
					minMax[i][j][MIN] = Math.min(Math.min(minMax[i-1][L][MIN], minMax[i-1][C][MIN]), minMax[i-1][R][MIN]) + nums[i][C];
					minMax[i][j][MAX] = Math.max(Math.max(minMax[i-1][L][MAX], minMax[i-1][C][MAX]), minMax[i-1][R][MAX]) + nums[i][C];	
					continue;
				}
			}
		}
		System.out.println(Math.max(minMax[N][L][MAX], Math.max(minMax[N][C][MAX], minMax[N][R][MAX])) + " " + Math.min(minMax[N][L][MIN], Math.min(minMax[N][C][MIN], minMax[N][R][MIN])));
	}
}
