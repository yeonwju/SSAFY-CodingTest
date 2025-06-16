package s1979_어디에단어가들어갈수있을까;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
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
					if(numbers[i][j] == 1) {//1이면
						stack.push(1);
					}else {//0이면
						if(stack.size() == K) {
							x++;
							stack.clear();
						}else {
							stack.clear();							
						}
					}
					
				}
				if(stack.size() == K) {
					x++;
				}
				stack.clear();
			}
			
			//세로줄
			int y = 0;
			for(int j=0; j<N; j++) {//행 고정
				for(int i=0; i<N; i++) {
					if(numbers[i][j] == 1) {
						stack.push(1);
					}else {
						if(stack.size() == K) {
							y++;
							stack.clear();
						}else {
							stack.clear();							
						}
					
					}
				}
				if(stack.size() == K) {
					y++;
				}
				stack.clear();
			}
			
			int ans = x+y;
			
			System.out.println("#"+t+" "+ans);
		}//for문 끝
	}//main
}
