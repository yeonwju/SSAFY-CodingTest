package week5;

import java.util.Scanner;

public class sw1289 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			StringBuilder result = new StringBuilder(sc.next()); // 최종값
			StringBuilder sb = new StringBuilder();

			// 초기값 만들기(최종값의 길이만큼 0을 만든다)
			for (int i = 0; i < result.length(); i++) {
				sb.append("0");
			}

			int idx = 0; // while문에서 증가시킽 인덱스
			int count = 0; // 수정 횟수

			// 초기값과 입력값이 같지 않을때까지 반복
			while (!sb.toString().equals(result.toString())) {
				// 인덱스 초과시 0부터 다시 시작
				if (idx >= result.length()) {
					idx = 0;
				}
				// 입력값과 초기값이 현재 인덱스(idx)에서 같지 않을 때
				if (result.charAt(idx) != sb.charAt(idx)) {
					// 입력값의 현재 인덱스가 1이면
					if (result.charAt(idx) == '1') {
						for (int i = idx; i < sb.length(); i++) {
							sb.setCharAt(i, '1'); // 초기값의 현재 인덱스부터 끝까지 1로 수정
						}
						count++; // 수정 횟수 +1
						// 입력값의 현재 인덱스가 0이면
					} else if (result.charAt(idx) == '0') {
						for (int i = idx; i < sb.length(); i++) {
							sb.setCharAt(i, '0'); // 초기값의 현재 인덱스부터 끝까지 0으로 수정
						}
						count++; // 수정 횟수 +1
					}
				}
				idx++; // 인덱스 증가
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
