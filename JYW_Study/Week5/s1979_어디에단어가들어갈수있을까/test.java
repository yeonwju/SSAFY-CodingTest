package s1979_어디에단어가들어갈수있을까;

import java.util.Scanner;
import java.util.Stack;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] numbers = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					numbers[i][j] = sc.nextInt();
				}
			}//입력 끝
			
			Stack<Integer> stack = new Stack<>();
			
			//가로줄
			int x = 0;
			for(int i=0; i<N; i++) {//행 고정
				for(int j=0; j<N; j++) {
					if(numbers[i][j] == 1) {
						stack.push(1);
					}else {
						if(stack.size() == K) {
							x++;
						}
					stack.clear();
					}
				}
				if(stack.size() == K) {
					x++;
				}
			}
			
			System.out.println(x);
			
			//세로줄
			int y = 0;
			for(int j=0; j<N; j++) {//행 고정
				for(int i=0; i<N; i++) {
					if(numbers[i][j] == 1) {
						stack.push(1);
					}else {
						stack.clear();
					}
					
				}
				if(stack.size() == K) {
					y++;
				}
			}
			
			System.out.println(y);
			
			int ans = x+y;
			
			System.out.println(ans);
	}//main
}
