import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static List<Loc> next;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 상하좌우에 1칸씩 빈 공간으로 하기
		matrix = new int[N + 2][M + 2];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;

		while (true) {
			visited = new boolean[N + 2][M + 2];
			dfs(0, 0); // (0,0)은 항상 외부 공기

			// 녹을 치즈 찾기
			next = new LinkedList<>();
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (matrix[r][c] == 1 && isMelt(r, c)) {
						next.add(new Loc(r, c));
					}
				}
			}

			if (next.isEmpty()) {
				System.out.println(time);
				break;
			}

			// 치즈 녹이기
			for (Loc loc : next) {
				matrix[loc.r][loc.c] = 0;
			}

			time++;
		}
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (inRange(nr, nc) && !visited[nr][nc] && matrix[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}
	}

	static boolean isMelt(int r, int c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (matrix[nr][nc] == 0 && visited[nr][nc]) {
				count++;
			}
		}
		return count >= 2;
	}

	static boolean inRange(int r, int c) {
		return r >= 0 && r < N + 2 && c >= 0 && c < M + 2;
	}

	static class Loc {
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
