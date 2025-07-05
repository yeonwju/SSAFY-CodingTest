import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int[][] matrix = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		for (int i = 0; i < 9; i++) {
			line = br.readLine();
			for (int j = 0; j < 9; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		dfs(0, 0);
	}

	static List<Integer> ableNumbers(int r, int c) {
		List<Integer> list = new LinkedList<>();
		loop: for (int number = 1; number <= 9; number++) {
			for (int row = 0; row < 9; row++) {
				if (matrix[row][c] == number)
					continue loop;
			}

			for (int col = 0; col < 9; col++) {
				if (matrix[r][col] == number)
					continue loop;
			}

			int blockR = r - (r % 3);
			int blockC = c - (c % 3);

			for (int br = 0; br < 3; br++) {
				for (int bc = 0; bc < 3; bc++) {
					if (matrix[blockR + br][blockC + bc] == number) {
						continue loop;
					}
				}
			}

			list.add(number);

		}

		return list;
	}

	static boolean flag = false;

	static void dfs(int r, int c) {
		if (flag) {
			return;
		}

		if (r == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(matrix[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString().strip());
			flag = true;
			return;
		}

		int nr = (c != 8) ? r : r + 1;
		int nc = (c != 8) ? c + 1 : 0;

		if (matrix[r][c] != 0) {
			dfs(nr, nc);
		} else {
			List<Integer> list = ableNumbers(r, c);

			for (int num : list) {
				matrix[r][c] = num;
				dfs(nr, nc);
				matrix[r][c] = 0;
			}
		}

	}
}
