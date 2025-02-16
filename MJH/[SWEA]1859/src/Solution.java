import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr = new int[len];
			String[] line = br.readLine().split(" ");
			for (int i = 0; i < len; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			int[] maxs = new int[len];
			int max = Integer.MIN_VALUE;
			for (int i = len - 1; i >= 0; i--) {
				max = max > arr[i] ? max : arr[i];
				maxs[i] = max;
			}

			long sum = 0;
			for (int i = 0; i < len; i++) {
				sum += maxs[i] - arr[i];
			}
			System.out.println("#" + tc + " " + sum);
		} // testcase }
		br.close();
	}

}
