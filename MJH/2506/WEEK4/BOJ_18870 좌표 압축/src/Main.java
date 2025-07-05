import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] Xs = new int[N];
		for (int i = 0; i < N; i++) {
			Xs[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬용 배열 복사
		int[] sort = Arrays.copyOf(Xs, N);
		Arrays.sort(sort);

		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(sort[i])) {
				map.put(sort[i], idx++);
			}
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(Xs[i])).append(" ");
		}
		System.out.println(sb);
	}
}
