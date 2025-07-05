import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main2 {

	static int N, K;
	static int[] time = new int[100001];
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();

		Arrays.fill(time, INF);		
		time[N] = 0;
		// bfs
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(N);

		while (!dq.isEmpty()) {
			int curr = dq.poll();
			int nc = curr + 1;
			int pc = curr - 1;
			int cc = curr * 2;

			if (cc <= 100000 && time[curr] < time[cc]) {
				time[cc] = time[curr];
				dq.addFirst(cc);
			}
			if (nc <= 100000 && time[curr] < time[nc]) {
				time[nc] = time[curr] + 1;
				dq.addLast(nc);
			}
			if (pc >= 0 && time[curr] < time[pc]) {
				time[pc] = time[curr] + 1;
				dq.addLast(pc);
			}

		}

		System.out.println(time[K]);
	}

}
