import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] matrix;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static class Loc {
		int x;
		int y;

		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		matrix = new int[N][M];
		visited = new boolean[N][M];
		for (int row = 0; row < N; row++) {
			String l = br.readLine();
			for (int i = 0; i < M; i++) {
				matrix[row][i] = l.charAt(i) - '0';
			}
		}
		// bfs
		int move = 1;
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
		    int size = q.size(); // 이번 움직임 안에 갈 수 있는 경로
		    for (int i = 0; i < size; i++) {
		        Loc curr = q.poll();
		        if (curr.x == N - 1 && curr.y == M - 1) {
		            System.out.println(move);
		            return;
		        }

		        for (int dir = 0; dir < 4; dir++) {
		            int nx = curr.x + dx[dir];
		            int ny = curr.y + dy[dir];

		            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
		                continue;
		            if (matrix[nx][ny] == 0 || visited[nx][ny])
		                continue;

		            visited[nx][ny] = true;
		            q.add(new Loc(nx, ny));
		        }
		    }
		    move++;
		}
	}
}
