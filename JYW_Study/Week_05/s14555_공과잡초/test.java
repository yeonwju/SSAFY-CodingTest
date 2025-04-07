package s14555_공과잡초;

import java.util.Scanner;
import java.util.Stack;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length; i++) {
			stack.push(str[i]);
		}
		
		
		
		
		int ball = 0;
//		int j = 0;
		while(!stack.isEmpty()) {
			char a = stack.pop();
//			System.out.println(a+" "+stack.peek());
			
			if(a == '(') {
				ball++;
				System.out.println("가"+ j++);
			}else if(a == ')' && stack.peek() == '(') {
				ball++;
				stack.pop();
				System.out.println("나"+ j++);
			}else if(a == ')' && stack.peek() != '(') {
				ball++;
			}else {
				System.out.println("다"+ j++);
				continue;
			}
			
			System.out.println("공의 갯수"+ ball);
		}
		
	}
}
