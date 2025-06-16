package b2999_비밀이메일;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); //입력
		
		int N = str.length(); // 입력값 길이 구하기 
		
		char[][] ans; //문자 넣을 배열
		
		int r;
		int c;
		
		int max = 0;
		for(int i=1; i<=Math.sqrt(N); i++) {// Math.sqrt 제곱근해서 거기까지 계산하기
			int value = N%i;
			
			if(value == 0) {//N이 i로 떨어지는 값일 경우
				int p = i; //i값을 p에 저장
				
				if(max<p) {
					max = p; //max값 갱신
				}
			}
		}
		
		r = max;//r값이 c보다 더 크니까
		c = N/max;//r*c=N이니까
		
//		System.out.println(r+" "+c);
		
		ans = new char[r][c]; // 배열 크기 설정해서 선언
		
		int k=0;
		for(int j=0; j<c; j++) {//열고정 세로 입력
			for(int i=0; i<r; i++) {
				ans[i][j] = str.charAt(k);
				k++;
			}
		}
		
		for(int i=0; i<r; i++) {//행고정 가로 출력
			for(int j=0; j<c; j++) {
				System.out.print(ans[i][j]);
			}
		}
		
	}
}
