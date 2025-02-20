import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			String s = sc.nextLine();
			StringBuilder sb = new StringBuilder(); //뒤집는 문자를 저장하는 곳
			Stack<Character> stack = new Stack<>();
			
			int index = 0;

			while(index<s.length()) {// 입력받은 문자열이 끝날때까지
				if(s.charAt(index) == '<') {//<>안에들어 있는거는 뒤집지 않음
					while(true) {
						sb.append(s.charAt(index++));
						if(s.charAt(index) == '>') {//닫히는 >을 만나기 전까지 문자는 뒤집지 않고 입력
							sb.append(s.charAt(index));
							index++;//다음 index로 넘어가기
							break;
						}
					}
				}
				else if(s.charAt(index) == ' ') {//빈칸은 그대로 입력
					sb.append(' ');
					index++;
				}
				else {
					while(index<s.length() && s.charAt(index) !=' ' && s.charAt(index)!='<') {//<가 아닌 문자를 만나면 스택에 넣어주기
						stack.push(s.charAt(index++));
					}
					while(!stack.isEmpty()) {//스택에 문자가 들어있으면 빼내서 붙이기
						sb.append(stack.pop());
					}
				}
			}
			
			System.out.println(sb.toString());
			
	}
}
