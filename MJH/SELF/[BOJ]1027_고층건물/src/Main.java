import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr; // 0부터 N-1까지
	static double[] degrees; // degrees[0] : 0과 1의 기울기 [N-2] : N-2과 N-1의 기울기
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		degrees = new double[N - 1];
		for (int i = 0; i < N - 1; i++) {
			degrees[i] = degree(i, i + 1);
		}

	}

	static double degree(int x1, int x2) {
		return (arr[x2] - arr[x1]) / (x2 - x1);
	}
}
