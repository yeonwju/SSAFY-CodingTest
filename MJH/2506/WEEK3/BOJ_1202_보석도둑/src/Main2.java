import java.io.*;
import java.util.*;

public class Main2 {

    static class Stuff implements Comparable<Stuff> {
        int w, v;

        public Stuff(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Stuff o) {
            return Integer.compare(this.w, o.w); // 무게 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        Stuff[] stuff = new Stuff[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            stuff[i] = new Stuff(w, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(stuff); // 보석 무게 기준 오름차순
        Arrays.sort(bags);  // 가방 무게 기준 오름차순

        // 최대 힙: 가장 가치 높은 보석을 꺼내기 위해 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long total = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {
            // 현재 가방에 들어갈 수 있는 후보 보석을 pq에 넣음
            for (; j < N && stuff[j].w <= bags[i]; j++) {
                pq.offer(stuff[j].v);
            }

            // 넣을 수 있는 보석이 있다면 가장 가치 높은 것 꺼내기
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}
