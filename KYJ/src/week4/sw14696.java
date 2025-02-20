package week4;

import java.util.Scanner;

public class sw14696 {
	// 별, 동그라미, 네모, 세모를 각각 숫자 4, 3, 2, 1

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine()); // 경기 수

		int[][] ac = new int[n][5]; // a 값별 카운팅 배열
		int[][] bc = new int[n][5]; // b 값별 카운팅 배열

		// A와 B의 딱지 정보 입력
		for (int i = 0; i < n; i++) {
			String[] ast = sc.nextLine().split(" ");
			// 패정보 첫번째는 그냥 개수라서 제외한다 그래서 1부터 시작
			for (int j = 1; j < ast.length; j++) {
				int avs = Integer.parseInt(ast[j]); // 패정보 int형으로 전환
				// 카운팅 배열 활용 : 해당 값을 인덱스에 넣어서 카운팅
				ac[i][avs] += 1;
			}
			String[] bst = sc.nextLine().split(" ");
			// 패정보 첫번째는 그냥 개수라서 제외한다 그래서 1부터 시작
			for (int j = 1; j < bst.length; j++) {
				int bvs = Integer.parseInt(bst[j]); // 패정보 int형으로 전환
				// 카운팅 배열 활용 : 해당 값을 인덱스에 넣어서 카운팅
				bc[i][bvs] += 1;
			}
		}

		int aCount = 0; // a 이긴 횟수
		int bCount = 0; // b 이긴 횟수

		for (int i = 0; i < n; i++) {
			// 라운드 시작할때마다 a,b 승패 초기화
			// 라운드 하나 종료했는데 a,b가 이긴 수 모두 0이면 무승부라서 그것을 알기위해
			aCount = 0;
			bCount = 0;
			for (int j = 4; j > 0; j--) {
				if (ac[i][j] > bc[i][j]) { // i라운드 패중에 a가 더 큰게 생기면
					System.out.println("A"); // a가 이김
					aCount++; // a승 +1
					break; // 해당 라운드 종료
				} else if (ac[i][j] < bc[i][j]) { // i라운드 패중에 b가 더 큰게 생기면
					System.out.println("B"); // b가 이김
					bCount++; // b승 +1
					break; // 해당 라운드 종료
				}
			}
			// 라운드가 종료됐는데 이긴 사람이 아무도 없다면 무승부
			if (aCount == 0 && bCount == 0) {
				System.out.println("D");
			}
		}
	}
}
