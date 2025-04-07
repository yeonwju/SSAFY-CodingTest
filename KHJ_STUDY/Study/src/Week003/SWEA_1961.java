package Week003;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			String[][] lastarray = new String[N][3];
			int[][] array = arr;
			for(int k = 0; k < 3; k++) {
				// 돌리기
				array = turn(array);
				
				for(int i = 0; i < N; i++) {
					String str = "";
					for(int j = 0; j < N; j++) {
						str += array[i][j];
					}
					lastarray[i][k] = str;
				}
			}
			System.out.println("#" + tc);
			for(int i = 0; i < lastarray.length; i++) {
				for(int j = 0; j < lastarray[i].length; j++) {
					System.out.print(lastarray[i][j] + " ");
				}
				System.out.println();
			}

		}
	}
	public static int[][]turn (int[][]arr) {
		int a = arr.length;
		int[][] arr2 = new int[a][a];
		for(int i = 0; i < a; i++) {
			int k = a-1;
			for(int j = 0; j < a; j++) {
				arr2[i][j] = arr[k][i];
				k--;
			}
		}
		return arr2;
	}
}
