import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] result;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		br.close();
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		

		result = new int[M];

		calc(0, 1);
		
		System.out.println(sb);
	}

	static void calc(int idx, int sidx) {
		// 탈출
		if (idx >= M) {
			sout();
			return;
		}
		if (sidx > N) {
			return;
		}
		// 재귀
		result[idx] = sidx;
		calc(idx + 1, sidx + 1);
		calc(idx, sidx + 1);
	}

	static void sout() {
		if (sb.length() != 0)
			sb.append("\n");
		for (int i = 0; i < M; i++) {
			sb.append(result[i]).append(" ");
		}
	}
}
