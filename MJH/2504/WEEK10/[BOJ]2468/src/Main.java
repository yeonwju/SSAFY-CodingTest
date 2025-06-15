import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		StringTokenizer st;
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 종료
		for (int k = 1; k <= 100; k++) {
			visited = new boolean[N][N];
			int areacnt = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (visited[row][col] || matrix[row][col] <= k)
						continue;
					dfs(row, col, k);
					areacnt++;
				}
			}
			if(areacnt == 0) // 전부다 똑같을 때
				areacnt = 1;
			result = Math.max(areacnt, result);
		}
		System.out.println(result);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int row, int col, int k) {
		visited[row][col] = true;
		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (visited[nr][nc])
				continue;
			if (matrix[nr][nc] <= k)
				continue;
			dfs(nr, nc, k);
		}
	}
}
