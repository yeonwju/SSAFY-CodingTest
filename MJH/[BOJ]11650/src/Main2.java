import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] input = new int[N][2];

		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			input[i][0] = Integer.parseInt(line[0]);
			input[i][1] = Integer.parseInt(line[1]);
		}
		br.close();
		Arrays.sort(input, (a, b) -> {
			if (a[0] != b[0])
				return a[0] - b[0];
			else
				return a[1] - b[1];
		});
		StringBuilder sb = new StringBuilder();
		sb.append(input[0][0]).append(" ").append(input[0][1]);
		for (int i = 1; i < N; i++) {
			sb.append("\n").append(input[i][0]).append(" ").append(input[i][1]);
		}
		System.out.println(sb);
	}

}
