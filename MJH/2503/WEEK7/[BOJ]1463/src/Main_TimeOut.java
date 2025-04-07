import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_TimeOut {
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		br.close();
		calc(num, 0);
		System.out.println(result);
	}

	static void calc(int num, int cnt) {
		if (num == 1) {
			result = cnt < result ? cnt : result;
			return;
		}
		if (num % 3 == 0)
			div3(num, cnt + 1);
		if (num % 2 == 0)
			div2(num, cnt + 1);
		min1(num, cnt + 1);
	}

	static void div3(int num, int cnt) {
		calc(num / 3, cnt);
	}

	static void div2(int num, int cnt) {
		calc(num / 2, cnt);
	}

	static void min1(int num, int cnt) {
		calc(num - 1, cnt);
	}

}
