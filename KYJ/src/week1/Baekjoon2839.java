package week1;

import java.util.Scanner;

public class Baekjoon2839 {

	public static void main(String[] args) {

		// 설탕 배달

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int five = num / 5;
		int fiveResult = num % 5;
		
		switch(fiveResult) {
		
		case 0 :
		
		System.out.println(five);
		break;
		
		case 1 : 
			
			System.out.println(five -1 + 2);
			break;
		case 2 : 
			
			System.out.println(-1);
			break;
			
		case 3 : 
			
			System.out.println(five + 1);
			break;
		
		case 4 :
			
			System.out.println(five -1  + 3);
			break;
		
		}

		sc.close();
	}

}
