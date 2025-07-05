import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] degree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] matrix = new boolean[N + 1][N + 1];
		degree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			matrix[p][l] = true;
			degree[l]++;
		}
		br.close();

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				pq.add(new Node(i));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			sb.append(curr.number).append(" ");
			for (int next = 1; next <= N; next++) {
				if (matrix[curr.number][next]) {
					degree[next]--;
					if (degree[next] == 0) {
						pq.add(new Node(next));
					}
				}
			}
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		int number;

		public Node(int number) {
			this.number = number;
		}

		@Override
		public int compareTo(Node o) {
			if (degree[this.number] != degree[o.number]) {
				return Integer.compare(degree[this.number], degree[o.number]);
			}
			return Integer.compare(this.number, o.number);
		}

	}
}
