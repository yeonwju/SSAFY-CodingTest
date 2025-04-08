package week11;

import java.util.Scanner;

public class Baekjoon1303 {

	static char[][] arr;
	static boolean[][] check; // 방문 체크
	static int WP; // 같은팀 병사들 힘
	static int BP; // 적국 병사들 힘
	static int allWP; // 같은팀 병사들 힘
	static int allBP; // 적국 병사들 힘
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
	static int n;
	static int m;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 가로
		m = sc.nextInt(); // 세로
		sc.nextLine();

		arr = new char[m][n]; // 병사 정보
		check = new boolean[m][n]; // 방문 체크

		for (int i = 0; i < m; i++) {
			String st = sc.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = st.charAt(j); // 병사 정보 입력
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) { //방문하지 않았을 때
					char tmp = arr[i][j]; // 병사 구분(흰색, 파란색)
					power(i, j, tmp); //병사 힘 계산
					pp(tmp); //카운트 끝나면 n제곱 진행
				}
			}
		}
		System.out.println(allWP + " " + allBP);
	}

	// 병사 힘 계산
	private static void power(int x, int y, char soldier) {

		if (soldier == 'W') { // 우리 병사라면
			WP++; //카운트 +1
		} else { // 적국 병사라면
			BP++; //카운트 +1
		}

		check[x][y] = true; // 방문 처리

		for (int i = 0; i < 4; i++) { //상하좌우 탐색
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr >= 0 && nr < m && nc >= 0 && nc < n) { //인덱스 오류 방지
				char tmp = arr[nr][nc]; // 지금 병사 종류
				if (!check[nr][nc] && tmp == soldier) { // 방문하지 않았으면서 같은 종류의 병사라면
					power(nr, nc, tmp); // 다음 탐색 진행
				}
			}
		}
	}

	// n제곱 계산
	private static void pp(char soldier) {

		if (soldier == 'W') { // 우리 병사라면
			allWP += (int) Math.pow(WP, 2); //n제곱
			WP = 0; //초기화
		} else if(soldier == 'B'){ // 적국 병사라면
			allBP += (int) Math.pow(BP, 2); //n제곱
			BP = 0; //초기화
		}
	}
}