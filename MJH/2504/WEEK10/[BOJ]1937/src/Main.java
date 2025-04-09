import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] matrix;
	static boolean[][] visited;

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
		} // 입력 종료
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				visited = new boolean[N][N];
				bfs(row, col);
			}
		}
	} // main

	static int bfs(int row, int col) {
		int result = 0;
		Queue<GPS> q = new LinkedList<>();
		q.add(new GPS(row, col));
		
		while(!q.isEmpty()) {
			GPS curr = q.poll();
			
		}
		
		return result;
	}

	static class GPS {
		int row, col;

		public GPS(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

}
