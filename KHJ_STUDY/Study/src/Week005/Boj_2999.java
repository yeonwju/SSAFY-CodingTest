package Week005;

import java.util.Scanner;

public class Boj_2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int N = str.length();
		int r = 0;
		int c = 0;
		for(int i = 1; i <= N; i++) {
			// i가 N / i보다 커지면 중지
			// ex 45 -> 3 15 / 5 9 / 9 5 (row가 더 커졌으니 중지) 
			if(i > (N / i)) {
				break;
			}
			// 입력받은 문자의 길이에서 i를 나누고
			// 나머지가 0이면 row와 col을 저장한다.
			if(N % i == 0) {
				r = i;
				c = N / i;
			}
		}
		int idx = 0;
		char[][] arr = new char[r][c];
		// row 순서대로 채워야하기 때문에 col 만큼 반복하고
		// row를 증가시키면서 값을 입력하면 위에서 아래로 한줄씩 입력 받는다.
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				arr[j][i] = str.charAt(idx++);
			}
		}
		
		// 한줄로 출력
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
