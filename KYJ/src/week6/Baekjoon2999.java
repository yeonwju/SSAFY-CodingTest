package week6;

import java.util.Scanner;

public class Baekjoon2999 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[] ch = sc.next().toCharArray(); // 문자열 배열 저장
		int n = ch.length; // 문자열 길이
		int r = 0; // 암호화 판 행
		int c = 0; // 암호화 판 열

		// 행*열 = 문자열 길이 && 행(최대값 ) <= 열
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i <= j && (i * j) == n) { // 조건 걸기
					r = i;
					c = j;
				}
			}
		}

		char[][] result = new char[r][c]; // 위에서 구한 행,열로 배열 만들기
		int idx = 0; // 문자열 초과 방지

		for (int i = 0; i < c; i++) { // 열 기준
			for (int j = 0; j < r; j++) { // 행 기준
				if (idx < ch.length) { // 문자열의 길이까지만 반복문 돌도록
					result[j][i] = ch[idx++]; // 입력받은 문자열을 저장
				}
			}
		}

		idx = 0; // 문자열 초과 방지
		StringBuilder st = new StringBuilder();

		for (int i = 0; i < r; i++) { // 행 기준
			for (int j = 0; j < c; j++) { // 열 기준
				if (idx < ch.length) {
					st.append(result[i][j]); // 암호화된 문자열을 똑바로 읽어서 저장
					idx++; // 인덱스 초과 방지
				}
			}
		}
		System.out.println(st);
	}
}
