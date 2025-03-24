package b2003_수들의합2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		int sum=0;
		int cnt=0;
		for(int i=0; i<N; i++) {//합을 시작하는 기준점 이동
			sum = 0;//합 초기화
			for(int j=i; j<N; j++) {
				sum += A[j];//더하기
				if(sum == M) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
