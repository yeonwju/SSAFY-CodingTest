import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

	static int N;
	static boolean[] col;
	static boolean[] rightDown;
	// rightDown[r - c + N - 1]
	// ↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘↘
	// ↘ N-1 ... 3 2 1 0
	// ↘ N
	// ↘ N+1
	// ↘ N+2
	// ↘ N+3
	// ↘ ...
	// ↘ 2N-2
	static boolean[] rightUp;
	// rightUp[r + c]
	// ↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗↗
	// ↗ 0 1 2 3 4 5 N-1
	// ↗ . . . . . . N-2
	// ↗ . . . . . . N-3
	// ↗ . . . . . . N-4
	// ↗ . . . . . . ...
	// ↗ . . . . . . 2N-2
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
		col = new boolean[N];
		rightDown = new boolean[2 * N - 1];
		rightUp = new boolean[2 * N - 1];
		dfs(0);
		System.out.println(cnt);
	}

	static void dfs(int row) {
		// row 당 퀸이 무조건 한 개 있다.
		if (row == N) {
			cnt++;
			return;
		}
		// 어떤 col에 넣을까
		// col도 퀸이 무조건 한 개 있다.
		for (int c = 0; c < N; c++) {
			// 이미 넣었던 곳, 못 넣는 곳이면 넣지마
			// System.out.println("r : "+ row + " c : "+c );
			if (col[c] || rightDown[row - c + N - 1] || rightUp[row + c])
				continue;

			// 선택할래
			col[c] = true;
			rightDown[row - c + N - 1] = true;
			rightUp[row + c] = true;

			dfs(row + 1);

			// 선택 안할래
			col[c] = false;
			rightDown[row - c + N - 1] = false;
			rightUp[row + c] = false;

		}

	}
}
