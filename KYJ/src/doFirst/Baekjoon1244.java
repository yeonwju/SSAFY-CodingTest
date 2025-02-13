package doFirst;

import java.util.Scanner;

public class Baekjoon1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int swiNum = sc.nextInt(); // 스위치 개수

		sc.nextLine();

		String[] swi = sc.nextLine().split(" ");

		int[][] swiInfo = new int[swiNum][2]; // 스위치 정보

		// 0열 - 스위치의 번호 , 1열 스위치의 상태
		for (int i = 0; i < swiNum; i++) {

			swiInfo[i][0] = i + 1;
			swiInfo[i][1] = Integer.parseInt(swi[i]);

		}

		int stuNums = sc.nextInt(); // 학생 수

		sc.nextLine();

		int[][] stuInfo = new int[stuNums][2]; // 학생 정보

		// 0열 - 스위치의 번호 , 1열 스위치의 상태
		for (int i = 0; i < stuNums; i++) {

			String[] stu = sc.nextLine().split(" ");

			stuInfo[i][0] = Integer.parseInt(stu[0]);
			stuInfo[i][1] = Integer.parseInt(stu[1]);

		}

		for (int i = 0; i < stuNums; i++) { // 학생수만큼 반복한다

			// 남학생일때
			if (stuInfo[i][0] == 1) {

				for (int j = 0; j < swiNum; j++) {

					if (swiInfo[j][0] % stuInfo[i][1] == 0) { // 스위치 번호가 받은 수의 배수일 때(받은수로 나눈 나머지가 0일때)

						swiInfo[j][1] = (swiInfo[j][1] == 0 ? 1 : 0); // 1이면 0 저장, 0이면 1 저장

					}

				}

				// 여학생일때
			} else if (stuInfo[i][0] == 2) {

				int point = stuInfo[i][1]; // 여학생이 받은 숫자

				// 여학생이 받은 숫자와 스위치 번호가 일치할때 0이면 1로, 1이면 0으로 수정한다
				// 해당 작업은 좌우대칭의 범위가 어디까지이든 무조건 해야하기 때문에 반복문에 들어가기 전에 실행한다
				swiInfo[point - 1][1] = swiInfo[point - 1][1] == 0 ? 1 : 0;

				int np = (point - 1) + 1; // 여학생이 받은 숫자(플러스)
				int nm = (point - 1) - 1; // 여학생이 받은 숫자(마이너스)

				if (np <= swiNum - 1 && nm >= 0) { //인덱스의 범위를 0과 스위치 번호까지만 제한

					while (swiInfo[np][1] == swiInfo[nm][1]) { // 좌우대칭일때 까지만

						swiInfo[np][1] = swiInfo[np][1] == 0 ? 1 : 0;
						swiInfo[nm][1] = swiInfo[nm][1] == 0 ? 1 : 0;

						np++; // 다음 확인을 위해 + 1 
						nm--; // 다음 확인을 위해 - 1

						if ((np <= swiNum - 1 && nm >= 0) == false) { //인덱스의 범위가 넘어가면 반복문 나가기

							break;

						}

					}
				}

			}

		}

		for (int i = 0; i < swiNum; i++) {
			if ((i + 1) % 20 == 0) { // 20번째는 공백 없이 출력 후 줄바꿈
				
				System.out.print(swiInfo[i][1]);
				System.out.println();
			} else {
				System.out.print(swiInfo[i][1] + " ");
			}
		}

	}

}
