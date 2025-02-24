import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		StringBuilder sb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) { // tc
			sb = new StringBuilder();
			String[] strArr = br.readLine().split(" ");
			int N = Integer.parseInt(strArr[0]);
			int M = Integer.parseInt(strArr[1]);

			int[][] table = new int[N][N];

			for (int row = 0; row < N; row++) {
				strArr = br.readLine().split(" ");
				for (int col = 0; col < N; col++) {
					table[row][col] = Integer.parseInt(strArr[col]);
				}
			}

			int cnt = 0;
			int sizeV = 0;
			int sizeH = 0;
			for (int i = 0; i < N; i++) {
				sizeV = 0;
				sizeH = 0;
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 1)
						sizeV++;
					if (table[i][j] == 0 || (j + 1 < N && table[i][j+1] == 0)) {
						if (sizeV == M) {
							cnt++;
						}
						sizeV = 0;
					}
					if (table[j][i] == 1)
						sizeH++;
					if (table[j][i] == 0 || (j + 1 < N && table[j+1][i] == 0)) {
						if (sizeH == M) {
							cnt++;
						}
						sizeH = 0;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb.toString());
		} // tc

		br.close();
	}

}
