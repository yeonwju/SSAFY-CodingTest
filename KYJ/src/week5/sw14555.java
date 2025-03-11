package week5;

import java.util.Scanner;

public class sw14555 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int count = 0;
			StringBuilder sb = new StringBuilder(sc.next());

			for (int i = 0; i < sb.length(); i++) {

				// 여는 괄호와 닫는 괄호가 붙어있으면 공
				if (sb.charAt(i) == '(' && sb.charAt(i + 1) == ')') {
					count += 1;
					// 공을 공백으로 바꿔야 하는데 그냥 두고 지나가면
					// 아래 else if문에서 닫힌 괄호 조건에 걸려 count 한번 더 되기 때문
					sb.replace(i, i + 1, "");
				// 여는 괄호가 있고 다음에 잡초가 있으면
				} else if (sb.charAt(i) == '(' || sb.charAt(i) == ')') {
					count += 1;
				}

			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
