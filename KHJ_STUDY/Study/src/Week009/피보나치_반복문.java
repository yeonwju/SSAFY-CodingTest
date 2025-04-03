package Week009;

import java.util.Arrays;

public class 피보나치_반복문 {
	public static void main(String[] args) {
		int N = 45;
		int[] arr = new int[N];
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i < N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(Arrays.toString(arr));
	}
}
