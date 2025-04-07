import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static int danji = 0;
	static int[] danjis;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		visited = new boolean[N][N];

		int maxdanji = (int) Math.pow((N + 1) / 2, 2);
		danjis = new int[2*maxdanji+2];

		String line;
		for (int row = 0; row < N; row++) {
			line = br.readLine();
			for (int col = 0; col < N; col++) {
				matrix[row][col] = line.charAt(col) - '0';
			}
		}
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!visited[row][col] && matrix[row][col] != 0) {
					danji++;
					count(row, col);
				}
			}
		}
		PriorityQueue<Integer> pq  = new PriorityQueue<>();
		for(int i = 1 ; i <= danji ; i++){
			pq.add(danjis[i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(danji).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	private static void count(int row, int col) {
		visited[row][col] = true;
		if (matrix[row][col] != 0) {
			danjis[danji]++; // 카운팅 정렬썼다!
			for (int d = 0; d < 4; d++) {
				int nrow = row + dr[d];
				int ncol = col + dc[d];
				if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= N)
					continue;
				if (visited[nrow][ncol])
					continue;
				count(nrow, ncol);
			}
		}
	}

}
