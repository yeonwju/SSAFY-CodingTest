import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		Star[] stars = new Star[n];
		List<Starroad> starroad = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			stars[i] = new Star(x, y);
		}
		for (int row = 0; row < n; row++) {
			for (int col = row + 1; col < n; col++) {
				double cost = calcCost(stars[row], stars[col]);
				starroad.add(new Starroad(row, col, cost));
			}
		}
		Collections.sort(starroad);
		
		System.out.println(starroad);

	}

	static class Star {
		double x;
		double y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static double calcCost(Star s1, Star s2) {
		return Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2);
	}

	static class Starroad implements Comparable<Starroad> {
		int starNum1;
		int starNum2;
		double cost;

		public Starroad(int starNum1, int starNum2, double cost) {
			super();
			this.starNum1 = starNum1;
			this.starNum2 = starNum2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Main.Starroad o) {
			if (o.cost < this.cost) {
				return 1;
			} else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "Starroad [starNum1=" + starNum1 + ", starNum2=" + starNum2 + ", cost=" + cost + "]";
		}
		
	}
}
