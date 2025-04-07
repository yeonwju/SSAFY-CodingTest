package s14555_공과잡초;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			char[] str = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<str.length; i++) {
				stack.push(str[i]);
			}
			

			int ball = 0;
			while(!stack.isEmpty()) {
				char a = stack.pop();
				
				if(a == '(') {
					ball++;
				}else if(a == ')' && stack.peek() == '(') {
					ball++;
					stack.pop();
				}else if(a == ')' && stack.peek() != '(') {
					ball++;
				}else {
					continue;
				}
				
			}
			
			System.out.println("#"+t+" "+ball);
		}
	}
}
