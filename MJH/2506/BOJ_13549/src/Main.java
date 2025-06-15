import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// stackOverFlow
public class Main {

	static int N, K;
	static int[] time = new int[100001];
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();
		Arrays.fill(time, INF);
		time[N] = 0;
		dfs(N);
		System.out.println(time[K]);
	}

	static void dfs(int x) {

		if(x > 2 * K) return;
		
		if (x >= 0 && x * 2 <= 100000 && time[x] < time[2*x]) {
			time[2*x] = time[x];
			dfs(2*x);
		}
		if (x < 100000 && time[x] < time[x + 1]) {
			time[x + 1] = time[x] + 1;
			dfs(x + 1);
		}
		if (x > 0 && time[x] < time[x - 1]) {
			time[x - 1] = time[x] + 1;
			dfs(x - 1);
		}
	}
}
