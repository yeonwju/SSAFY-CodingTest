package Week009;

import java.util.Scanner;
import java.util.Stack;

public class Boj_3986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			stack.push(str.charAt(0)); // 0번째 미리 넣기
			for(int j = 1; j < str.length(); j++) {
				if(!stack.isEmpty()) { // 스택이 안비어있다면
					if(stack.peek() == str.charAt(j)) { // 스택에 쌓인 값과 str의 값이 같다면 pop
						stack.pop();
					}else {
						stack.push(str.charAt(j)); // 아니면 push
					}
				}else {
					// 스택이 비어있다면 push
					stack.push(str.charAt(j));
				}
			}
			if(stack.isEmpty()) { // 비어있으면 좋은 단어이니 카운트 증가
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

