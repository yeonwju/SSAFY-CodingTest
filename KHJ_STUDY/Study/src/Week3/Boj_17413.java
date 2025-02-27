package Week3;

import java.util.Scanner;
import java.util.Stack;

public class Boj_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		String S = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		
		for(int i = 0; i < S.length(); i++) {
			// <를 만나면 여태까지 스택에 쌓아둔 것들을 pop해서 sb에 붙여준다.
			if(S.charAt(i) == '<') {
				// stack이 비어있으면 flag를 true로 바꾼다.
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				flag = true;
			}else if(S.charAt(i) == '>') {
				// > 를 넣어준다.
				sb.append(S.charAt(i));
				// flag를 초기화
				flag = false;
				// continue 안하면 아래 flag로 들어가서 꼬임
				continue;
			}
			
			// flag가 true이면 <를 만났다는 뜻이니 sb에 그대로 문자를 넣는다.
			if(flag == true) {
				sb.append(S.charAt(i));
			// flag가 false일 경우는 >를 만나서 다시 문자를 역으로 넣어야하거나
			// <를 아예 못만나서 문자를 역으로 넣어야함.
			}else if(flag == false) {
				// 공백이 아니면 stack에 문자를 쌓는다.
				if(S.charAt(i) != ' ') {
					stack.push(S.charAt(i));
				}else if(S.charAt(i) == ' ') {
					// 스택이 비어질때까지 pop해서 문자열에 추가
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					// 공백을 넣어줘야 형태가 맞음
					sb.append(' ');
				}
			}
			// 마지막이면 스택에 남은걸 다 털어준다.
			if(i == S.length() - 1) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
			
		}
		System.out.println(sb);
	}
}

