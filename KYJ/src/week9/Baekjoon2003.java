package week9;

import java.util.Scanner;

public class Baekjoon2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수열의 길이
		int m = sc.nextInt(); // 목표 합
		int[] arr = new int[n]; // 수열 저장 배열

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		int sum = 0;
		int start = 0;

		// 투 포인터 알고리즘 적용
		for (int end = 0; end < n; end++) { // 가변길이 수열 합

			sum += arr[end]; // 아래 조건에 걸리지 않을 경우 end++ 값 계속 더하기

			while (sum > m && start <= end) { // 합이 목표값을 넘어서면서 start가 end를 넘지않는 경우
				sum -= arr[start]; // 현재 합에서 start값을 빼고
				start++; // start++
			}

			if (sum == m) { // 목표값일 경우 카운트 증가
				count++;
			}

		}

		System.out.println(count);
	}
}
