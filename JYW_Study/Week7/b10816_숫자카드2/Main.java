package b10816_숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				int a = map.get(num);
				a++;
				map.put(num, a);
			} else {
				map.put(num, 1);
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) {
				bw.write(map.get(a)+" ");
			}else {
				bw.write(0+" ");
			}
		}
		bw.flush();
	}
}
