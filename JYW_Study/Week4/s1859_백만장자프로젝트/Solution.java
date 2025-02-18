package s1859_백만장자프로젝트;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max=0;
			int maxIndex = 0;
			for(int i=0; i<N; i++) {
				if(max<arr[i]) {
					max = arr[i];
					maxIndex = i;
				}
			}
			
			Stack<Integer> stack = new Stack<>();
			
			for(int i=N-1; i>=0;i++) {
				stack.add(arr[i]);
				if(i == maxIndex) break;
			}
			
			int ans = 0;
			for(int i=0; i<N; i++) {
				ans += stack.peek()- arr[i];
				if(i==maxIndex) {
					stack.pop();
					for(int j=maxIndex; j<N; j++) {
						max = arr[j];
						maxIndex = j;
					}
				}
			}
			
			
			
			
			System.out.println("#"+t+" "+ ans);
		}
	}
}
