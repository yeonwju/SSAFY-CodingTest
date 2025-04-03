import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		if (N > 3)
			dp = new int[N + 1];
		else {
			dp = new int[4];
		}
		br.close();

		Arrays.fill(dp, N + 1);
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 1; i <= N; i++) {
			calc(i);
		}
		System.out.println(dp[N]);
	}

	static void calc(int n) {

		if (dp[n] == N + 1)
			dp[n] = dp[n - 1] + 1;

		int n3 = n * 3;
		if (n3 <= N && n3 != 3) {
			dp[n3] = dp[n3] > dp[n] + 1 ? dp[n] + 1 : dp[n3];
		}

		int n2 = n * 2;
		if (n2 <= N && n2 != 2)
			dp[n2] = dp[n2] > dp[n] + 1 ? dp[n] + 1 : dp[n2];
		int next = n + 1;
		if (next <= N && next != 2 && next != 3)
			dp[next] = dp[next] > dp[n] + 1 ? dp[n] + 1 : dp[next];
	}

}
