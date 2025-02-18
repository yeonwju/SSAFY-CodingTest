package s1859_백만장자프로젝트;

import java.util.Scanner;
import java.util.Stack;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
			
			
			int ans = 0;
			for(int i=0; i<maxIndex; i++) {
				ans += max - arr[i];
			}
			
			
			
			System.out.println(ans);
		}
	}
}
