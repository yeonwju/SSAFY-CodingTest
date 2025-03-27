import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] S;
	static int[] choosen = new int[6];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringTokenizer st;
		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input);

			if (st.hasMoreTokens())
				k = Integer.parseInt(st.nextToken());

			S = new int[k];

			int idx = 0;
			while (st.hasMoreTokens())
				S[idx++] = Integer.parseInt(st.nextToken());
			// 입력 종료

			choose(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void choose(int idx, int sidx) {
		if (idx == 6) {
			for (int i = 0; i < 5; i++) {
				sb.append(choosen[i]).append(" ");
			}
			sb.append(choosen[5]).append("\n");
			return;
		}
		if (idx >= k)
			return;
		for (int i = sidx; i < k; i++) {
			if(k + idx - i < 6)
				break;
			choosen[idx] = S[i];
			choose(idx + 1, i + 1);
		}

	}
}