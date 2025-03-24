import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] usednumbers;
	static int[] result;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		br.close();
		usednumbers = new boolean[N+1];
		result = new int[M];

		calc(0);

		System.out.println(sb);
	}

	static void calc(int idx) {
		if(idx == M) {
			sout();
			return;
		}
		if(idx > N) {
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!usednumbers[i]) {
				result[idx] = i;
				usednumbers[i] = true;
				calc(idx + 1);
				usednumbers[i] = false;
			}
		}
	}

	static void sout() {
		if (sb.length() != 0)
			sb.append("\n");
		for (int i = 0; i < M; i++) {
			sb.append(result[i]).append(" ");
		}
	}
}
