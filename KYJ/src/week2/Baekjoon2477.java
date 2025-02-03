package week2;

import java.util.Scanner;

public class Baekjoon2477 {

	// 참외밭
 
	 /* 1. 처음에 정보 값을 담을 때 동,서(1,2) 남,북(3,4) 별로 나누어서 동서에서 가장 큰 값, 남북에서 제일 큰 값을 구함
	 * - 세로*가로가 직사각형의 넓이이기 때문에 각각 하나씩 구하면 된다.
	 * 2. 해당 방향(동서/남북)의 최댓값이 아니면서 앞 뒤로 반대 방향의 최댓값이 존재하지 않으면 그것이 빼야할 길이 값임
	 * 3. (가장 큰 직사각형 넓이 - 존재하지 않는 직사각형 넓이) * 참외 수 출력 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int[][] info = new int[6][2];

		int dongSeoMax = 0; //동서 최댓값
		int namBukMax = 0; //남북 최댓값

		sc.nextLine();

		// 1. 2차원 배열에 정보담기
		for (int i = 0; i < 6; i++) {

			String[] st = sc.nextLine().split(" ");

			info[i][0] = Integer.parseInt(st[0]);
			info[i][1] = Integer.parseInt(st[1]);

			if (info[i][0] < 3) { // 동,서만 담아서 최댓값 구하기

				dongSeoMax = Math.max(dongSeoMax, info[i][1]);

			} else { // 남,북만 담아서 최댓값 구하기

				namBukMax = Math.max(namBukMax, info[i][1]);

			}

		}

		int minusDongSeoMax = 0; // 빼야할 동서 길이
		int minusNamBukMax = 0; // 빼야할 남북 길이

		// 2. 빼야할 길이 값 구하기
		for (int i = 0; i < 6; i++) {

			// 동, 서중 가장 큰 값이 아닌 두 값 뽑기
			if (info[i][0] < 3 & info[i][1] != dongSeoMax) {
				
				//i가 0이거나 최댓값이면 이전, 이후값을 구할 때 인덱스 에러가 나므로 0일때, 최댓값일 때, 그 사이일때로 나누어서 확인
				if (i > 0 && i < 5) {

					// 지금 값의 인덱스 앞뒤로 남북의 가장 큰 값이 있지 않으면 그게 빼야하는 작은 직사각형 둘레임
					if (info[i - 1][1] != namBukMax & info[i + 1][1] != namBukMax) {

						minusDongSeoMax = info[i][1];

					}
				} else if (i == 0) {

					if (info[5][1] != namBukMax & info[1][1] != namBukMax) {

						minusDongSeoMax = info[i][1];

					}

				} else if (i == 5) {

					if (info[0][1] != namBukMax & info[4][1] != namBukMax) {

						minusDongSeoMax = info[i][1];

					}

				}
			}

			// 남, 북중 가장 큰 값이 아닌 두 값 뽑기
			else if (info[i][0] > 2 & info[i][1] != namBukMax) {

				if (i > 0 && i < 5) {

					// 그 값의 인덱스 앞뒤로 남북의 가장 큰 값이 있지 않으면 그게 빼야하는 작은 직사각형 둘레임
					if (info[i - 1][1] != dongSeoMax & info[i + 1][1] != dongSeoMax) {

						minusNamBukMax = info[i][1];

					}

				} else if (i == 0) {

					if (info[5][1] != dongSeoMax & info[1][1] != dongSeoMax) {

						minusNamBukMax = info[i][1];

					}

				} else if (i == 5) {

					if (info[0][1] != dongSeoMax & info[4][1] != dongSeoMax) {

						minusNamBukMax = info[i][1];

					}

				}
			}

		}
		
		// 최종 값 출력
		System.out.println(((dongSeoMax * namBukMax) - (minusDongSeoMax * minusNamBukMax)) * num);

	}

}
