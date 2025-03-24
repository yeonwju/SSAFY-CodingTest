import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		arr = new int[N];
		sb = new StringBuilder();
		order(0, 0);
		System.out.println(sb);
	}

	public static void order(int idx, int size) {
		if (idx > N) {
			return;
		}
		if (size == N) {
			sout();
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[idx] = i;
				order(idx + 1, size + 1);
				visited[i] = false;
			}
		}
	}
	static void sout() {
		if(sb.length() != 0) {
			sb.append("\n");
		}
		for(int i = 0 ; i < N - 1 ; i ++) {
			sb.append(arr[i]).append(" ");
		}
		sb.append(arr[N-1]);
	}
}