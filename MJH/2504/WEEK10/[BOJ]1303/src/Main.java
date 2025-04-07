import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, cnt;
	static char[][] matrix;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		matrix = new char[M][N];
		visited = new boolean[M][N];
		String line;
		for (int row = 0; row < M; row++) {
			line = br.readLine();
			for (int col = 0; col < N; col++) {
				matrix[row][col] = line.charAt(col);
			}
		} // 입력 종료
		int sumW = 0, sumB = 0;
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (!visited[row][col]) {
					cnt = 0;
					dfs(row, col);
					if(matrix[row][col] == 'W')
						sumW += cnt*cnt;
					else
						sumB += cnt*cnt;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sumW).append(" ").append(sumB);
		System.out.println(sb);
	}

	static void dfs(int row, int col) {
		visited[row][col] = true;
		cnt++;
		for (int d = 0; d < 4; d++) {
			int nrow = row + dr[d];
			int ncol = col + dc[d];
			if (nrow < 0 || nrow >= M || ncol < 0 || ncol >= N)
				continue;
			if (visited[nrow][ncol])
				continue;
			if(matrix[row][col] == matrix[nrow][ncol])
				dfs(nrow, ncol);
		}

	}
}
