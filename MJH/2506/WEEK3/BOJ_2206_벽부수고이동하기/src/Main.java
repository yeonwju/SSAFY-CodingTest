import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] matrix;
	static boolean[][][] visited;
	// visited[][][0] : 한번도 안 깼을 때
	// visited[][][1] : 한번 깼을 때
	// visited가 true라면 거기로 갈 때 더 가까운 길이 있었던 거임

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new char[N][M];
		visited = new boolean[N][M][2];
		String line;
		for (int row = 0; row < N; row++) {
			line = br.readLine();
			matrix[row] = line.toCharArray();
		}
		br.close();

		bfs();

	}

	static public class Node {
		int r, c, move, wall;

		public Node(int r, int c, int move, int wall) {
			super();
			this.r = r;
			this.c = c;
			this.move = move;
			this.wall = wall;
		}
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.add(new Node(0, 0, 1, 0)); // 0,0에서 시작할 때 이동이 1로 시작함

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int m = curr.move;
			int w = curr.wall;
			
			if (r == N - 1 && c == M - 1) { // matrix[N-1][M-1] 은 항상 0
				System.out.println(m);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 범위 이상
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				// 올바른 길
				if (matrix[nr][nc] == '0' && !visited[nr][nc][w]) {
					visited[nr][nc][w] = true;
					q.add(new Node(nr, nc, m + 1, w));
				}
				// 한번 부수기
				else if (w == 0 && matrix[nr][nc] == '1' && !visited[nr][nc][1]) {
					visited[nr][nc][1] = true;
					q.add(new Node(nr, nc, m + 1, 1));
				}
			}
		}
		// 도착 못함
		System.out.println(-1);
	}
}
