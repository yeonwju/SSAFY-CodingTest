package boj_1946_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
	
		for(int i=0; i<T; i++) {
			int cnt = Integer.parseInt(br.readLine());
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
			StringTokenizer st = null;
			for(int j=0; j<cnt; j++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			int result = 0;
			int nowMin = Integer.MAX_VALUE;
			
			while(!pq.isEmpty()) {
				int sec = pq.poll()[1];
				if(nowMin > sec) {
					result++;
					nowMin = sec;
				}
			}
			System.out.println(result);
		}
	}
}