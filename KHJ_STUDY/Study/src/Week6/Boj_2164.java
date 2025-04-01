package Week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> qu = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			qu.offer(i);
		}
		
		while(qu.size() != 1) {
			qu.poll();
			qu.offer(qu.poll());
		}
		System.out.println(qu.peek());
	}
}
