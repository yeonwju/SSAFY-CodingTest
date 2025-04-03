package Week004;

import java.util.Scanner;

public class SWEA_14555 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			char[] arr = new char[str.length()];
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			// 누적 변수
			int cnt = 0;
			
			for(int i = 0; i < str.length(); i++) {
				// (를 만났을때 다음 칸이 )이거나 |이면 공이 되니까 누적 변수 증가
				if(arr[i] == '(') {
					if(arr[i + 1] == ')' || arr[i + 1] == '|') {
						cnt++;
						i++;
					}
					// )를 만났을때 이전 칸이 (이거나 |이면 공이 되니까 누적 변수 증가
				}else if(arr[i] == ')') {
					if(arr[i - 1] == '(' || arr[i - 1] == '|') {
						cnt++;
					}
				}
				// if문을 만날때마다 i를 증가시켜야 하는 이유는
				// i값이 증가를 안하면 ()로 표현된 공을 만나버리면 if문에서 누적 변수를 증가시키고
				// else if로 또 누적 변수가 증가해서 중첩된다.
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
