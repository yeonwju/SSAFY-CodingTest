package Week009;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치_메모이제이션 {
	static int[] pivo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		pivo = new int[N + 1];
		dfs(N);
		System.out.println(Arrays.toString(pivo));
	}
	static int dfs(int idx) {
		if(pivo[idx] > 0) return pivo[idx];
		
		if(idx == 1 || idx == 2) {
			return pivo[idx] = 1;
		}else {
			return pivo[idx] = dfs(idx - 2) + dfs(idx - 1);
		}
	}
}
