package b2164_카드2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		
		int x = 0;
		while(!(queue.size()==1)) {
			queue.poll();
			x = queue.peek();
			queue.poll();
			
			queue.offer(x);
		}
		
		System.out.println(queue.poll());
		
	}
}
