package b10974_모든순열;

import java.util.Scanner;

public class Main {
	
	static int[] result;
	static boolean[] visited;
	static int N;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		nums = new int[N];
		visited = new boolean[N];
		result = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		perm(0);
	}
	
	static void perm(int idx) {
		if(idx == N) {
			for(int i=0; i<N; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}
