package week7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon2164{
	public static void main(String[] args) {
		
		Deque<Integer> dq = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num = 1;
		
		for(int i = 0; i < n; i++) {
			dq.add(num++);
		}
		
		while(dq.size() != 1) { // 하나가 남을때까지 반복
		dq.pollFirst(); //첫번째 삭제
		int temp = dq.pollFirst(); // 첫번째 꺼내기
		dq.addLast(temp); // 제일 마지막에 넣기
		}
		
		System.out.println(dq.peek());	
	}
}
