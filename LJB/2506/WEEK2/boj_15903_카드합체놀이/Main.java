package boj_15903_카드합체놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static PriorityQueue<Long> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		
		while(st.hasMoreTokens()) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			
			pq.add(num1 + num2);
			pq.add(num1 + num2);
		}
		
		long result = 0;
		while(!pq.isEmpty()) {
			result += pq.poll();
		}
		System.out.println(result);
	}
}
