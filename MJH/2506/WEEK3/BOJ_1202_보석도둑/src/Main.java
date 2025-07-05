import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물건 수
		Stuff[] stuff = new Stuff[N];
		int K = Integer.parseInt(st.nextToken()); // 가방 수
		int[] C = new int[K];
		// 물건의 정보 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i] = new Stuff();
			stuff[i].w = Integer.parseInt(st.nextToken());
			stuff[i].v = Integer.parseInt(st.nextToken());
		}
		// 가치가 높은 순
		Arrays.sort(stuff);
		// 각 가방 최대 무게
		for (int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(br.readLine()); // 최대 무게
		}
		br.close();
		// 가방 한도 낮은 순
		Arrays.sort(C);
		int ans = 0;
		boolean[] used = new boolean[K];
		int j = 0;
		for (int i = 0; i < K; i++) {
			for (; j < N; j++) {
				if (stuff[j].w > C[i] || used[j])
					continue;
				used[j] = true;
				ans += stuff[j].v;
				break;
			}
		}
		System.out.println(ans);
	}

	static class Stuff implements Comparable<Stuff> {
		int w; // weight
		int v; // value

		@Override
		public int compareTo(Stuff o) {
			if (o.w != this.w)
				return Integer.compare(o.v, this.v);
			return Integer.compare(this.w, o.w);
		}

	}
}
