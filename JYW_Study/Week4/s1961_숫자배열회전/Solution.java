package s1961_숫자배열회전;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++){
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}// 배열 입력
			
			int[][] first = new int[N][N];
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>=0; i--) {
					first[j][N-1-i] = arr[i][j];
				}
			}
			
			int[][] second = new int[N][N];
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>=0; i--) {
					second[j][N-1-i] = first[i][j];
				}
			}
			
			int[][] third = new int[N][N];
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>=0; i--) {
					third[j][N-1-i] = second[i][j];
				}
			}
			
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(first[i][j]);					
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(second[i][j]);					
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(third[i][j]);					
				}
				System.out.println();
			}

		}
	}
}
