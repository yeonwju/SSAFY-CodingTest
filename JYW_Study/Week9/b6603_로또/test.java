package b6603_로또;

import java.util.Scanner;

public class test {
	
	static int k;
	static int[] result;
	static int[] arr;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();
			
			if(k == 0) break;
			
			arr = new int[k];
			visited = new boolean[k];
			result = new int[k];
			
			
			for(int i=0; i<k; i++) {
				arr[i] = sc.nextInt();
			}
			
			perm(0);
			
		}
		
		
		
		
	}//main
	
	static void perm(int idx) {
		if(idx == k) {
			for(int i=0; i<k; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		}
		
		for(int i=0; i<k; i++) {
			if(visited[i]) continue;
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
			
		}
		
	}
	
	
}
