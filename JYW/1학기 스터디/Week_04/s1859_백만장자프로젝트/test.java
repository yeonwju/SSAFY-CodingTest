package s1859_백만장자프로젝트;

import java.util.Scanner;
import java.util.Stack;

public class test {
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
				long value = 0;
				
				for(int i=N-1; i>=0; i--) {
					if(max>arr[i]) {
						value += max - arr[i];
					}else {
						max = arr[i];
					}
				}
				
				System.out.println("#" + t +" "+ value);
			}
	  }
}
