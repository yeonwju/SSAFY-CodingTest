import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    static int[] degree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트로 변경
        List<List<Integer>> order = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            order.add(new ArrayList<>());
        }

        degree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            order.get(p).add(l);
            degree[l]++;
        }

        // 우선순위 큐: 번호가 작은 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");

            for (int next : order.get(curr)) {
                degree[next]--;
                if (degree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
