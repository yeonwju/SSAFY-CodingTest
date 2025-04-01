package Week6;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10816 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[N];
		for(int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] card2 = new int[M];
		for(int i = 0; i < M; i++) {
			card2[i] = sc.nextInt();
		}
		Arrays.sort(card);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			sb.append(count(card, card2[i]) + " ");
		}
		System.out.println(sb);
	}
	
	static int count(int[]arr, int target) {
		int first = FirstNum(arr, target);
		if(first == -1) { // 못찾았으면 0을 return
			return 0;
		}
		int last = LastNum(arr,target);
		// 인덱스의 차이를 구한뒤 1을 더해서 카운팅해준다.
		return last - first + 1;
	}
	
	static int FirstNum(int[]arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		
		while(left <= right) {
			// 중간값
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				// result에 인덱스를 저장
				result = mid;
				// rigth를 mid - 1로 바꿔서 왼쪽 끝까지 가게한다.
				right = mid - 1;
			}else if(arr[mid] < target) {
				// target보다 작으면 오른쪽을 찾아야하니 left 값을 조정
				left = mid + 1;
			}else {
				// target보다 크면 왼쪽을 찾아야하니 right 값을 조정
				right = mid - 1;
			}
		}
		return result;
	}
	static int LastNum(int[]arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				result = mid;
				// 오른쪽 끝까지 가게한다.
				left = mid + 1;
			}else if(arr[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return result;
	}
}
