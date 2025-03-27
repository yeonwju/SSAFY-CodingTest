package week9;

import java.util.*;

public class Baekjoon3986 {
	/*
	 * 스택 사용 제일 처음 값 stack push 그 다음 넣을 값이 stack 최상단에 있는 값과 같다면 pop -> 반복 값을 다 처리했을
	 * 때 stack이 비어있다면 좋은 단어, 비어있지 않으면 나쁜 단어 같은 A/B가 인접해 있다면 교차하지 않으므로 좋은 단어이고
	 * 떨어져있더라도 그 사이에 있는 같은 값이 인접해 있다면 서로 교차하지 않음 (ABBA)
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 단어 수
		int count = 0; // 좋은 단어 카운트
		sc.nextLine();

		// 단어수만큼 반복
		for (int i = 0; i < n; i++) {
			String[] st = sc.nextLine().split("");  //단어 입력 받기
			Stack stack = new Stack(); //새로운 단어 시작할때마다 다시 생성
			String tmp = st[0]; // 제일 처음 값 꺼내서
			stack.push(tmp); //스택에 넣기
			
			for (int j = 1; j < st.length; j++) {
				
				if (stack.empty()) { //스택이 비어있다면
					stack.push(st[j]); //지금 값을 넣고
				} else if (!stack.empty()) { //스택이 비어있지 않으면
					String pk = (String) stack.peek(); //스택 최상단에 있는 값을 꺼내보고
					if (st[j].equals(pk)) { // 지금 값과 스택 최상단 값이 같다면
						stack.pop(); // 스택에서 꺼내고
					} else { // 아니라면
						stack.push(st[j]); // 스택에 넣기
					}
				}
			}

			if (stack.empty()) { // 단어 탐색이 끝나고 스택이 비어있다면 좋은 단어이므로 count++
				count++;
			}
		}
		System.out.println(count);
	}
}
