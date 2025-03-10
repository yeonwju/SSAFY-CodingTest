package b10816_숫자카드2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		int N = sc.nextInt();
		int[] sang = new int[N];
		
		int M = sc.nextInt();
		int[] sol = new int[M];
		
		for(int i=0; i<N; i++) {
			sang[i] = sc.nextInt();
		}
		
		for(int i=0; i<M; i++) {
			sol[i] = sc.nextInt();
		}
		
		int max=0;
		for(int i=0; i<N; i++) {
			if(sang[i]>max) {
				max = sang[i];
			}
		}
		
		
		
		
		
		
		
	}
}
