package week6;

import java.util.Scanner;

public class Baekjoon3985 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 롤케이크 길이
		int[] cake = new int[n + 1]; // 입력을 편히 받기 위해 n+1(1부터 시작)
		cake[0] = -1; // 0번 인덱스 케이크는 못 먹는 것 처리

		int cus = sc.nextInt(); // 방청객 수
		int count = 0; // 케이크 조각 수
		int who = 0; // 지금 제일 많은 케이크 조각을 가진 사람
		int result = 0; // 이전 케이크 조각 저장

		int me = 0; // 많이 받을 거라고 말한 사람
		int gae = 0; // 많이 받을 거라고 말한 사람의 케이크 개수

		for (int i = 1; i <= cus; i++) { // 방청객 수만큼 돌기

			int f = sc.nextInt(); // 시작 조각
			int c = sc.nextInt(); // 끝나는 조각
			int piece = c - f; // 총 조각 개수

			me = gae < piece ? i : me; // 많이 받을 사람 update
			gae = gae < piece ? (c - f) : gae; // 많이 받을 사람의 조각 개수 update
			count = 0; // 케이크 조각 개수 초기화

			for (int j = f; j <= c; j++) { // 케이크 조각 시작부터 끝까지 돌기
				if (cake[j] == 0) { // 아직 주인이 없는 케이크 조각의 경우 "0"
					cake[j] = i; // 해당 조각에 주인을 새긴다
					count++; // 조각 개수 + 1
				}
			}
			// 만약 이전 케이크 조각 카운트 값(result)보다 지금(count)이 더크면
			// 지금 사람(i)을 저장하고 아니면 이전 사람(who)을 그대로 저장
			who = result < count ? i : who;
			// 현재 기준 가장 큰 조각 개수 저장
			result = result < count ? count : result;
		}
		System.out.println(me);
		System.out.println(who);
	}
}
