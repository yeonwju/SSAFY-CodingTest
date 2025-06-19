import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static boolean[][] matrix;
	static int[] dr = { 1, -1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 0, -1, 1, -1, 1 };
	static int cnt = 0;

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
		matrix = new boolean[N][N];
		
		dfs(0);
		
		System.out.println(cnt);
	}

	static Queue<Loc> findAbleLoc(int cnt) {
		Queue<Loc> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!matrix[i][j])
					list.add(new Loc(i, j, cnt));
			}
		}
		return list;
	}

	static void dfs(int cnt) {
		// 가능한 위치 리스트 만들기
		Queue<Loc> list = findAbleLoc(cnt + 1);

		// 각 위치
		while (!list.isEmpty()) {
			Loc curr = list.poll();
			// 이곳에 퀸을 두겠다.
			matrix[curr.r][curr.c] = true;
			if (curr.cnt == N) {
				cnt++;
			}
			// 그렇다면 못넣게 되는 자리 처리하기
			for (int d = 0; d < 8; d++) {
				int l = 1;
				int nr = curr.r + dr[d] * l;
				int nc = curr.c + dc[d] * l;
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					matrix[nr][nc] = true;
					l++;
					nr = curr.r + dr[d] * l;
					nc = curr.c + dc[d] * l;
				}
			}
			// 그 다음 퀸을 넣을 자리
			dfs(curr.cnt + 1);
			// 이곳에 퀸 안 두겠다.
			matrix[curr.r][curr.c] = false;
			// 그럼 넣지 않게 처리하자
			// 이 곳에 오류가 있다!!! 이번이 아니고 저번에 퀸을 놔서 true가 된 부분이 false가 되어버린다.
			for (int d = 0; d < 8; d++) {
				int l = 1;
				int nr = curr.r + dr[d] * l;
				int nc = curr.c + dc[d] * l;
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					matrix[nr][nc] = false;
					l++;
					nr = curr.r + dr[d] * l;
					nc = curr.c + dc[d] * l;
				}
			}

		}

	}
}
