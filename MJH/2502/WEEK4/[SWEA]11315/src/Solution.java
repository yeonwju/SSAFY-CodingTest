import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static char[][] table;
	static boolean omok;
	static boolean findmore;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			// table 초기화
			table = new char[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					table[i][j] = line.charAt(j);
				}
			}
			
			omok = false;
			findmore = true;
			find: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					isOmok(i, j, 1, 0, 0); // 아래로
					isOmok(i, j, 0, 1, 0); // 오른쪽으로
					isOmok(i, j, 1, 1, 0); // 오른쪽 아래 대각선으로
					isOmok(i, N - 1 - j, 1, -1, 0); // 왼쪽 아래 대각선으로
					if (!findmore)
						break find;
				}
			}
			if (omok)
				System.out.println("#" + tc + " YES");
			else
				System.out.println("#" + tc + " NO");
		} // tc
		br.close();
	} // main

	static void isOmok(int row, int col, int dRow, int dCol, int cnt) {
		if (table[row][col] == 'o') {
			cnt++;
			if (cnt >= 5) {
				omok = true;
				findmore = false;
			} else if (row + dRow < N && col + dCol < N && row + dRow >= 0 && col + dCol >= 0) {
				isOmok(row + dRow, col + dCol, dRow, dCol, cnt);
			}
		}
	}

}
