import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		br.close();
//		// 숫자만
//		String[] lines = line.split("\\+|\\-");
//		int[] nums = new int[lines.length];
//		for (int i = 0; i < lines.length; i++) {
//			nums[i] = Integer.parseInt(lines[i]);
//		}
//		// +- 만
//		char[] eq = new char[line.length() - lines.length];
//		int minusCnt = 0;
//		for (int i = 0, k = 0; i < line.length(); i++) {
//			char ch = line.charAt(i);
//			if (ch == '+' || ch == '-') {
//				eq[k++] = ch;
//				if (ch == '-')
//					minusCnt++;
//			}
//		}
//		// 계산 ㄱㄱ
//		int ans = nums[0];
//		for(int i = 0 ; i < nums.length - 1 ; i++) {
//			if(eq[i] == '-') {
//		//아 으악으악
//			}
//		}
		String[] tokens = line.split("-");

		int result = 0;

		for (int i = 0; i < tokens.length; i++) {
			String[] plusSplit = tokens[i].split("\\+");
			int sum = 0;
			for (String num : plusSplit) {
				sum += Integer.parseInt(num);
			}

			if (i == 0) {
				result = sum;
			} else {
				result -= sum;
			}
		}

		System.out.println(result);
	}

//	static int calc(int n1, char eq, int n2) {
//		int ans;
//		switch (eq) {
//		case '+':
//			ans = n1 + n2;
//			break;
//		case '-':
//			ans = n1 - n2;
//			break;
//		default:
//			ans = 0; // 흠 이거 좀 별로다. 일단 킵
//		}
//		return ans;
//	}
}
