package week11;

import java.util.Scanner;
 
public class Baekjoon1929 {
	public static boolean[] prime;
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		
		prime = new boolean[N + 1];
		get_prime();
				
		for(int i = M; i <= N; i++) {
			// false = 소수 
			if(!prime[i]) System.out.println(i);
		}
	}
 
 
	// 에라토스테네스의 체 알고리즘
	public static void get_prime() {
		// true = 소수아님 , false = 소수 
		//0과 1인 소수가 아님
		prime[0] = true; 
		prime[1] = true; 
		//어떤 수 n이 합성수라면, 반드시 √n 이하의 어떤 수 a와 곱해서 만들어진 수
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue; //소수가 아니라고 판단된 수는 패스
			//초기 값을 i*i로 잡은 이유는 i*i 이하의 값은 이미 이전 작업에서 처리
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}