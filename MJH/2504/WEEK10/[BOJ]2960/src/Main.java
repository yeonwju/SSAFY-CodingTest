import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int cnt = 0;

		visited = new boolean[N + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			if (visited[i])
				continue;
			cnt++;
			if (cnt == K) {
				System.out.println(i);
				return;
			}
			int k = 2;
			while (true) {
				int j = i * k;
				if (j > N)
					break;
				k++;
				if(visited[j])
					continue;
				visited[j] = true;
				cnt++;
				if (cnt == K) {
					System.out.println(j);
					return;
				}
			}
		}
		System.out.println(sb);
	}
}
