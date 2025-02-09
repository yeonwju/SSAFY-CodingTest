package week2;

import java.util.Scanner;

public class Baekjoon2292 {

	// 벌집//

	/*
	 * 육각형의 벌집 가운데가 첫번째 벽으로 1까지, 두번째 벽은 7까지, 세번째 벽은 19까지 ... 1 , 7, 19, 37, 61 로 숫자가
	 * 늘어남 -6- -12- -18- -24- 숫자간의 차이 X2를 하며 계속 늘어남
	 * 
	 * 찾는 숫자가 포함되어 있는 칸을 찾으면 몇개의 방을 지나갔는지 알게 된다
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 찾고자 하는 숫자

		int start = 1; // 첫번째 벽 1

		for (int j = 0;; j++) {

			start += (6 * j); // 6*1, 6*2 ... 반복문으로 돌려서 합 누적

//			System.out.println("start의 값" + start);
//			System.out.println("j의 값" + j);

			if (num > 6 * (j - 1) && num <= start) { // 이전 루프 i와 현재 루프 i사이에 숫자가 해당 시

				System.out.println(j + 1); // j가 0부터 시작해서 +1 하여 출력
				break; // 반복문 나오기

			}

		}

		sc.close();

	}

}
