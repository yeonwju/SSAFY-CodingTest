import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int ans = 0;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++)
				matrix[r][c] = Integer.parseInt(st.nextToken());
		}
		br.close();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				dfs(r, c, 1, matrix[r][c]);
				shape(r, c);
			}
		}
		System.out.println(ans);
	}

	static void dfs(int r, int c, int size, int sum) {
		visited[r][c] = true;
		if (size == 4) {
			ans = Math.max(ans, sum);
			// 이거 안해서 틀렸다
			visited[r][c] = false;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (visited[nr][nc])
				continue;
			dfs(nr, nc, size + 1, sum + matrix[nr][nc]);
		}
		visited[r][c] = false;
	}

	static void shape(int r, int c) {
		// ㅗ
		if (r >= 0 && r + 1 < N && c - 1 >= 0 && c + 1 < M) {
			int sum = matrix[r][c] + matrix[r + 1][c] + matrix[r][c - 1] + matrix[r][c + 1];
			ans = Math.max(ans, sum);
		}
		// ㅜ
		if (r - 1 >= 0 && r < N && c - 1 >= 0 && c + 1 < M) {
			int sum = matrix[r][c] + matrix[r - 1][c] + matrix[r][c - 1] + matrix[r][c + 1];
			ans = Math.max(ans, sum);
		}
		// ㅏ
		if (r - 1 >= 0 && r + 1 < N && c + 1 < M) {
			int sum = matrix[r][c] + matrix[r - 1][c] + matrix[r + 1][c] + matrix[r][c + 1];
			ans = Math.max(ans, sum);
		}
		// ㅓ
		if (r - 1 >= 0 && r + 1 < N && c - 1 >= 0) {
			int sum = matrix[r][c] + matrix[r - 1][c] + matrix[r + 1][c] + matrix[r][c - 1];
			ans = Math.max(ans, sum);
		}
	}

//	....O....
//	...OOO...
//	..OOOOO..
//	.OOOOOOO.
//	..OOOOO..
//	...OOO...
//	....O....

}
