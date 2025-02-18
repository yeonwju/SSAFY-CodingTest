package week4;

import java.util.Scanner;

public class Sw1859 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = sc.nextInt();
			sc.nextLine();
			String[] st = sc.nextLine().split(" ");
			int[] info = new int[n];
			long sum = 0; // 이익 값(무조건 long)
			int idx = info.length - 1; // 뒤에서부터 탐색

			for (int i = 0; i < n; i++) {
				info[i] = Integer.parseInt(st[i]);
			}


	end : for (int i = idx; i >= 0; i--) { //기준 값
			for (int j = i - 1; j >= 0; j--) { //비교 값
					//1. 기준값이 비교값보다 클때
					if (info[i] > info[j]) { 
						// (기준값 - 비교값)인 이익값 누적
						sum += info[i] - info[j]; 
						if(j == 0) { //비교값이 인덱스 0까지 갔다면 계산 끝으로 반복문 종료
							break end;
						}
					//2. 기준값이 비교값보다 작아질때
					} else if (info[i] < info[j]) {
						i = ++j; // 기준값을 현재 비교값으로 바꿔서 탐색 시작하도록 함(++ 하는 이유는 위에서 --가 적용되므로)
						break ; //비교값 반복문 종료 기준값 반복문 시작
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
