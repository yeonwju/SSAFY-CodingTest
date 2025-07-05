import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	static int N;
	static boolean[][][] matrix;
	static int[] dr = { 1, -1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 0, -1, 1, -1, 1 };
	static int ans = 0;

	static class Loc {
		int r, c, cnt;

		public Loc(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
		matrix = new boolean[N][N][N];
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int cnt) {
		Queue<Loc> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean able = true;
				for (int k = 0; k < N; k++) {
					if (matrix[i][j][k])
						able = false;
				}
				if (able)
					list.add(new Loc(i, j, cnt));
			}
		}
		while(!list.isEmpty()) {
			Loc curr = list.poll();
			if (curr.cnt == N - 1) {
				ans++;
			}
			matrix[curr.r][curr.c][cnt] = true;
			
			for (int d = 0; d < 8; d++) {
				int l = 1;
				int nr = curr.r + dr[d] * l;
				int nc = curr.c + dc[d] * l;
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					matrix[nr][nc][cnt] = true;
					l++;
					nr = curr.r + dr[d] * l;
					nc = curr.c + dc[d] * l;
				}
			}
			// 그 다음 퀸을 넣을 자리
			dfs(curr.cnt + 1);
			// 이곳에 퀸 안 두겠다.
			matrix[curr.r][curr.c][cnt] = false;
			// 그럼 넣지 않게 처리하자
			for (int d = 0; d < 8; d++) {
				int l = 1;
				int nr = curr.r + dr[d] * l;
				int nc = curr.c + dc[d] * l;
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					matrix[nr][nc][cnt] = false;
					l++;
					nr = curr.r + dr[d] * l;
					nc = curr.c + dc[d] * l;
				}
			}
		}
	}
}
