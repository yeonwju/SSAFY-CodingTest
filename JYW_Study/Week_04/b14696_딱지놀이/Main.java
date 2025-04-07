package b14696_딱지놀이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int t=1; t<=N; t++) {
			int A = sc.nextInt(); // A가 가지고 있는 카드 수
			int[] cardA = new int[A];
			
			for(int i=0; i<A; i++) { // A 카드 입력
				cardA[i] = sc.nextInt();
			}
			
			int B = sc.nextInt(); // B가 가지고 있는 카드 수
			int[] cardB = new int[B];
			
			for(int i=0; i<B; i++) {// B카드 입력
				cardB[i] = sc.nextInt();
			}
			
			//------------------------------------입력 끝
			
			
			for(int i=4; i>0; i--) {// 4부터 비교
				if(searchNum(cardA, i) || searchNum(cardB, i)) {// A, B가 카드 가지고 있는지 확인
					if(countNum(cardA, i) == countNum(cardB, i)) {//카드 갯수가 같으면
						if(A==B && sameCheck(cardA, cardB)) {//모든 카드 갯수가 같은지 확인
							System.out.println("D");// 같으면 비김
							break;						
						}
						continue;//비기는 경우가 아니면 계속
						
					}else if(countNum(cardA, i) > countNum(cardB, i)) {
						System.out.println("A"); // A가 카드 갯수 더 많으면 A가 이김
						break;
					}else {
						System.out.println("B"); // B가 카드 갯수 더 많으면 B가 이김
						break;
					}
				}
				
			}
			
		}// t 반복 끝
		
	}//main 함수 끝
	
	public static boolean searchNum(int[] arr, int num) {// num이 있는지 없는지 확인
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
		
	public static int countNum(int[] arr, int num) {// num이 몇개 들었는지 출력
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean sameCheck(int[] arr, int[] arr2) {// A랑 B가 가지고 있는 카드가 완전히 같은지 확인
		for(int i=1; i<=4; i++) {
			if(countNum(arr, i) != countNum(arr2, i)) {//갯수가 같지 않으면 false
				return false;
			}
		}
		return true;
	}
	
	
}
