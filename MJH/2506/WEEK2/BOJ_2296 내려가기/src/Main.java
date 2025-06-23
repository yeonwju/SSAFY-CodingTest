import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		int[][] mini = new int[N + 1][3];
		int[][] mani = new int[N + 1][3];
		mini[0][0] = mani[0][0] = matrix[0][0];
		mini[0][1] = mani[0][1] = matrix[0][1];
		mini[0][2] = mani[0][2] = matrix[0][2];
		for (int i = 1; i < N; i++) {
			// 최대
			mani[i][0] = Math.max(mani[i - 1][0], mani[i - 1][1]) + matrix[i][0];
			mani[i][1] = Math.max(Math.max(mani[i - 1][0], mani[i - 1][1]), mani[i - 1][2]) + matrix[i][1];
			mani[i][2] = Math.max(mani[i - 1][1], mani[i - 1][2]) + matrix[i][2];
			// 최소
			mini[i][0] = Math.min(mini[i - 1][0], mini[i - 1][1]) + matrix[i][0];
			mini[i][1] = Math.min(Math.min(mini[i - 1][0], mini[i - 1][1]), mini[i - 1][2]) + matrix[i][1];
			mini[i][2] = Math.min(mini[i - 1][1], mini[i - 1][2]) + matrix[i][2];
		}

		int max = Math.max(Math.max(mani[N - 1][0], mani[N - 1][1]), mani[N - 1][2]);
		int min = Math.min(Math.min(mini[N - 1][0], mini[N - 1][1]), mini[N - 1][2]);
		
//		for(int i = 0 ; i < N ; i++) {
//			System.out.println(Arrays.toString(mani[i]));
//		}
		
		System.out.println(max + " " + min);
	}
}
