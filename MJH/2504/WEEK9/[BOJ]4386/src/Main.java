import java.util.*;

public class Main {
    static int N;
    static double[][] loc;
    static boolean[] visited;
    static List<Edge>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        loc = new double[N][2];
        visited = new boolean[N];
        edges = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            loc[i][0] = sc.nextDouble();
            loc[i][1] = sc.nextDouble();
            edges[i] = new ArrayList<>();
        }

        // 모든 거리 간선 만들기
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(Math.pow(loc[i][0] - loc[j][0], 2) + Math.pow(loc[i][1] - loc[j][1], 2));
                edges[i].add(new Edge(j, dist));
                edges[j].add(new Edge(i, dist));
            }
        }

        double sum = constellation();
        System.out.printf("%.2f", sum);
        sc.close();
    }

    static double constellation() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[0] = true;
        double sum = 0;

        for (Edge edge : edges[0]) {
            pq.add(edge);
        }

        int count = 1;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.to]) continue;

            visited[curr.to] = true;
            sum += curr.dist;
            count++;

            if (count == N) break;

            for (Edge next : edges[curr.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return sum;
    }

    static class Edge implements Comparable<Edge> {
        int to;
        double dist;

        public Edge(int to, double dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }
}
