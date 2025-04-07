package Week005;

import java.util.Scanner;

public class Boj_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 롤케이크 길이
		int N = sc.nextInt();
		// 방청객 수
		int a = sc.nextInt();
		
		int[] cake = new int[N];
		// 내가 원래 생각했던 가장 많이 받을 수 있는 크기
		int max = 0;
		// 방청객 번호 저장용 값
		int idx = 0;
		for(int i = 0; i < a; i++) {
			// 케이크를 받을 범위
			int p = sc.nextInt();
			int k = sc.nextInt();
			
			int temp = k - p + 1;
			if(max < temp) {
				max = temp;
				// 방청객 번호 저장
				idx = i+1;
				
			}
			
			for(int m = (p - 1); m < k; m++) {
				// cake배열에 값이 0이면 방청객 번호를 저장
				if(cake[m] == 0) {
					cake[m] = i+1;					
				}
			}
		}
		// max 초기화
		max = 0;
		// 케이크를 가장 많이 받아가는 사람을 찾기위한 idx2 변수
		int idx2 = 0;
		for(int k = 0; k < a; k++) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				// 방청객번호와 일치할때마다 cnt 값을 증가
				if(cake[i] == k+1) {
					cnt++;
				}
			}
			// cnt가 max보다 크면 idx2에 방청객 번호를 넣고 max값도 바꿔준다.
			if(max < cnt) {
				max = cnt;
				idx2 = k+1;
			}
		}
		System.out.println(idx);
		System.out.println(idx2);
		
	}
}

