package week9;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10829 {
	
	static long n, rest, share; //n, 나머지, 몫
	static Stack stack = new Stack(); // 선입후출
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		n = sc.nextLong();
		rest = 2; //아래 조건문에서 걸리지 않기 위해 2로 초기화
		share = 2; //아래 조건문에서 걸리지 않기 위해 2로 초기화
		
		nums(n);
		
		//쌓이는 순서 (1번째 나머지, 2번째 나머지 .... 마지막 몫)
		//스택에서 꺼내기(마지막 몫... 2번째 나머지, 1번째 나머지)
		while(!stack.isEmpty()) { 
			System.out.print(stack.pop());
		}	
	}
	
	static void nums(long n) {
		
		if(share < 2) { //남은 몫이 2 미만일 경우 더이상 변환할 수 없으므로 몫 stack에 저장
			stack.add(share);
			return; //종료
		}
		
		rest = n % 2; //나머지
		share = n / 2; //몫
		stack.add(rest); //나머지 stack에 저장
		
		nums(share); //2로 나눈 몫으로 다음 단계 진행
	}
	
}
