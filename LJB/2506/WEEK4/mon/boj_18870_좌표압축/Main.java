package boj_18870_좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		int[] input = new int[cnt];
		TreeSet<Integer> nums = new TreeSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<cnt; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
			nums.add(num);
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		Iterator<Integer> itr =  nums.iterator();
		int idx = 0;
		while(itr.hasNext()) {
			map.put(itr.next(),idx++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cnt; i++, sb.append(' ')) {
			sb.append(map.get(input[i]));
		}
		
		System.out.println(sb.toString());
	}
}
