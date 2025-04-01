import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static double[][] loc;
	static boolean[] visited;
	static int[] path;
	static double[][] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		loc = new double[N][2];
		dist = new double[N][N];
		for (int i = 0; i < N; i++) {
			loc[i][0] = sc.nextDouble();
			loc[i][1] = sc.nextDouble();
		}
		// 별에서 별로 모든 거리 측정
		calcdist();
		// 가장 가까운 별들끼리 묶기
		for (int start = 0; start < N; start++) {
			visited = new boolean[N];
			path = new int[N];
			constellation(start);
			System.out.print(Arrays.toString(path));
		}
		sc.close();
	}

	static void calcdist() {
		for (int from = 0; from < N; from++) {
			for (int to = from + 1; to < N; to++) {
				double d = Math.sqrt(Math.pow(loc[from][0] - loc[to][0], 2) + Math.pow(loc[from][1] - loc[to][1], 2));
				dist[from][to] = d;
				dist[to][from] = d;
				if (from == to)
					dist[from][to] = Double.MAX_VALUE;
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double dist;

		public Edge(int from, int to, double dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.dist == o.dist)
				return 0;
			else if (this.dist > o.dist)
				return 1;
			else
				return -1;
		}
	}

	static void constellation(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[start] = true;
		for (int target = 0; target < N; target++) {
			if (target == start)
				continue;
			pq.add(new Edge(start, target, dist[start][target]));
		}
		path[0] = start;
		int idx = 1;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (visited[curr.to])
				continue;
			path[curr.to] = curr.from;
			idx++;
			if (idx == N)
				break;
			visited[curr.to] = true;
			for (int target = 0; target < N; target++) {
				if (target == curr.to)
					continue;
				pq.add(new Edge(curr.to, target, dist[curr.to][target]));
			}
		}
	}
}
