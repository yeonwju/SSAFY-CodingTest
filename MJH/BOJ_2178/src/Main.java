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
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		matrix = new int[N][M];
		visited = new boolean[N][M];
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M; i ++) {
				matrix[row][i] = Integer.parseInt(st.nextToken());
			}
		}
		// bfs
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0, 0));
		visited[0][0] = true;
		int move = 0;
		boolean flag = false;
		while (!q.isEmpty()) {
			Loc curr = q.poll();
			for (int dir = 0; dir < 4; dir++) {
                int nx = curr.x + dx[dir];
                int ny = curr.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (matrix[nx][ny] == 0 || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                q.add(new Loc(nx, ny));
                if(nx == N -1 && ny == M -1) {
                	flag = true;
                	move++;
                	break;
                }
			}
			move++;
		}
		// 이 문제에서는 못 도착하는 경우가 없게 내나보다
		if(flag) {
			System.out.println(move);
		}
	}
}
