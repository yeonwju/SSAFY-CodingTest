package boj_1202_보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int N, K;
	static TreeMap<Integer, Integer> bags;
	static int[][] infos;
	static final int MAX_WEIGHT = 100000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		infos = new int[N][2];
		bags = new TreeMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			infos[i][0] = Integer.parseInt(st.nextToken());
			infos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(infos, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] != o1[1] ? o2[1]-o1[1] : o1[0]-o2[0];
			}
		});
		
		for(int i=0; i<K; i++) {
			int c = Integer.parseInt(br.readLine());
			bags.compute(c, (k, v) -> v == null ? 1 : (Integer)bags.get(c) + 1);
		}
		long total = 0;
		for(int i=0; i<N; i++) {
			int w = infos[i][0];
			int v = infos[i][1];
			Integer suitable = bags.ceilingKey(w);
		    if (suitable != null) {
		        total += v;
		        int count = bags.get(suitable);
		        if (count > 1) {
		            bags.put(suitable, count - 1);
		        } else {
		            bags.remove(suitable);
		        }
		    }

		}
		System.out.println(total);
	}
}
