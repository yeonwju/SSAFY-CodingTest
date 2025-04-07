import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_메모리초과 {
	static int result = -1;
	static long S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Long.parseLong(br.readLine());
		calc(0, 0, -1); // 0은 자연수가 아니여서 -1, (1,1,1)을 넣으면 1을 포함안 할 경우 오류남 
		System.out.println(result);
	}

	static void calc(int num, long sum, int cnt) {
		// 탈출
		if (sum == S) {
			result = cnt;
			return;
		}
		if(sum > S || num > S)
			return;
		// 재귀
		if (result == -1) {
			calc(num + 1, sum + num, cnt + 1);
			calc(num + 1, sum, cnt);
		}
	}
}
