import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물건 수
		int K = Integer.parseInt(st.nextToken()); // 한계 무게

		int[] weight = new int[N + 1];
		int[] cost = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken()); // 무게
			cost[i] = Integer.parseInt(st.nextToken()); // 가치
		}
		int[][] dp = new int[N + 1][K + 1];
		// 배낭 문제 : i 번째 아이템까지 생각했을 때 w 무게에서 최대 가치
		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= K; w++) {
				if (weight[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + cost[i]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
