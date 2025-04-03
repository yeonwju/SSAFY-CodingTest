import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testcase; tc++) {
			// ------저장------

			// [0][] 은 비워둠
			// index : 모양, [] : 개수

			// A
			String[] lineA = br.readLine().split(" ");
			int cntA = Integer.parseInt(lineA[0]);
			int[] a = new int[5];
			
			for (int i = 1; i <= cntA; i++) {
				
				int shape = Integer.parseInt(lineA[i]);
				a[shape]++;
			}

			// B
			String[] lineB = br.readLine().split(" ");
			int cntB = Integer.parseInt(lineB[0]);
			int[] b = new int[5];
			
			for (int i = 1; i <= cntB; i++) {
				
				int shape = Integer.parseInt(lineB[i]);
				b[shape]++;
			}
			
			
			// ------비교------
			String winner = "D";
			for (int i = 4; i >= 1; i--) {
				if (a[i] > b[i]) {
					winner = "A";
					break;
				}
				if (a[i] < b[i]) {
					winner = "B";
					break;
				}
			}
			if (sb.length() != 0)
				sb.append("\n");
			sb.append(winner);
		}
		System.out.println(sb.toString());
		br.close();
	}

}
