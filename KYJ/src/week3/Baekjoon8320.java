package week3;

import java.util.Scanner;

public class Baekjoon8320 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int row = 1; //행 값
		int column = 1; //열 값
		int count = 0; //만들 수 있는 직사각형 수
		
		//(1,1)..(1,num),(2,2)..(2, num/2)...
		//행 값이 1증가 할때마다 열이 1부터 다시 시작한다면 이전에 만든 직사각형과 모양이 겹친다
		//열 값은 무조건 현재 행 값부터 시작해야한다
		//행 값*열 값이 입력받은 수보다 작은 경우까지만 진행한다
		while (num >= row * column) { 
			column++; //열값을 증가시킨다
			count++;  //만들 수 있는 직사각형 모양 1개 증가			 
			if (column > (num / row)) { // 입력받은 수를 행값으로 나눈 몫이 현재 열값보다 작아지면 
				row++; //열값이 아니라 행값을 증가시킨다
				column = row; //열값 현재 행값으로 초기화
			}
		}
		System.out.println(count);
	}
}
