package b6603_로또;

import java.util.Scanner;

public class Main {
	
	static int k;
	static int[] arr, sel;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		while(true) {
			k = sc.nextInt();
			
			if(k == 0) break;
			
			arr = new int[k];
			sel = new int[6];
			
			for(int i=0; i<k; i++) {
				arr[i] = sc.nextInt();
			}
			
			comb(0, 0);
			System.out.println();
			
		}
			
		
	}//main

	
	static void comb(int idx, int sidx) {
		
		if(sidx == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(idx == k) {
			return;
		}
		
		sel[sidx] = arr[idx];
		comb(idx+1, sidx+1);
		
		comb(idx+1, sidx);
		
		
	}
	
	
}
