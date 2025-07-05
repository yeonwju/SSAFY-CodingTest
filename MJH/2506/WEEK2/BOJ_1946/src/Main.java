import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			List<P> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int g1 = sc.nextInt();
				int g2 = sc.nextInt();
				list.add(new P(g1, g2));
			}
			Collections.sort(list);
			
			int limitG2 = Integer.MAX_VALUE;
			int cnt = 0;
			for(P p : list) {
				if(p.g2 < limitG2) {
					limitG2 = p.g2;
					cnt ++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

	static class P implements Comparable<P> {
		int g1;
		int g2;

		public P(int g1, int g2) {
			this.g1 = g1;
			this.g2 = g2;
		}

		@Override
		public int compareTo(P o) {
			return Integer.compare(this.g1, o.g1);
		}

		@Override
		public String toString() {
			return "[g1 : " + g1 + " g2 : " + g2 + "]";
		}

	}
}
