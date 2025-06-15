import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 더하다가 int 범위 넘어가는 것 생각해서 long으로 바꿔야함
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		br.close();
		for(int i = 0 ; i < n ; i ++) {
			pq.add(Long.parseLong(st.nextToken()));
		}		
		for(int i = 0 ; i < m ; i++) {
			long p = pq.poll()+pq.poll();
			pq.add(p);
			pq.add(p);
		}
		long sum = 0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}
}
