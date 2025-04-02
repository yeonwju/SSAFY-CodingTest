import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_pq {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if (line.length() < M)
				continue;
			map.put(line, map.getOrDefault(line, 0) + 1);
		}
		PriorityQueue<Voca> pq = new PriorityQueue<>();
		for (String key : map.keySet()) {
			pq.add(new Voca(key, map.get(key)));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().word).append("\n");
		}
		System.out.println(sb);
	}

	static class Voca implements Comparable<Voca> {
		String word;

		int frequency;

		public Voca(String word, int frequency) {
			this.word = word;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(Voca o) {
			if (this.frequency != o.frequency)
				return Integer.compare(o.frequency, this.frequency); // 오름차순
			else if (this.word.length() != o.word.length())
				return Integer.compare(o.word.length(), this.word.length()); // 오름차순
			else {
				for (int i = 0; i < o.word.length(); i++) {
					if (this.word.charAt(i) != o.word.charAt(i)) {
						return Integer.compare(this.word.charAt(i), o.word.charAt(i)); // 내림차순
					}
				}
				return 0;
			}
		}

	}

}
