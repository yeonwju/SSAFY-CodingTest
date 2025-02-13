package week3;

import java.util.Scanner;

public class Baekjoon2839 {
	
	//설탕 배달
	
	/*경우를 크게 나누면 5kg으로만 들거나, 5kg,3kg 함께 들거나, -1을 출력한다
	 * 1. 먼저 5로만 나누어지면 바로 다 나누고 몫을 출력한다
	 * 2. 1번이 안되는 경우 설탕이 3미만으로 남았을 경우 -1 을 출력한다
	 * 3. 1번과 2번 모두 해당 안되는 경우 3kg을 뺀다
	 * */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int sugar = sc.nextInt();

		int count = 0;

		while (sugar > 0) {
			
			//5로 다 나뉘면 나눈 몫을 카운트에 추가한다
			if (sugar % 5 == 0) {

				count += sugar / 5;
				System.out.println(count);
				return;
			}
			
			// 설탕이 3 미만으로 남으면 -1을 출력한다
			if (sugar < 3) {

				System.out.println(-1);
				return;
			}
			
			//기본 값 : 설탕을 3씩 빼고 카운트 한다
			sugar -= 3;
			count++;

		}

		System.out.println(count);
	}

}
