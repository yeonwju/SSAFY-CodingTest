package boj_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N > K) {
			System.out.println(N-K);
			return;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {N, 0});
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[N] = 0;
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int loc = info[0];
			int sec = info[1];
			if(loc == K) {
				System.out.println(sec);
				return;
			} else if (loc < K) {
				if(bound(loc+1) && visited[loc+1] > sec+1) {
					visited[loc+1] = sec+1;
					pq.add(new int[] {loc+1, sec+1});
				}
				if(bound(loc*2) && visited[loc*2] > sec) {
					visited[loc*2] = sec;
					pq.add(new int[] {loc*2, sec});
				}
				if(bound(loc-1) && visited[loc-1] > sec+1) {
					visited[loc-1] = sec+1;
					pq.add(new int[] {loc-1, sec+1});
				}
			} else {
				if(bound(loc-1) && visited[loc-1] > sec+1) {
					visited[loc-1] = sec+1;
					pq.add(new int[] {loc-1, sec+1});
				}
			}
		}
	}
	static boolean bound(int loc) {
		return loc>=0 && loc <= 100000;
	}
}
