package Week006;

import java.util.Scanner;

public class Boj_11650 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();
		}
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - 1 - i; j++) {
				if(arr[1][j] > arr[1][j + 1]) {
					int temp = arr[1][j];
					arr[1][j] = arr[1][j + 1];
					arr[1][j + 1] = temp;
					
					temp = arr[0][j];
					arr[0][j] = arr[0][j + 1];
					arr[0][j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - 1 - i; j++) {
				if(arr[0][j] > arr[0][j + 1]) {
					int temp = arr[0][j];
					arr[0][j] = arr[0][j + 1];
					arr[0][j + 1] = temp;
					
					temp = arr[1][j];
					arr[1][j] = arr[1][j + 1];
					arr[1][j + 1] = temp;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[0][i] + " ").append(arr[1][i] +"\n");
		}
		System.out.println(sb);
	}
	
	
}
