import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bfs밑에서부터올라가서시간초과된듯 {
	static int N;
	static int[][] matrix;
	static int[][] move;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		move = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				int height = Integer.parseInt(st.nextToken());
				matrix[row][col] = height;
				pq.add(new Loc(row, col, height));
			}
		} // 입력 종료
		while (!pq.isEmpty()) {
			Loc curr = pq.poll();
			int row = curr.row;
			int col = curr.col;
			// System.out.println(row+" "+col+" "+curr.height);
			if (visited[row][col])
				continue;
			bfs(row, col);
		}
		int max = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// System.out.print(move[row][col]+"\t");
				max = Math.max(max, move[row][col]);
			} // System.out.println();
		}
		System.out.println(max);
	} // main

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int row, int col) {
		Queue<Move> q = new LinkedList<>();
		q.add(new Move(row, col, 1));
		visited[row][col] = true;
		move[row][col] = 1;
		while (!q.isEmpty()) {
			Move curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.row + dr[d];
				int nc = curr.col + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)// 범위
					continue;
//				if (visited[nr][nc])
//					continue;
				if (matrix[curr.row][curr.col] >= matrix[nr][nc]) // 높이
					continue;
				if (move[nr][nc] > move[curr.row][curr.col]) // 더 긴 길
					continue;
				q.add(new Move(nr, nc, curr.dist + 1));
				visited[nr][nc] = true;
				move[nr][nc] = move[curr.row][curr.col] + 1;
			}
		}
	}

	// bfs에서 사용할 클래스
	static class Move {
		int row, col, dist;

		public Move(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

	}

	// 낮은 위치 부터 찾기
	static class Loc implements Comparable<Loc> {
		int row, col, height;

		@Override
		public int compareTo(Loc o) {
			return Integer.compare(this.height, o.height); // 오름차순
		}

		public Loc(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}

}
