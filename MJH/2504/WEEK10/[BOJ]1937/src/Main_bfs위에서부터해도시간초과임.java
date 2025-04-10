import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bfs위에서부터해도시간초과임 {
	static int N;
	static int[][] matrix;
	static int[][] move;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		move = new int[N][N];

		StringTokenizer st;

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				int height = Integer.parseInt(st.nextToken());
				matrix[row][col] = height;
			}
		} // 입력 종료

		// 제일 꼭대기만 찾기
		List<Loc> top = new ArrayList<>();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				boolean isTop = true;
				for (int d = 0; d < 4; d++) {
					int nr = row + dr[d];
					int nc = col + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if (matrix[nr][nc] > matrix[row][col]) {
						isTop = false;
						break;
					}
				}
				if (isTop) {
					top.add(new Loc(row, col, 1));
					move[row][col] = 1;
				}
			}
		}
		// System.out.println(top);
		for (Loc loc : top) {
			// System.out.println("시작");
			bfs(loc);
		}
		int max = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// System.out.print(move[row][col]+"\t");
				max = Math.max(max, move[row][col]);
			}
			// System.out.println();
		}
		System.out.println(max);

	} // main

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Loc {
		int row, col, dist;

		public Loc(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Loc [row=" + row + ", col=" + col + ", 높이=" + matrix[row][col] + "]";
		}

	}

	static void bfs(Loc top) {
		Queue<Loc> q = new LinkedList<>();
		visited = new boolean[N][N];
		q.add(top);
		visited[top.row][top.col] = true;

		while (!q.isEmpty()) {
			Loc curr = q.poll();
			// System.out.println(curr.row + " " + curr.col + " " +
			// matrix[curr.row][curr.col]);
			for (int d = 0; d < 4; d++) {
				int nr = curr.row + dr[d];
				int nc = curr.col + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
//				if (visited[nr][nc])
//					continue;
				if (matrix[curr.row][curr.col] <= matrix[nr][nc])
					continue;
				int nextdist = curr.dist + 1;
				if (move[nr][nc] >= nextdist)
					continue;
				move[nr][nc] = nextdist;
				q.add(new Loc(nr, nc, nextdist));
				visited[nr][nc] = true;
			}

		}

	}
}
