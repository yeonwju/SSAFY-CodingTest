package week5;

import java.util.Scanner;

public class sw1979 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = sc.nextInt(); // n
			int k = sc.nextInt(); // k
			sc.nextLine();

			int rcount = 0; // 행 기준 단어 카운트
			int ccount = 0; // 열 기준 단어 카운트
			int allcount = 0; // 단어 전체 카운트

			int[][] arr = new int[n][n];

			// 단어판 정보 입력
			for (int i = 0; i < n; i++) {
				String[] st = sc.nextLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st[j]);
				}
			}

			// 행고정 열이동
			for (int i = 0; i < n; i++) {
				rcount = 0; // 행 바뀔때마다 행카운트 초기화
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) { // 흰색칸을 만나면
						rcount++; // 단어칸 +1
					} else if (arr[i][j] == 0) { // 만약 검은색 칸을 만나면
						if (rcount == k) { // 지금까지 셌던 흰색판이 3개 일 때
							allcount++; // 단어 가능칸 증가
						}
						rcount = 0; // 검은색칸을 만났으므로 행카운트 초기화
					}
				}
				if (rcount == k) { // 하나의 행이 끝났을 때 흰색칸이 k개라면
					allcount++; // 단어 가능칸 증가
				}
			}

			// 열고정 행이동
			for (int i = 0; i < n; i++) {
				ccount = 0; // 열 바뀔때마다 열카운트 초기화
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 1) { // 흰색칸을 만나면
						ccount++; // 단어칸 +1
					} else if (arr[j][i] == 0) { // 만약 검은색 칸을 만나면
						if (ccount == k) { // 지금까지 셌던 흰색판이 3개 일 때
							allcount++; // 단어 가능칸 증가
						}
						ccount = 0; // 검은색칸을 만났으므로 열카운트 초기화
					}
				}
				if (ccount == k) { // 하나의 열이 끝났을 때 흰색칸이 k개라면
					allcount++; // 단어 가능칸 증가
				}
			}
			System.out.println("#" + test_case + " " + allcount);
		}
	}
}
