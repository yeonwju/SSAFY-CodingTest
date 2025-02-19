package b14696_딱지놀이;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int A = sc.nextInt();
		int[] cardA = new int[A];
		
		for(int i=0; i<A; i++) {
			cardA[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int[] cardB = new int[B];
		
		for(int i=0; i<B; i++) {
			cardB[i] = sc.nextInt();
		}
		
		//------------------------------------입력 끝
		
		
		//4부터 비교
		for(int i=4; i>0; i--) {
			if(searchNum(cardA, i) || searchNum(cardB, i)) {
				if(countNum(cardA, i) == countNum(cardB, i)) {
					if(A==B && sameCheck(cardA, cardB)) {
						System.out.println("D");
						break;						
					}
					continue;
					
				}else if(countNum(cardA, i) > countNum(cardB, i)) {
					System.out.println("A");
					break;
				}else {
					System.out.println("B");
					break;
				}
			}
			
		}
		
		
	}
	
	//메서드들	
	public static boolean searchNum(int[] arr, int num) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
		
	public static int countNum(int[] arr, int num) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean sameCheck(int[] arr, int[] arr2) {
		for(int i=1; i<=4; i++) {
			if(countNum(arr, i) != countNum(arr2, i)) {
				return false;
			}
		}
		return true;
	}

	
}
