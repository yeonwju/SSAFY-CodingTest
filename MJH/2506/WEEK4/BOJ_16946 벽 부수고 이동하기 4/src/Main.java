import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static char[][] matrix;
	static int[][] move;
	static boolean[][] visited;
	static Queue<Loc> q;
	static int cnt;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new char[N][M];
		move = new int[N][M];
		visited = new boolean[N][M];
		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = line.charAt(j);
			}
		}
		br.close();

		// 벽 못 뚫을 때 해당 위치에서 몇 번 움직일 수 있는 지
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (matrix[r][c] == '1' || visited[r][c])
					continue;
				q = new LinkedList<>();
				cnt = 0;
				connected(r, c);
				while (!q.isEmpty()) {
					Loc loc = q.poll();
					move[loc.r][loc.c] = cnt;
				}
			}
		}

		// 답

		int[][] ans = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (matrix[r][c] == '0')
					continue;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					ans[r][c] += move[nr][nc];
				}
				ans[r][c] ++; // 자기 자신 포함
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(ans[r][c] % 10);
			}
			System.out.println();
		}

	}

	static void connected(int r, int c) {
		q.add(new Loc(r, c));
		cnt++;
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (visited[nr][nc] || matrix[nr][nc] == '1')
				continue;
			connected(nr, nc);
		}
	}

}
