package week3;

import java.util.Scanner;

public class Baekjoon1592 {

	// 영식이와 친구들

	/**/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] st = sc.nextLine().split(" ");
		
		int num =  Integer.parseInt(st[0]);// 사람 수
		int ball = Integer.parseInt(st[1]); // 공 받는 최댓값
		int location = Integer.parseInt(st[2]); // 이동 값

		int[][] info = new int[num][2];

		// 2차원 배열로 인덱스 값과 공 받은 횟수 입력(초기값)
		for (int i = 0; i < num; i++) {

			info[i][0] = i;
		}

		int row = 0; // 처음 자리 값
		int count = 0; // 공 주고 받은 횟수

		// 공을 주고 받자
		for (int i = 0;; i++) {

			// 1. row값이 비정상일때 정상 인덱스 값으로 바꾸자
			if (row >= num) { // row가 사람수를 넘었을때

				row = row - num; // (현재 위치 + location) - 사람 수

			} else if (row < 0) { // row수가 0 미만으로 나왔을 때

				row = num - Math.abs(row); // num - |넘어온 인덱스 값|

			}
			
			// 2. 비정상을 정상으로 바꾼 후거나, 애초에 정상일 때 해당 자리 공 받은 횟수 +1
			info[row][1] += 1; // 해당 자리값에 공 받은 횟수 추가
			
			// 3-1. 볼 받을 수 있는 횟수가 최대 1이면 처음 사람이 받고 끝이므로 0 출력하고 끝낸다
			if(ball == 1) {
				
				System.out.println(count);
				break;
			}
			
			// 3-2. 공을 받은 후 공 받을 수 있는 최댓값 넘어가면 공 횟수 +1 해주고 반복문 끝내기 [출력 값]
			if (info[row][1] == ball) {

				info[row][1] += 1;
				System.out.println(count);
				break;

			} 
			
			// 4. 또 공을 주고 받아도 된다면 현재 위치의 공 받은 횟수가 짝/홀 인지 확인 후 +/- 하여 row값 넘겨줌
			if (info[row][1] % 2 == 1) {

				row += location;
				count++; //공을 넘겨줬으므로 +1

			} else if ((info[row][1] % 2 == 0)) {

				row -= location;
				count++; //공을 넘겨줬으므로 +1
			}

		}
		
		sc.close();
		
	}

}
