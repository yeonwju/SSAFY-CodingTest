package week4;

import java.util.Scanner;

public class Sw1961 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int num = sc.nextInt();
			int[][] arr = new int[num][num]; //원본
			sc.nextLine();

			for (int i = 0; i < num; i++) {
				String[] st = sc.nextLine().split(" ");
				for (int j = 0; j < num; j++) {
					arr[i][j] = Integer.parseInt(st[j]);
				}
			}

			int[][] Sarr = new int[num][num]; //90도 회전
			
			//1열 (num-1)~0행, 2열 (num-1)~0행, 3열 (num-1)~0행 순서로 저장
			for (int i = 0; i < num; i++) {  
				for (int j = num - 1; j >= 0; j--) {
					Sarr[i][num - j - 1] = arr[j][i];
				}
			}

			int[][] Sarr2 = new int[num][num];

			for (int i = 0; i < num; i++) { //180도 회전
				for (int j = num - 1; j >= 0; j--) {
					Sarr2[i][num - j - 1] = Sarr[j][i];
				}
			}
			
			int[][] Sarr3 = new int[num][num];

			for (int i = 0; i < num; i++) { //270도 회전
				for (int j = num - 1; j >= 0; j--) {
					Sarr3[i][num - j - 1] = Sarr2[j][i];
				}
			}
			System.out.println("#" + test_case);
			
			//90도 회전 1행 1~(num-1)열 , 180도 1행 1~(num-1)열, 270도 1행 1~(num-1)열 출력
			//180도..
			//270도..
			for(int i =0; i < num; i++) {
				for(int j =0; j < num; j++) {
					System.out.print(Sarr[i][j]);
				}
				System.out.print(" ");
				for(int j =0; j < num; j++) {
					System.out.print(Sarr2[i][j]);
				}
				System.out.print(" ");
				for(int j =0; j < num; j++) {
					System.out.print(Sarr3[i][j]);
				}
				System.out.println();
			}	
		}
	}
}
