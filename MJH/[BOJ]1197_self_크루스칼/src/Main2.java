import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

	static class Edge implements Comparable<Edge> {
		int s, e, cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	static Edge[] edges;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();

			edges[i] = new Edge(s, e, cost);
		}
		Arrays.sort(edges);
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		long ans = 0;
		int cnt = 1;
		for (int i = 0; i < E; i++) {
			Edge edge = edges[i];
			int x = edge.s;
			int y = edge.e;
			int px = findSet(x);
			int py = findSet(y);
			if (px != py) {
				union(px, py);
				ans += edge.cost;
				cnt++;
			}
			if (cnt == V)
				break;
		}
		System.out.println(ans);
	}

	static void union(int x, int y) {
		p[y] = x;
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}
