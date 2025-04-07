import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_시간초과 {

	static int cnt = 0;
	static boolean shorten;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= N; tc++) {
			String line = br.readLine();
			Queue<Character> d = new LinkedList<>();
			for (int i = 0; i < line.length(); i++) {
				d.add(line.charAt(i));
			}

			shorten = true;
			calc(d);

		}
		System.out.println(cnt);
	}

	static void calc(Queue<Character> d) {
		//System.out.println("d : " + d);
		if (shorten) {
			Queue<Character> nextd = check(d);
			if (nextd.isEmpty())
				cnt++;
			else
				calc(nextd);
		}

	}

	static Queue<Character> check(Queue<Character> d) {
		shorten = false;
		Queue<Character> nextd = new LinkedList<>();
		int length = d.size();
		int idx = 0;
		while (!d.isEmpty() && idx < length) {
			char ch1 = d.poll();
			//System.out.println("ch1 : " + ch1);
			idx++;

			if (d.isEmpty()) {
				nextd.add(ch1);
				break;
			}
			char ch2 = d.peek();
			//System.out.println("ch2 : " + ch2);

			if (ch1 == ch2) {
				shorten = true;
				d.poll();
				idx++;
			} else {
				nextd.add(ch1);
			}
		}
		//System.out.println("nextd : " + nextd);

		return nextd;
	}
}
