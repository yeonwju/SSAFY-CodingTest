import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_메모리초과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			matrix[i][i] = Integer.parseInt(st.nextToken());
		}

		for (int start = 0; start < N; start++) {
			for (int end = start + 1; end < N; end++) {
				matrix[start][end] += matrix[start][end - 1] + matrix[end][end];
			}
		}

//		for (int start = 0; start < N; start++) {
//			for (int end = 0; end < N; end++) {
//				System.out.print(matrix[start][end]+" ");
//			}
//			System.out.println();
//		}

		int cnt = 0;
		for (int start = 0; start < N; start++) {
			for (int end = start; end < N; end++) {
				if (matrix[start][end] == M) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
