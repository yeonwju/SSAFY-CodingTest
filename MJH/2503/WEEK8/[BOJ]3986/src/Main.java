import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		String line;
		for (int tc = 1; tc <= N; tc++) {
			line = br.readLine();
			Stack<Character> stack = new Stack<>();

			for (char ch : line.toCharArray()) {
				if (!stack.isEmpty() && stack.peek() == ch)
					stack.pop();
				else
					stack.push(ch);
			}

			if (stack.isEmpty())
				cnt++;
		}

		System.out.println(cnt);
	}
}
