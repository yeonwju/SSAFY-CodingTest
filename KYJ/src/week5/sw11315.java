package week5;

import java.util.Scanner;

public class sw11315 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int num = sc.nextInt(); // n
			sc.nextLine();

			int[][] arr = new int[num][num]; // 판의 정보

			// o -> 1 / . -> 0 으로 저장
			for (int i = 0; i < num; i++) {
				String[] st = sc.nextLine().split("");
				for (int j = 0; j < num; j++) {
					if (st[j].equals("o")) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = 0;
					}
				}
			}

			// 상하좌우, 대각선 상하좌우
			int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
			int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

			int count = 0; // 'o' 개수 카운트
			boolean check = false; // 하나의 방향으로 1이 다섯개 이상일 경우 true;

			end: for (int i = 0; i < num; i++) { // 행
				for (int j = 0; j < num; j++) { // 열
					for (int a = 0; a < 8; a++) { // 방향
						count = 0; // 방향 바꿀때마다 카운트 초기화
						for (int b = 0; b < num; b++) { // 범위
							// 인덱스 범위 조절
							if (i + dr[a] * b >= 0 && j + dc[a] * b >= 0 && i + dr[a] * b < num
									&& j + dc[a] * b < num) {
								if (arr[i + dr[a] * b][j + dc[a] * b] == 1) { // 동그라미가 나올 때
									count++;
								} else { // 1이 나오다가 0 나오면 카운트 끝
									break;
								}
							}
						}
						if (count >= 5) { // 한방향으로 1이 5번 이상 나오면 "YES" 출력 후 반복문 종료
							System.out.println("#" + test_case + " " + "YES");
							check = true; // true 변경
							break end;
						}
					}
				}
			}
			if (!check) { // 5이상 안나왔을 경우 "NO"
				System.out.println("#" + test_case + " " + "NO");
			}
		}
	}
}
