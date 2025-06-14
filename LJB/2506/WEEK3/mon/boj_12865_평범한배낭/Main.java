package boj_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 무게, 가치
		int[][] things = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				if(j < things[i][0]) {
					dp[i][j] = dp[i-1][j];
				} else {
					if(dp[i-1][j] > (things[i][1] + dp[i-1][j-things[i][0]])) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = things[i][1] + dp[i-1][j-things[i][0]];
					}
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
