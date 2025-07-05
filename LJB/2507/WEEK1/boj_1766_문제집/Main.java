package boj_1766_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		List<Integer>[] graph;
		int[] degree;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		degree = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			degree[to]++;
			graph[from].add(to);
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int idx : graph[num]) {
				if(--degree[idx] == 0) {
					q.add(idx);
				}
			}
			sb.append(num).append(' ');
		}
		System.out.println(sb.toString());
	}
}
