package week8;

import java.util.Scanner;

public class Baekjoon1182 {
	
	static int n;
	static int s;
	static int[] arr;
	static int count;
	
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 1~n
		s = sc.nextInt(); //합
		arr = new int[n]; // 수열 정보
		count = 0; //개수
		
		for(int i =0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		arrSum(0, 0);
		System.out.println(count);
		
	}
	
	static void arrSum(int idx, int result) {
	    if (idx >= n) {
	        return;
	    }

	    // 합이 목표 값과 같다면 count 증가
	    if (result + arr[idx] == s) {
	        count++;
	    }

	    // 현재 원소를 포함하는 경우
	    arrSum(idx + 1, result + arr[idx]);

	    // 현재 원소를 포함하지 않는 경우
	    arrSum(idx + 1, result);
	}

}
