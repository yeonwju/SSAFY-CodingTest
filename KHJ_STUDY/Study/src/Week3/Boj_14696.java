package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < T; i++) {
			int aA = 0;
			int aB = 0;
			int aC = 0;
			int aD = 0;
			int bA = 0;
			int bB = 0;
			int bC = 0;
			int bD = 0;
			String str1 = sc.nextLine();
			String[] arr1 = str1.split(" ");
			String str2 = sc.nextLine();
			String[] arr2 = str2.split(" ");
			
			for(int k = 0; k < arr1.length; k++) {
				if(arr1[k].equals("4")) {
					aA++;
				}else if(arr1[k].equals("3")) {
					aB++;
				}else if(arr1[k].equals("2")) {
					aC++;
				}else if(arr1[k].equals("1")) {
					aD++;
				}
			}			
			for(int k = 0; k < arr2.length; k++) {
				if(arr2[k].equals("4")) {
					bA++;
				}else if(arr2[k].equals("3")) {
					bB++;
				}else if(arr2[k].equals("2")) {
					bC++;
				}else if(arr2[k].equals("1")) {
					bD++;
				}
			}
			
			if(aA > bA) {
				System.out.println("A");
			}else if(aA < bA) {
				System.out.println("B");
			}else if(aB > bB) {
				System.out.println("A");
			}else if(aB < bB) {
				System.out.println("B");		
			}else if(aC > bC) {
				System.out.println("A");
			}else if(aC < bC) {
				System.out.println("B");
			}else if(aD > bD) {
				System.out.println("A");
			}else if(aD < bD) {
				System.out.println("B");
			}else if(aD == bD) {
				System.out.println("D");	
			}
//			System.out.println("A = " + aA + " B = " + aB + " C = " + aC + " D = " + aD);
//			System.out.println("A = " + bA + " B = " + bB + " C = " + bC + " D = " + bD);
		}
		
	}
}

